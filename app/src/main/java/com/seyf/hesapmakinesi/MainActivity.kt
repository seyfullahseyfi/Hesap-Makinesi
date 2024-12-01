package com.seyf.hesapmakinesi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.seyf.hesapmakinesi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var girilenSayi = ""
    var oncekiSayi = ""
    var operator = ""
    var toplam = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btn1.setOnClickListener { rakamYaz("1") }
        binding.btn2.setOnClickListener { rakamYaz("2") }
        binding.btn3.setOnClickListener { rakamYaz("3") }
        binding.btn4.setOnClickListener { rakamYaz("4") }
        binding.btn5.setOnClickListener { rakamYaz("5") }
        binding.btn6.setOnClickListener { rakamYaz("6") }
        binding.btn7.setOnClickListener { rakamYaz("7") }
        binding.btn8.setOnClickListener { rakamYaz("8") }
        binding.btn9.setOnClickListener { rakamYaz("9") }
        binding.btn0.setOnClickListener { rakamYaz("0") }
        binding.btnNokta.setOnClickListener { rakamYaz(".") }

        binding.btnTopla.setOnClickListener { islem("+") }
        binding.btnEsittir.setOnClickListener { sonuc() }
        binding.btnSifirla.setOnClickListener { temizle() }
        binding.btnSil.setOnClickListener { sil() }
    }

    fun rakamYaz(value: String) {
        girilenSayi+= value
        binding.editTextNumber.setText(girilenSayi)
    }

    fun islem(op : String) {
        if (girilenSayi.isNotEmpty()) {
            val num = girilenSayi.toDouble()
            toplam += num
            girilenSayi = ""
            operator = op
        }
    }

    fun sonuc() {
        if (girilenSayi.isNotEmpty()) {
            val num = girilenSayi.toDouble()
            toplam += num
        }
        if(toplam == toplam.toInt().toDouble()) {
            binding.editTextNumber.setText(toplam.toInt().toString())
        } else {
            binding.editTextNumber.setText(toplam.toString())
        }

        sifirla()
    }

    fun temizle() {
        sifirla()
        binding.editTextNumber.setText("")
    }

    fun sil() {
        if (girilenSayi.isNotEmpty()) {
            girilenSayi = girilenSayi.substring(0,girilenSayi.length - 1)
            binding.editTextNumber.setText(girilenSayi)
        }
    }

    fun sifirla() {
        girilenSayi = ""
        toplam = 0.0
        operator = ""
    }

}