package br.edu.ifsp.medias.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import br.edu.ifsp.medias.CalculadoraAritmetica;
import br.edu.ifsp.medias.CalculadoraHarmonica;
import br.edu.ifsp.medias.CalculadoraPonderada;
import br.edu.ifsp.medias.R;

public class CalculoActivity extends AppCompatActivity {

    private TextView textviewResultado;
    private TextView textviewMedia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);

        textviewResultado = findViewById(R.id.id_textview_resultado);
        textviewMedia = findViewById(R.id.id_textview_media);

        Intent intent = getIntent();

        calcular(intent);

    }

    private void calcular(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras.get("strategy").equals("aritmetica")){
            CalculadoraAritmetica calculadora = new CalculadoraAritmetica();
            textviewMedia.setText("Resultado da média aritmetica");
            textviewResultado.setText(calculadora.calcular(
                    extras.getDouble("valorOne"),
                    extras.getDouble("valorTwo"),
                    extras.getDouble("valorThree"),
                    extras.getDouble("valorFour"),
                    extras.getDouble("valorFive")
            ).toString());
        } else if (extras.get("strategy").equals("ponderada")){
            CalculadoraPonderada calculadora = new CalculadoraPonderada();
            textviewMedia.setText("Resultado da média ponderada");
            textviewResultado.setText(calculadora.calcular(
                    extras.getDouble("valorOne"),
                    extras.getDouble("valorTwo"),
                    extras.getDouble("valorThree"),
                    extras.getDouble("valorFour"),
                    extras.getDouble("valorFive"),
                    extras.getDouble("pesoOne"),
                    extras.getDouble("pesoTwo"),
                    extras.getDouble("pesoThree"),
                    extras.getDouble("pesoFour"),
                    extras.getDouble("pesoFive")
            ).toString());
        } else if (extras.get("strategy").equals("harmonica")){
            CalculadoraHarmonica calculadora = new CalculadoraHarmonica();
            textviewMedia.setText("Resultado da média harmonica");
            textviewResultado.setText(calculadora.calcular(
                    extras.getDouble("valorOne"),
                    extras.getDouble("valorTwo"),
                    extras.getDouble("valorThree"),
                    extras.getDouble("valorFour"),
                    extras.getDouble("valorFive")
            ).toString());
        }
    }

}