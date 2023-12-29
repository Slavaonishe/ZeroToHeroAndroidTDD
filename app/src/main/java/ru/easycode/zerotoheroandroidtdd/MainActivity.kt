package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding
import java.io.Serializable
import java.lang.Thread.State

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    //private var isTitleTextViewHidden: Boolean = false
    private lateinit var rootLayout : LinearLayout
    private lateinit var titleTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rootLayout = binding.rootLayout
        titleTextView = binding.titleTextView

        binding.removeButton.setOnClickListener{
            rootLayout.removeView(titleTextView)
        }



        /*

        // Восстановление состояния видимости titleTextView после уничтожения активности
        if (savedInstanceState != null) {
            isTitleTextViewHidden = savedInstanceState.getBoolean("isTitleTextViewHidden", false)
            if (isTitleTextViewHidden) {
                binding.rootLayout.removeView(binding.titleTextView)
            }
        }

        binding.removeButton.setOnClickListener {
            // Изменение видимости titleTextView при нажатии
            if (binding.titleTextView.visibility == View.VISIBLE) {
                binding.rootLayout.removeView(binding.titleTextView)
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
       val removedTextview =  rootLayout.childCount == 1
        outState.putBoolean(KEY,removedTextview)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val removedTextview = savedInstanceState.getBoolean(KEY)
        if (removedTextview){
            rootLayout.removeView(titleTextView)
        }

    }

    companion object {
        private const val KEY = "key"
    }
}

