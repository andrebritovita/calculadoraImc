package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
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

        var cor = R.color.verde
        var classificacao = ""

        if (results < 18.5) {
            classificacao = "MAGREZA"
            cor = R.color.vermelho
        } else if (results >= 18.5 && results < 24.9) {
            classificacao = "NORMAL"
            cor = R.color.verde
        } else if (results >= 24.9 && results < 29.9) {
            classificacao = "SOBREPESO"
            cor = R.color.verde
        } else if (results >= 29.9 && results <= 39.9){
            classificacao = "OBESIDADE"
            cor = R.color.vermelho
        } else {
            classificacao = "OBESIDADE GRAVE"
            cor = R.color.vermelho
        }
        tvClassificacao.text = (classificacao)
        tvClassificacao.setTextColor(ContextCompat.getColor(this, cor))
    }
}