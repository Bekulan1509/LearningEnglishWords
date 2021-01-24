package com.twodev.learningenglishwords.ui.mainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputLayout
import com.twodev.learningenglishwords.ui.mainActivity.adapter.AdapterMain
import com.twodev.learningenglishwords.R
import com.twodev.models.ItemMainModel
import org.koin.android.ext.android.inject
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.PagerSnapHelper

import androidx.recyclerview.widget.SnapHelper


class MainActivity : AppCompatActivity() {
    private lateinit var adapter: AdapterMain
    private lateinit var recyler: RecyclerView
    private var adapterPosition: Int = 0
    private lateinit var textInputLayout: TextInputLayout
    val viewModel by inject<MainViewModel>()
    private lateinit var translatedWordIL: TextInputLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewClicked()
        setUpAdapter()

    }

    fun setUpAdapter() {
        adapter = AdapterMain(this::onItemClick, fun(item: ItemMainModel) {
            android.util.Log.d("tag1", "deleteItem: $item")
            viewModel.delateItem(item)
            getWords()
        })
        recyler = findViewById(R.id.recycler_main)
        val snapHelper: SnapHelper? = PagerSnapHelper()
        snapHelper?.attachToRecyclerView(recyler)
        recyler.adapter = adapter
        getWords()
    }

    private fun onItemClick(v: View, pos: Int) {
        adapterPosition = pos
    }


    fun viewClicked() {
        val layoutRecyclerCNST: View = findViewById(R.id.recycler_container_cnst)
        val layoutAddingCNST: View = findViewById(R.id.adding_container_cnst)
        val skipBtn: Button = findViewById(R.id.skip_btn)

        textInputLayout = findViewById(R.id.textField)
        translatedWordIL = findViewById(R.id.textField2)

        val addBTN: Button = findViewById(R.id.add_btn)
        val fab: View = findViewById(R.id.fab)

        fab.setOnClickListener {
            layoutRecyclerCNST.visibility = View.GONE
            layoutAddingCNST.visibility = View.VISIBLE
        }

        addBTN.setOnClickListener {
            viewModel.fetchWords(
                ItemMainModel(
                    word1 = textInputLayout.editText?.text.toString(),
                    word2 = translatedWordIL.editText?.text.toString()
                )
            )
            getWords()
            layoutRecyclerCNST.visibility = View.VISIBLE
            layoutAddingCNST.visibility = View.GONE
        }
        skipBtn.setOnClickListener {
            recyler.scrollToPosition(adapterPosition+1)
            adapter.notifyDataSetChanged()
        }
    }

    fun getWords() {
        viewModel.fetchGetWords()
        viewModel.itemWordsLiveData.observeForever {
            adapter.addItems(it)
        }
    }

}