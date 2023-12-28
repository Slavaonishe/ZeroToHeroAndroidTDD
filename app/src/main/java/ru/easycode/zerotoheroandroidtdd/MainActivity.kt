package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
   // private var isTitleTextViewHidden: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.hideButton.setOnClickListener{
            binding.titleTextView.visibility = View.GONE
        }



        /*
        // Восстановление состояния видимости titleTextView после уничтожения активности
        if (savedInstanceState != null) {
            isTitleTextViewHidden = savedInstanceState.getBoolean("isTitleTextViewHidden", false)
            if (isTitleTextViewHidden) {
                binding.titleTextView.visibility = View.GONE
            }
        }

        binding.hideButton.setOnClickListener {
            // Изменение видимости titleTextView при нажатии
            if (binding.titleTextView.visibility == View.VISIBLE) {
                binding.titleTextView.visibility = View.GONE
                isTitleTextViewHidden = true
            } else {
                binding.titleTextView.visibility = View.VISIBLE
                isTitleTextViewHidden = false
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Сохранение состояния видимости titleTextView перед уничтожением активности
        outState.putBoolean("isTitleTextViewHidden", isTitleTextViewHidden)

        */
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    outState.putInt("key",binding.titleTextView.visibility)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        binding.titleTextView.visibility=savedInstanceState.getInt("key")
    }
}