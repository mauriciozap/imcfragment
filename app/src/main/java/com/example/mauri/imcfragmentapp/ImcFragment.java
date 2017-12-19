package com.example.mauri.imcfragmentapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by mauri on 18/12/2017.
 */

public class ImcFragment extends Fragment {
    EditText mCampoPeso;
    EditText mCampoEstatura;
    Button mBotonCalcular;
    Button mBotonLimpiar;
    TextView mEtiquetaImc;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragmento_imc,container,false);

        mCampoPeso = (EditText) v.findViewById(R.id.campo_peso);
        mCampoEstatura = (EditText) v.findViewById(R.id.campo_estatura);
        mBotonCalcular = (Button) v.findViewById(R.id.boton_calcular);
        mBotonLimpiar = (Button) v.findViewById(R.id.boton_limpiar);
        mEtiquetaImc = (TextView) v.findViewById(R.id.etiqueta_imc);

        mBotonCalcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String s = mCampoPeso.getText().toString();
                double peso = Double.parseDouble(s);
                s = mCampoEstatura.getText().toString();
                double estatura = Double.parseDouble(s);
                double imc = peso / (estatura * estatura);
                s = String.format("%2.2f", imc);
                mEtiquetaImc.setText(s);
            }

            });

            mBotonLimpiar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mCampoEstatura.setText("");
                    mCampoPeso.setText("");
                    mEtiquetaImc.setText("0.0");
                }
            });
        return v;
    }


}


