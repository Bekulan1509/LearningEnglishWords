package com.twodev.learningenglishwords.ui.ItemsActivity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.twodev.learningenglishwords.R
import com.twodev.learningenglishwords.showToast
import com.twodev.learningenglishwords.ui.ItemsActivity.adapter.AdapterItems
import com.twodev.learningenglishwords.ui.ItemsActivity.adapter.NoScrollLinearLayoutManager
import com.twodev.learningenglishwords.ui.PutDataActivity.PutDataActivity
import com.twodev.models.ItemModel
import org.koin.android.ext.android.inject


class ItemsActivity : AppCompatActivity() {
    private lateinit var adapter: AdapterItems
    private lateinit var recyler: RecyclerView
    private var adapterPosition: Int = 0
    val viewModel by inject<ItemsViewModel>()
    lateinit var nextBtn: Button
    lateinit var previousBtn: Button
    var itemCount: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)
        nextBtn = findViewById(R.id.next_btn)
        previousBtn = findViewById(R.id.previous_btn)

        setUpAdapter()
        viewClicked()

    }

    fun setUpAdapter() {
        adapter = AdapterItems(this::onItemClick, fun(item: ItemModel) {
            Log.d("tag1", "deleteItem: $item")
            viewModel.delateItem(item)
            getWords()
        })
        recyler = findViewById(R.id.recycler_item)
        val snapHelper: SnapHelper? = PagerSnapHelper()
        snapHelper?.attachToRecyclerView(recyler)
        recyler.adapter = adapter

        recyler.layoutManager = NoScrollLinearLayoutManager(this)
        (recyler.layoutManager as NoScrollLinearLayoutManager).disableScrolling()

        getWords()
    }

    private fun onItemClick(v: View, pos: Int) {
        adapterPosition = pos
    }


    fun viewClicked() {

        val fab: View = findViewById(R.id.fab)

        fab.setOnClickListener {
            val intent = Intent(this, PutDataActivity::class.java)
            startActivityForResult(intent, 1)
        }


        nextBtn.setOnClickListener {
            recyler.scrollToPosition(adapterPosition + 1)
            adapter.notifyDataSetChanged()
            if (adapterPosition != itemCount) adapterPosition++
            else showToast("Last item")
        }
        previousBtn.setOnClickListener {
            recyler.scrollToPosition(adapterPosition - 1)
            adapter.notifyDataSetChanged()
            if (adapterPosition > 0) adapterPosition--
            else showToast("first item")
        }
    }

    fun getWords() {
        viewModel.apply {
            fetchGetWords()
            itemWordsLiveData.observeForever {
                adapter.addItems(it)
                itemCount = it.size
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data == null) return
        else {
            val word = data.getStringExtra("name")
            val word2 = data.getStringExtra("name2")
            Log.d("tag1", "onActivityResult: ${word.toString()}")
            Log.d("tag1", "onActivityResult: ${word2.toString()}")

            viewModel.fetchWords(
                ItemModel(
                    word1 = word.toString(),
                    word2 = word2.toString()
                )
            )
            getWords()
        }
    }

}
