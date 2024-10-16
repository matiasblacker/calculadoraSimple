package com.example.calculadorasimple

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //se cambio el protected void a override fun
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // las variables con sus tipos pasaron a Val
        val txt1 = findViewById<EditText>(R.id.num1)
        val txt2 = findViewById<EditText>(R.id.num2)
        val txt3 = findViewById<TextView>(R.id.resultado)
        val btnsumar = findViewById<Button>(R.id.btnsumar)
        val btnrestar = findViewById<Button>(R.id.btnrestar)
        val btnmultiplicar = findViewById<Button>(R.id.btnmultiplicar)
        val btndividir = findViewById<Button>(R.id.btndividir)
        val btnsalir = findViewById<Button>(R.id.btnsalir)

        btnsalir.setOnClickListener { // Finalizar la actividad actual
            finish() // se redujo la funcion para poder salir
            // También puedes salir de la aplicación completamente si quieres
            System.exit(0)
        }

        //las operaciones se redujeron en codigo
        // Operación de suma
        btnsumar.setOnClickListener { realizarOperacion(txt1, txt2, txt3, "sumar") }

        // Operación de resta
        btnrestar.setOnClickListener { realizarOperacion(txt1, txt2, txt3, "restar") }

        // Operación de multiplicación
        btnmultiplicar.setOnClickListener { realizarOperacion(txt1, txt2, txt3, "multiplicar") }

        // Operación de división
        btndividir.setOnClickListener { realizarOperacion(txt1, txt2, txt3, "dividir") }
    }
    // se simplifico la funcion de realizar la operacion
    private fun realizarOperacion(
        txt1: EditText,
        txt2: EditText,
        txt3: TextView,
        operacion: String
    ) {
        val num1 = txt1.text.toString()
        val num2 = txt2.text.toString()

        try {
            if (num1.isEmpty() || num2.isEmpty()) {
                val mensaje =
                    Toast.makeText(applicationContext, "Debe ingresar valores", Toast.LENGTH_LONG)
                mensaje.show()
            } else {
                var resultado = 0
                val numero1 = num1.toInt()
                val numero2 = num2.toInt()

                //ya no se hace uso de switch
                when (operacion) {
                    "sumar" -> resultado = numero1 + numero2
                    "restar" -> resultado = numero1 - numero2
                    "multiplicar" -> resultado = numero1 * numero2
                    "dividir" -> if (numero2 != 0) {
                        resultado = numero1 / numero2
                    } else {
                        Toast.makeText(
                            applicationContext,
                            "No se puede dividir por cero",
                            Toast.LENGTH_LONG
                        ).show()
                        return
                    }
                }
                txt1.setText("")
                txt2.setText("")
                txt3.text = resultado.toString()
            }
        } catch (e: Exception) {
            Log.e("Error", e.message!!)
        }
    }
}