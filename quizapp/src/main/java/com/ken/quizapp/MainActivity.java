package com.ken.quizapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText inputUserName;
    private Button btnIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Le indicamos que layout va a utilizar mi actividad
        setContentView(R.layout.activity_main);
        //Referenciamos el edittext del xml a nuestro inputUsername
        inputUserName = (EditText) findViewById(R.id.input_username);
        btnIniciar = (Button) findViewById(R.id.btn_iniciar);

        // le asignamos un escuchador que se mandara a llamara cuando le demos click al boton
        btnIniciar.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        //Tomamos lo que esta dentro de nuestro Edittext
        String userName = inputUserName.getText().toString();


        if (userName.isEmpty()) {
            //El user name es vacio
            Toast.makeText(this, "Tienes que ingresar un UserName", Toast.LENGTH_SHORT).show();
        } else {
            Log.i("myLog", userName);


            SharedPreferences preferences = getSharedPreferences("preferencias_quiz", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("userName", userName);
            editor.putInt("random", 1012123);
            editor.commit();



            Intent intent = new Intent(this, StartQuizActivity.class);
            intent.putExtra("userKey", userName);
            startActivity(intent);


        }
    }
}
