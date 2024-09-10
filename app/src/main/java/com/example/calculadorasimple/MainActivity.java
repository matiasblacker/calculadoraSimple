package com.example.calculadorasimple;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText txt1 = findViewById(R.id.num1);
        EditText txt2 = findViewById(R.id.num2);
        TextView txt3 = findViewById(R.id.resultado);
        Button btnsumar = findViewById(R.id.btnsumar);
        Button btnrestar = findViewById(R.id.btnrestar);
        Button btnmultiplicar = findViewById(R.id.btnmultiplicar);
        Button btndividir = findViewById(R.id.btndividir);
        Button btnsalir = findViewById(R.id.btnsalir);

        btnsalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finalizar la actividad actual
                finish();
                // También puedes salir de la aplicación completamente si quieres
                System.exit(0);
            }
        });

        // Operación de suma
        btnsumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realizarOperacion(txt1, txt2, txt3, "sumar");
            }
        });

        // Operación de resta
        btnrestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realizarOperacion(txt1, txt2, txt3, "restar");
            }
        });

        // Operación de multiplicación
        btnmultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realizarOperacion(txt1, txt2, txt3, "multiplicar");
            }
        });

        // Operación de división
        btndividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realizarOperacion(txt1, txt2, txt3, "dividir");
            }
        });
    }

    private void realizarOperacion(EditText txt1, EditText txt2, TextView txt3, String operacion) {
        String num1 = txt1.getText().toString();
        String num2 = txt2.getText().toString();

        try {
            if (num1.isEmpty() || num2.isEmpty()) {
                Toast mensaje = Toast.makeText(getApplicationContext(), "Debe ingresar valores", Toast.LENGTH_LONG);
                mensaje.show();
            } else {
                int resultado = 0;
                int numero1 = Integer.parseInt(num1);
                int numero2 = Integer.parseInt(num2);

                switch (operacion) {
                    case "sumar":
                        resultado = numero1 + numero2;
                        break;
                    case "restar":
                        resultado = numero1 - numero2;
                        break;
                    case "multiplicar":
                        resultado = numero1 * numero2;
                        break;
                    case "dividir":
                        if (numero2 != 0) {
                            resultado = numero1 / numero2;
                        } else {
                            Toast.makeText(getApplicationContext(), "No se puede dividir por cero", Toast.LENGTH_LONG).show();
                            return;
                        }
                        break;
                }

                txt1.setText("");
                txt2.setText("");
                txt3.setText(String.valueOf(resultado));
            }
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
        }
    }
}