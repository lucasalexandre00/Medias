package br.edu.ifsp.medias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import br.edu.ifsp.medias.view.CalculoActivity;

public class MainActivity extends AppCompatActivity {

    private RadioButton radioButtonOne;
    private RadioButton radioButtonTwo;
    private RadioButton radioButtonThree;

    private EditText editTextOne;
    private EditText editTextTwo;
    private EditText editTextThree;
    private EditText editTextFour;
    private EditText editTextFive;

    private EditText editTextPesoOne;
    private EditText editTextPesoTwo;
    private EditText editTextPesoThree;
    private EditText editTextPesoFour;
    private EditText editTextPesoFive;

    private String mediaStrategy = "";

    private Button buttonCalcular;

    private double valueOne;
    private double valueTwo;
    private double valueThree;
    private double valueFour;
    private double valueFive;


    private double pesoOne;
    private double pesoTwo;
    private double pesoThree;
    private double pesoFour;
    private double pesoFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioButtonOne = findViewById(R.id.id_radiobutton_one);
        radioButtonTwo = findViewById(R.id.id_radiobutton_two);
        radioButtonThree = findViewById(R.id.id_radiobutton_three);

        editTextOne = findViewById(R.id.id_edittext_one);
        editTextTwo = findViewById(R.id.id_edittext_two);
        editTextThree = findViewById(R.id.id_edittext_three);
        editTextFour = findViewById(R.id.id_edittext_four);
        editTextFive = findViewById(R.id.id_edittext_five);

        editTextPesoOne = findViewById(R.id.id_edittext_peso_one);
        editTextPesoTwo = findViewById(R.id.id_edittext_peso_two);
        editTextPesoThree = findViewById(R.id.id_edittext_peso_three);
        editTextPesoFour = findViewById(R.id.id_edittext_peso_four);
        editTextPesoFive = findViewById(R.id.id_edittext_peso_five);

        buttonCalcular = findViewById(R.id.id_button_calcular);

        radioButtonOne.setOnClickListener(
                view -> calcularMediaAritmetica()
        );
        radioButtonTwo.setOnClickListener(
                view -> calcularMediaPonderada()
        );
        radioButtonThree.setOnClickListener(
                view -> calcularMediaHarmonica()
        );
        buttonCalcular.setOnClickListener(
                view -> calcularMedia()
        );
    }

    private void calcularMedia() {
        Intent intent;
        if (mediaStrategy.equals("")){
            Toast.makeText(this, "Escolha o tipo de média", Toast.LENGTH_SHORT).show();
        }else if(mediaStrategy.equals("ponderada") &&  getValuesPonderada()){
            intent = novaIntent();
            startActivity(intent);
        }else if (mediaStrategy.equals("harmonica") &&  getValues()){
            intent = novaIntent();
            startActivity(intent);
        }else if (mediaStrategy.equals("aritmetica") && getValues()){
            intent = novaIntent();
            startActivity(intent);
        }
    }

    private Intent novaIntent() {
        Intent intent = new Intent(this, CalculoActivity.class);
        if(mediaStrategy.equals("ponderada")){
            intent.putExtra("valorOne", valueOne);
            intent.putExtra("valorTwo", valueTwo);
            intent.putExtra("valorThree", valueThree);
            intent.putExtra("valorFour", valueFour);
            intent.putExtra("valorFive", valueFive);
            intent.putExtra("pesoOne", pesoOne);
            intent.putExtra("pesoTwo", pesoTwo);
            intent.putExtra("pesoThree", pesoThree);
            intent.putExtra("pesoFour", pesoFour);
            intent.putExtra("pesoFive", pesoFive);
            intent.putExtra("strategy", "ponderada");
        }else if (mediaStrategy.equals("harmonica")){
            intent.putExtra("valorOne", valueOne);
            intent.putExtra("valorTwo", valueTwo);
            intent.putExtra("valorThree", valueThree);
            intent.putExtra("valorFour", valueFour);
            intent.putExtra("valorFive", valueFive);
            intent.putExtra("strategy", "harmonica");
        }else if (mediaStrategy.equals("aritmetica")){
            intent.putExtra("valorOne", valueOne);
            intent.putExtra("valorTwo", valueTwo);
            intent.putExtra("valorThree", valueThree);
            intent.putExtra("valorFour", valueFour);
            intent.putExtra("valorFive", valueFive);
            intent.putExtra("strategy", "aritmetica");
        }
        return intent;
    }

    private boolean getValues(){
        try {
            valueOne = Double.parseDouble(editTextOne.getText().toString());
            valueTwo = Double.parseDouble(editTextTwo.getText().toString());
            valueThree = Double.parseDouble(editTextThree.getText().toString());
            valueFour = Double.parseDouble(editTextFour.getText().toString());
            valueFive = Double.parseDouble(editTextFive.getText().toString());
            return true;
        }catch (NumberFormatException e){
            Toast.makeText(this, "Preencha todos os campos.", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private boolean getValuesPonderada(){
        try {
            valueOne = Double.parseDouble(editTextOne.getText().toString());
            valueTwo = Double.parseDouble(editTextTwo.getText().toString());
            valueThree = Double.parseDouble(editTextThree.getText().toString());
            valueFour = Double.parseDouble(editTextFour.getText().toString());
            valueFive = Double.parseDouble(editTextFive.getText().toString());

            pesoOne = Double.parseDouble(editTextPesoOne.getText().toString());
            pesoTwo = Double.parseDouble(editTextPesoTwo.getText().toString());
            pesoThree = Double.parseDouble(editTextPesoThree.getText().toString());
            pesoFour = Double.parseDouble(editTextPesoFour.getText().toString());
            pesoFive = Double.parseDouble(editTextPesoFive.getText().toString());
            return true;
        }catch (NumberFormatException e){
            Toast.makeText(this, "Preencha todos os campos.", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void calcularMediaHarmonica() {
        mediaStrategy = "harmonica";
        editTextPesoOne.setVisibility(EditText.INVISIBLE);
        editTextPesoTwo.setVisibility(EditText.INVISIBLE);
        editTextPesoThree.setVisibility(EditText.INVISIBLE);
        editTextPesoFour.setVisibility(EditText.INVISIBLE);
        editTextPesoFive.setVisibility(EditText.INVISIBLE);
    }

    private void calcularMediaPonderada() {
        mediaStrategy = "ponderada";
        editTextPesoOne.setVisibility(EditText.VISIBLE);
        editTextPesoTwo.setVisibility(EditText.VISIBLE);
        editTextPesoThree.setVisibility(EditText.VISIBLE);
        editTextPesoFour.setVisibility(EditText.VISIBLE);
        editTextPesoFive.setVisibility(EditText.VISIBLE);
    }

    private void calcularMediaAritmetica() {
        mediaStrategy = "aritmetica";
        editTextPesoOne.setVisibility(EditText.INVISIBLE);
        editTextPesoTwo.setVisibility(EditText.INVISIBLE);
        editTextPesoThree.setVisibility(EditText.INVISIBLE);
        editTextPesoFour.setVisibility(EditText.INVISIBLE);
        editTextPesoFive.setVisibility(EditText.INVISIBLE);
    }
}