package com.ken.quizapp;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.ken.quizapp.fragments.QuestionFragment;
import com.ken.quizapp.fragments.ResultadosFragment;

import java.util.ArrayList;
import java.util.List;

public class StartQuizActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * Lista que contendra las preguntas del quiz
     */
    private List<String> mListPreguntas = new ArrayList<>();
    /**
     * Lista que contendra las respuestas correspondientes a la lista de respuestas
     */
    private List<Integer> mListRespuestas = new ArrayList<>();

    /**
     * Variable que contiene la posición actual de la pregunta que vamos a contener
     */
    private int questionPosition;

    /**
     * Configuramos el fragmento global para poder obtener el valor de la pregunta seleccionada
     */
    private QuestionFragment questionFragment;

    private int respuestasCorrectas;

    private String userName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_quiz);
        /**
         * Inicializa las vistas
         */
        initViews();
        /**
         * Inicializa la lista de preguntas y respuestas correctas
         */
        initPreguntas();
        /**
         * Configuramos el framelayout con la primera pregunta
         */
        respuestasCorrectas = 0;
        questionPosition = 0;
        cambiarFragment(questionPosition);

        //Obtenemos el intent que mando a llamar esta actividad
        Intent intent = getIntent();
        //Obetnemos el Bundle donde estan guardados nuestros datos
        Bundle extras = intent.getExtras();
        //verificamos que el bundle sea distinto de null
        if (extras != null) {
            //obtenemos el username
            userName = extras.getString("userKey");
            Log.e("username", userName);
        }

    }

    /**
     * Inicializa las vistas
     */
    private void initViews() {
        View view = findViewById(R.id.quiz_img_arrow_right);
        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // Verificamos que si es la ultima posicion mostramos puntaje
        // sino mostramos la siguiente pregunta
        if (questionPosition == mListPreguntas.size() - 1) {
            //terminamos
            Toast.makeText(this, "Tu puntaje es: " + respuestasCorrectas, Toast.LENGTH_LONG).show();
            fragmentFinal();

        } else {

            // Verificiamos que la respuesta es correcta
            if (questionFragment.getRespuesta() == mListRespuestas.get(questionPosition)) {
                respuestasCorrectas++;
            }

            questionPosition++;
            cambiarFragment(questionPosition);
        }
    }

    /**
     * Inicializa la lista de preguntas y respuestas correctas
     */
    private void initPreguntas() {
        /**
         * Inicializamos lista de preguntas
         */
        mListPreguntas.add("¿En Java un arreglo tiene un tamaño definido?");
        mListPreguntas.add("¿Un árbol binario puede tener mas de dos hijos?");
        mListPreguntas.add("¿Git es un sistema de control de versiones?");
        mListPreguntas.add("¿Java es no es un lenguaje tipado?");
        mListPreguntas.add("¿Un ScrollView puede tener mas de dos vistas hijas?");

        /**
         * Inicializamos lista de respuestas
         */
        mListRespuestas.add(1);
        mListRespuestas.add(0);
        mListRespuestas.add(1);
        mListRespuestas.add(0);
        mListRespuestas.add(0);
    }

    /**
     * Cambiamos de fragment en el framelayout y configuramos el fragment inicial
     * con la pregunta correspondiente
     */
    private void cambiarFragment(int positon) {

        questionFragment = new QuestionFragment(mListPreguntas.get(positon));


        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.slide_right_enter, R.anim.slide_left_exit)
                .replace(R.id.frame_layout, questionFragment)
                .commit();
    }

    /**
     * Cambiamos de fragment en el framelayout y configuramos el fragment inicial
     * con la pregunta correspondiente
     */
    private void fragmentFinal() {

        ResultadosFragment resultadosFragment = new ResultadosFragment(userName, respuestasCorrectas);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.slide_right_enter, R.anim.slide_left_exit)
                .replace(R.id.frame_layout, resultadosFragment)
                .commit();
    }


}
