package ru.easycode.zerotoheroandroidtdd

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding
import java.io.Serializable
import java.lang.Thread.State

class MainActivity : AppCompatActivity() {

    private var state : ru.easycode.zerotoheroandroidtdd.State = ru.easycode.zerotoheroandroidtdd.State.Initial

    lateinit var binding: ActivityMainBinding

    //private var isTitleTextViewHidden: Boolean = false

    private lateinit var linearLayout : LinearLayout
    private lateinit var textView: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        button = binding.removeButton
        linearLayout = binding.rootLayout
        textView = binding.titleTextView


        button.setOnClickListener{
            state = ru.easycode.zerotoheroandroidtdd.State.Removed
            state.apply (linearLayout, textView, button)
        }

        /*binding.removeButton.setOnClickListener{
            LinearLayout.removeView(TextView)
        }*/



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
        outState.putSerializable(KEY,state)

    }

    @SuppressLint("SuspiciousIndentation")
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
      state = savedInstanceState.getSerializable(KEY) as ru.easycode.zerotoheroandroidtdd.State

        state.apply (linearLayout, textView, button)
    }

   /* override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
       val removedTextview =  LinearLayout.childCount == 1
        outState.putBoolean(KEY,removedTextview)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val removedTextview = savedInstanceState.getBoolean(KEY)
        if (removedTextview){
            LinearLayout.removeView(TextView)
        }*/
   companion object {
       private const val KEY = "key"
   }
}
interface State: Serializable {

    fun apply (linearLayout : LinearLayout,textView: TextView, button: Button)
    object Initial : ru.easycode.zerotoheroandroidtdd.State{
        override fun apply(linearLayout: LinearLayout, textView: TextView,button: Button) = Unit

    }

    object Removed : ru.easycode.zerotoheroandroidtdd.State{
        override fun apply(linearLayout: LinearLayout, textView: TextView, button: Button) {
            linearLayout.removeView(textView)
            button.isEnabled=false
        }
    }


}




