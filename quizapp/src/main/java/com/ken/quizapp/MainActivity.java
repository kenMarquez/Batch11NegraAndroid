package com.ken.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText inputUserName;
    private Button btnIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputUserName = (EditText) findViewById(R.id.input_username);
        btnIniciar = (Button) findViewById(R.id.btn_iniciar);
        View.OnClickListener listener = this;
        btnIniciar.setOnClickListener(listener);

    }


    @Override
    public void onClick(View view) {

        String text = inputUserName.getText().toString();


        if (text.isEmpty()) {
            //No hacer nada
            Toast.makeText(this, "Tienes que ingresar un UserName", Toast.LENGTH_SHORT).show();
        } else {
            Log.i("myLog", text);
            Intent intent = new Intent(this, StartQuizActivity.class);
            startActivity(intent);
        }
    }
}
