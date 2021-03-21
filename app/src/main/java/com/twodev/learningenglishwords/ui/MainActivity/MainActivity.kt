package com.twodev.learningenglishwords.ui.MainActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.twodev.learningenglishwords.R
import com.twodev.learningenglishwords.databinding.ActivityMainBinding
import com.twodev.learningenglishwords.databinding.ActivityPutDataBinding
import com.twodev.learningenglishwords.showToast
import com.twodev.learningenglishwords.ui.ItemsActivity.ItemsViewModel
import com.twodev.learningenglishwords.ui.ItemsActivity.adapter.AdapterItems
import com.twodev.learningenglishwords.ui.MainActivity.adapters.AdapterMain
import com.twodev.learningenglishwords.ui.PutDataActivity.PutDataActivity
import com.twodev.learningenglishwords.ui.PutTitleActivity.PutTitleActivity
import com.twodev.models.ItemMainModel
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val viewModel by inject<MainViewModel>()
    private lateinit var adapter: AdapterMain
    private lateinit var recyler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setUpAdapter()
        viewClicked()
    }

    private fun viewClicked() {
        binding.fab.setOnClickListener{
            startActivityForResult(Intent(this, PutTitleActivity::class.java),1)

        }
    }

    private fun setUpAdapter() {
        adapter = AdapterMain()
        recyler = findViewById(R.id.recycler_main)
        recyler.adapter = adapter

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data==null) return
        else{
            val title = data.getStringExtra("title")
            showToast(title.toString())
        }
    }
}