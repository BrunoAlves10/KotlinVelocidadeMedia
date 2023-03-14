package com.example.atividadevelocidade

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatTextView

class Resultado : AppCompatActivity() {

    lateinit var resultado: AppCompatTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        resultado = findViewById(R.id.tvChevete)


        if(intent.hasExtra("resultado_velo")){
            resultado.text = String.format("O resultado é: ${intent.getDoubleExtra("resultado_velo",0.0)}")
        }else{
            finish()
        }

    }
}