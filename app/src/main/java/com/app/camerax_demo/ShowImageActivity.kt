package com.app.camerax_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.camerax_demo.databinding.ActivityShowImageBinding
import android.R
import android.content.Context
import android.content.Intent
import android.net.Uri


class ShowImageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShowImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.extras?.getString("path")?.let {
            val path: Uri = Uri.parse(it)
            binding.capturedImageView.setImageURI(path)
        }
    }


    companion object {

        @JvmStatic
        fun newIntent(context: Context, path: String): Intent {
            var intent = Intent(context, ShowImageActivity::class.java)
            intent.putExtra("path", path)
            return intent
        }

    }
}