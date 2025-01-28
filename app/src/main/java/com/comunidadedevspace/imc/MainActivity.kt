package com.comunidadedevspace.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Recuperar os componentes da interface (TextInputEditText e Button).
        val edtPeso = findViewById<TextInputEditText>(R.id.edt_peso)
        val edtAltura = findViewById<TextInputEditText>(R.id.edt_altura)
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)

        // Implementando uma ação após o clique do botão.
        btnCalcular.setOnClickListener {
            val pesoStr: String = edtPeso.text.toString()
            val alturaStr: String = edtAltura.text.toString()
            // Verificação para saber se todos os dados foram passados.
            if (pesoStr.isEmpty() || alturaStr.isEmpty()){
                Snackbar.make(
                    edtPeso, // O componente ao qual o Snackbar será ancorado
                    "Preencha todos os campos.",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {
                //Conversão para "Float"
                val peso: Float = pesoStr.toFloat()
                val altura: Float = alturaStr.toFloat()
                // Cálculo do IMC
                val alturaQ2: Float = altura * altura
                val resultado: Float = peso / alturaQ2
                println("André ação do botão $resultado")
            }
        }
    }
}