package com.twodev.learningenglishwords.ui.PutTitleActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.twodev.learningenglishwords.R
import com.twodev.learningenglishwords.databinding.ActivityPutTitleBinding
import com.twodev.learningenglishwords.showToast

class PutTitleActivity : AppCompatActivity() {

    private lateinit var bind: ActivityPutTitleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityPutTitleBinding.inflate(layoutInflater)
        val view = bind.root
        setContentView(view)
        viewClicked()
    }

    private fun viewClicked() {
        bind.addBtn.setOnClickListener {

            if (bind.textField.editText?.text.toString() == "") showToast("Fill in ")
            else {
                Intent().apply {
                    putExtra("title", bind.textField.editText?.text.toString())
                    Log.d("tag1", "viewClicked: ${bind.textField.editText?.text.toString()}")
                    setResult(RESULT_OK, this)
                    finish()
                }
            }
        }
    }

}