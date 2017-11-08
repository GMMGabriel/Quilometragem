package br.com.kilometagem.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText txtKm;
    Spinner meses;
    SpinnerAdapter mesAdapter;
    VerRegistrosActivity.RegistroAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mesAdapter = ArrayAdapter.createFromResource(this, R.array.meses_km, R.layout.support_simple_spinner_dropdown_item);
        meses = (Spinner)findViewById(R.id.spMeses);
        meses.setAdapter(mesAdapter);
        txtKm = (EditText)findViewById(R.id.txtKm);
    }

    public void Inserir(View view) {
        String mes = meses.getSelectedItem().toString();
        Float kms = Float.parseFloat(String.valueOf(txtKm.getText().toString()));

        Locale teste = new Locale("pt", "BR");
        NumberFormat teste2 = NumberFormat.getNumberInstance(teste);
        String teste3 = teste2.format(kms);

        Registro R = new Registro(mes, kms);

        if (txtKm==null){
            return;
        }

        R.save();
        txtKm.setText(null);

        Intent intent = new Intent(this, VerRegistrosActivity.class);
        startActivity(intent);
        finish();
    }

}
