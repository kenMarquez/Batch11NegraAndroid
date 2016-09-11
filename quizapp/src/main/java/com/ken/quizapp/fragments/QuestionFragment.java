package com.ken.quizapp.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ken.quizapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment implements View.OnClickListener {


    private String title;

    private TextView tvTitle;
    private TextView tvFalse;
    private TextView tvTrue;

    private int respuesta;

    /**
     * Recibimos el titulo de la pregunta
     *
     * @param title
     */
    public QuestionFragment(String title) {

        this.title = title;
    }

    public QuestionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /**
         * Inflamos el layout que vamos a utilizar y lo asignamos a la variable view
         */
        View view = inflater.inflate(R.layout.fragment_question, container, false);
        /**
         * Referenciamos el titulo de la pregunta
         */
        tvTitle = (TextView) view.findViewById(R.id.tv_title);

        tvTitle.setText(title);// le asignamos el nombre que nos pasan en el constructor

        /**
         * Referenciamos las vistas de false y true
         */
        tvFalse = (TextView) view.findViewById(R.id.quiz_tv_false);
        tvTrue = (TextView) view.findViewById(R.id.quiz_tv_true);

        /**
         * Asignamos el escuchador del evento click a las vistas de true y false
         */
        tvFalse.setOnClickListener(this);
        tvTrue.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        /**
         * Swich de las vistas que asignamos el escuchador
         */
        switch (view.getId()) {
            /**
             * El usuario presiono la vista de false y tenemos
             * que resetear el color de la vista de true
             */
            case R.id.quiz_tv_false:
                tvFalse.setBackgroundResource(R.color.colorVerdeLimon);
                tvTrue.setBackgroundResource(R.color.colorGrisDesabilitado);
                respuesta = 0;

                break;
            /**
             * El usuario presiono la vista de True y tenemos
             * que resetear el color de la vista de false
             */
            case R.id.quiz_tv_true:
                tvTrue.setBackgroundResource(R.color.colorVerdeLimon);
                tvFalse.setBackgroundResource(R.color.colorGrisDesabilitado);
                respuesta = 1;
                break;
        }
    }

    public int getRespuesta() {
        return respuesta;
    }


}
