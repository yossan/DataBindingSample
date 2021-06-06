package io.github.yossan.databindingsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import io.github.yossan.databindingsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.resultHandler = ResultListener(binding)
    }

    class ResultListener(val binding: ActivityMainBinding) : View.OnClickListener {
        override fun onClick(v: View) {
            binding.resultTextView.text = when(binding.ageEditText.text.toString().toInt()) {
                in 0..20 -> "NG"
                in 21..130 ->"OK"
                else -> "It's not human."
            }
        }
    }
}

