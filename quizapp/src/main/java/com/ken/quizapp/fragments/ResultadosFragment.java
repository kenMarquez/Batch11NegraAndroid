package com.ken.quizapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ken.quizapp.R;

/**
 * create an instance of this fragment.
 */
public class ResultadosFragment extends Fragment {

    private String userName;
    private int resultado;

    public ResultadosFragment() {
    }

    public ResultadosFragment(String userName, int resultado) {
        this.userName = userName;
        this.resultado = resultado;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resultados, container, false);

        TextView tvUserName = (TextView) view.findViewById(R.id.tv_username);
        TextView tvPuntaje = (TextView) view.findViewById(R.id.tv_puntaje);

        tvUserName.setText(userName);
        tvPuntaje.setText(resultado + "");


        return view;
    }

}
