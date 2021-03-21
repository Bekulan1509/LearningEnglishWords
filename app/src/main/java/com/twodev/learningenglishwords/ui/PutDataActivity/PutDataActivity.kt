package com.twodev.learningenglishwords.ui.PutDataActivity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.twodev.learningenglishwords.databinding.ActivityPutDataBinding
import com.twodev.learningenglishwords.showToast
import org.koin.android.ext.android.inject

class PutDataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPutDataBinding
    val viewModel by inject<PutDataViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPutDataBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        viewClicked()
    }

    private fun viewClicked() {

        binding.addBtn.setOnClickListener {
            if (binding.textField.editText.toString() == "" || binding.textField2.editText.toString() == "") {
                showToast(
                    "Fill in EditText"
                )
            } else {
                val word1: String = binding.textField.editText?.text.toString()
                val word2 = binding.textField2.editText?.text.toString()

                Intent().apply {
                    putExtra("name", word1)
                        .putExtra("name2", word2)
                    Log.e("tag1", "viewClicked: $word1")
                    Log.e("tag1", "viewClicked: $word2")
                    setResult(RESULT_OK, this)
                    finish()
                }

            }
        }
    }
}