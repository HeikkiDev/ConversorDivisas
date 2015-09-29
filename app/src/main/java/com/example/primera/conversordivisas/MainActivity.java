package com.example.primera.conversordivisas;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private RadioButton rbtnDolaEu;
    private RadioButton rbtnEuADol;
    private EditText etxDolares;
    private EditText etxEuros;
    private RadioGroup radioGroup;
    Divisas divisas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity2);

        // Variables con mis controles
        rbtnDolaEu = (RadioButton)findViewById(R.id.rbtnDolAEur);
        rbtnEuADol = (RadioButton)findViewById(R.id.rbtnEurADol);
        etxDolares = (EditText)findViewById(R.id.etxDolares);
        etxEuros=(EditText)findViewById(R.id.etxEuros);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);

        // Deshabilitar una de las entradas de números. Por defecto la de Euros.
        etxEuros.setEnabled(false);

        // Evento de cambio de check en el radio group
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //Habilitar y deshabilitar entradas de números
                etxDolares.setEnabled(!etxDolares.isEnabled());
                etxEuros.setEnabled(!etxEuros.isEnabled());

                // Poner el foco en el EditText correspondiente al cambiar el check
                switch (checkedId){
                    case R.id.rbtnDolAEur:
                        etxDolares.requestFocus();
                        etxDolares.setText("");
                        break;
                    case R.id.rbtnEurADol:
                        etxEuros.requestFocus();
                        etxEuros.setText("");
                        break;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Manejador del evento Click del botón Convertir
    public void convertir(View v){
        divisas = new Divisas(etxEuros, etxDolares);

        if(etxDolares.hasFocus()){
            divisas.DolaresAEuros();
        }
        else{
            divisas.EurosADolares();
        }
    }


}
