package com.example.atividadevelocidade

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import kotlin.math.pow

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var btCalcularVelo: AppCompatButton
    lateinit var etV1: AppCompatEditText
    lateinit var etV0: AppCompatEditText
    lateinit var etT1: AppCompatEditText
    lateinit var etT0: AppCompatEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etV1 = findViewById(R.id.etV1)
        etV0 = findViewById(R.id.etV0)
        etT1 = findViewById(R.id.etT1)
        etT0 = findViewById(R.id.etT0)

        btCalcularVelo = findViewById(R.id.btCalcularVelo)

        btCalcularVelo.setOnClickListener(this)

    }

    private fun calcularVelo(v1: Double, v0: Double, t1: Double, t0: Double) : Double{
        if (v1 > 0.0 && v0 >= 0.0 && t1 > 0.0 && t0 >= 0.0) {
            return (((v1 - v0) / (t1 - t0)))
        } else {
            throw IllegalArgumentException("Ta Errado.")
        }
    }

    override fun onClick(v: View?) {
        if(v!!.id == R.id.btCalcularVelo) {
            val v0 = etV0.text.toString().toDouble()
            val v1 = etV1.text.toString().toDouble()
            val t0 = etT0.text.toString().toDouble()
            val t1 = etT1.text.toString().toDouble()


            try {
                val media = calcularVelo(v1,v0,t1,t0)

                // criando a intent (para abrir a outra activity)
                val intentResultado = Intent(this,Resultado::class.java)

                // adicionando o parametro que desejamos
                intentResultado.putExtra("resultado_velo",media)
                this.startActivity(intentResultado)

                /*
                    teste antes, depois retire o comentário da linha abaixo a linha abaixo e
                    descubra o que acontece quando vc apertar o "voltar" na tela de resultado
                    (voltar do próprio ANDROID)
                */
                // finish()

            }catch (arg : IllegalArgumentException){
                Toast.makeText(this, arg.message, Toast.LENGTH_LONG).show()
            }
        }
    }



}