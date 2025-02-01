package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
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

        val (classificacao, cor) = when (results) {
            in 0.0..18.4 -> "MAGREZA" to R.color.vermelho
            in 18.5..24.9 -> "NORMAL" to R.color.verde
            in 25.0..29.9 -> "SOBREPESO" to R.color.verde
            in 30.0..39.9 -> "OBESIDADE" to R.color.vermelho
            else -> "OBESIDADE GRAVE" to R.color.vermelho
        }
        tvClassificacao.text = (classificacao)
        tvClassificacao.setTextColor(ContextCompat.getColor(this, cor))
    }
}