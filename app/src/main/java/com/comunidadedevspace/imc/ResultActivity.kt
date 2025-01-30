package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "RESULTACTIVITY_KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val results = intent.getFloatExtra(KEY_RESULT_IMC, 0.0f)
        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)
        tvResult.text = results.toString()

        val classificacao: String = if (results < 18.5) {
            "MAGREZA"
        } else if (results >= 18.5 && results < 24.9) {
            "NORMAL"
        } else if (results >= 24.9 && results < 29.9) {
            "SOBREPESO"
        } else if (results >= 29.9 && results <= 39.9){
            "OBESIDADE"
        } else {
            "OBESIDADE GRAVE"
        }
        tvClassificacao.text = (classificacao)
    }
}