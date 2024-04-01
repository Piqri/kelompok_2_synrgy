package com.jer.ch2_ch3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jer.ch2_ch3.databinding.FajarCh2Binding

class CH2Activity : AppCompatActivity() {

    private lateinit var binding: FajarCh2Binding
    private var result: Int = 0
    private var value: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FajarCh2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener {

            var costInput = binding.edtCost.text.toString()
            when  {
                costInput.isEmpty() -> binding.edtCost.error = "Filed ini tidak boleh kosong"

                else -> {
//                        var value = 0
                    if (binding.radioGroup.checkedRadioButtonId > 0) {
                        when(binding.radioGroup.checkedRadioButtonId) {
                            R.id.rb1 -> value = 20
                            R.id.rb2 -> value = 18
                            R.id.rb3 -> value = 15
                        }

                        resultTip(costInput, value.toString())
                    }


                }
            }


        }
    }


    fun resultTip(cost: String, tip: String) {
        result = cost.toInt() * tip.toInt() / 100
        binding.tvResultTip.text = result.toString()
    }
}