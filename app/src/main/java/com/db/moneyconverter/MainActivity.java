package com.db.moneyconverter;

import androidx.appcompat.app.AppCompatActivity;
import java.text.NumberFormat;
import java.util.Locale;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etIDR,etKonversi;
    Button RpToUsd, RpToEuro;
    double angka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etIDR = findViewById(R.id.etIDR);
        etKonversi = findViewById(R.id.etKonversi);
        RpToUsd = findViewById(R.id.RpToUsd);
        RpToEuro = findViewById(R.id.RpToEuro);
    }

    public boolean cek(){
        if (etIDR.getText().toString().isEmpty()){
            Toast.makeText(this, "Masukkan bilangan terlebih dahulu", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void toUSD(View v){
        if (!cek()){
            return;
        }

        try{
            angka = Double.parseDouble(etIDR.getText().toString());
        }catch(Exception e){
            Toast.makeText(this, "Masukkan angka", Toast.LENGTH_SHORT).show();
        }

        double hasil = angka * 13998.54;
        etKonversi.setText(NumberFormat.getCurrencyInstance(Locale.US).format(hasil));
        Toast.makeText(this, "1 U$D = Rp 13998,54", Toast.LENGTH_SHORT).show();
    }

    public void toEuro(View v){
        if (!cek()){
            return;
        }

        try{
            angka = Double.parseDouble(etIDR.getText().toString());
        }catch(Exception e){
            Toast.makeText(this, "Masukkan angka", Toast.LENGTH_SHORT).show();
        }

        double hasil = angka * 15607.77;
        etKonversi.setText(NumberFormat.getCurrencyInstance(Locale.GERMANY).format(hasil));
        Toast.makeText(this, "1 Euro = Rp 15.607,77", Toast.LENGTH_SHORT).show();
    }
}
