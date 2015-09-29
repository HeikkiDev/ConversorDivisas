package com.example.primera.conversordivisas;

import android.app.AlertDialog;
import android.widget.EditText;

/**
 * Created by usuario on 29/09/15.
 */
public class Divisas {

    // Índices de conversión
    private double indiceConversion = 0.893227;
    private  EditText etxEuros;
    private EditText etxDolares;

    public Divisas(EditText etxEuros, EditText etxDolares){
        this.etxEuros = etxEuros;
        this. etxDolares=etxDolares;
    }

    public void EurosADolares() {
        try {
            double dolar = (Double.parseDouble(etxEuros.getText().toString())) / (indiceConversion);
            etxDolares.setText(String.valueOf(String.format("%.2f", dolar))); //Redondeo a dos decimales
        }
        catch (Exception e){
            AlertDialog.Builder alertaE  = new AlertDialog.Builder(null);
            alertaE.setMessage("Introduce los euros a convertir");
            alertaE.setPositiveButton("Ok",null);
            alertaE.create().show();
        }
    }

    public void DolaresAEuros() {
        try {
            double euro = (Double.parseDouble(etxDolares.getText().toString())) * (indiceConversion);
            etxEuros.setText(String.valueOf(String.format("%.2f", euro)));  //Redondeo a dos decimales
        }
        catch (Exception e){
            AlertDialog.Builder alertaD  = new AlertDialog.Builder(null);
            alertaD.setMessage("Introduce los dólares a convertir");
            alertaD.setPositiveButton("Ok",null);
            alertaD.create().show();
        }
    }

}
