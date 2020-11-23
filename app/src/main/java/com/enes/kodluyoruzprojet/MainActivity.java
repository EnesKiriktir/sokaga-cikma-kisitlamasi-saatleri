package com.enes.kodluyoruzprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {

     EditText edt;
    Button btn;
     TextView sonuc;
     GifImageView gif;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        defineVariable();
        gif.setVisibility(View.INVISIBLE);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int yas = yasHesapla(Integer.parseInt(edt.getText().toString()));
                int saat = currentHour();
                boolean haftasonuMu = haftaSonu();
                if(yas<20){
                    if(saat>=13 && saat<16){
                        sonuc.setText(R.string.string_serbest);
                        gif.setImageResource(R.drawable.maske_tak);
                        gif.setVisibility(View.VISIBLE);
                        Toast.makeText(MainActivity.this, "Maske Takmayı İhmal Etmeyin!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        sonuc.setText(R.string.string_yasak);
                        gif.setImageResource(R.drawable.evde_kal);
                        gif.setVisibility(View.VISIBLE);
                        Toast.makeText(MainActivity.this, "Evde Kalın, Güvende Kalın", Toast.LENGTH_SHORT).show();
                    }

                }
                else if(yas >=20 && yas<65){

                    if(haftasonuMu){
                        if(saat<10 && saat>=20){
                            sonuc.setText(R.string.string_yasak);
                            gif.setImageResource(R.drawable.evde_kal);
                            gif.setVisibility(View.VISIBLE);
                            Toast.makeText(MainActivity.this, "Evde Kalın, Güvende Kalın", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            sonuc.setText(R.string.string_serbest);
                            gif.setImageResource(R.drawable.maske_tak);
                            gif.setVisibility(View.VISIBLE);
                            Toast.makeText(MainActivity.this, "Maske Takmayı İhmal Etmeyin!", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else{
                        edt.setText(String.valueOf(saat));
                        if (saat<5 && currentDay()==1){
                            sonuc.setText(R.string.string_yasak);
                            gif.setImageResource(R.drawable.evde_kal);
                            gif.setVisibility(View.VISIBLE);
                            Toast.makeText(MainActivity.this, "Evde Kalın, Güvende Kalın", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            sonuc.setText(R.string.string_serbest);
                            gif.setImageResource(R.drawable.maske_tak);
                            gif.setVisibility(View.VISIBLE);
                            Toast.makeText(MainActivity.this, "Maske Takmayı İhmal Etmeyin!", Toast.LENGTH_SHORT).show();

                        }
                    }

                }
                else{
                    if(saat>=10 && saat<13){
                        sonuc.setText(R.string.string_serbest);
                        gif.setImageResource(R.drawable.maske_tak);
                        gif.setVisibility(View.VISIBLE);
                        Toast.makeText(MainActivity.this, "Maske Takmayı İhmal Etmeyin!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        sonuc.setText(R.string.string_yasak);
                        gif.setImageResource(R.drawable.evde_kal);
                        gif.setVisibility(View.VISIBLE);
                        Toast.makeText(MainActivity.this, "Evde Kalın, Güvende Kalın", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
    }

    public void defineVariable(){
         edt = findViewById(R.id.editTextNumber);
        btn = findViewById(R.id.button);
         sonuc = findViewById(R.id.textView);
         gif = findViewById(R.id.gif_yasak);
    }
    public int yasHesapla(int yıl){
        return currentYear()-yıl;
    }

    public int currentDay(){
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("u");
        String gün = dateFormat.format(date);
        int intGün= Integer.parseInt(gün);
        return intGün;
    }

    public int currentHour(){
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("HH");
        String hour = dateFormat.format(date);
        int intHour= Integer.parseInt(hour);
        return intHour;
    }

    public boolean haftaSonu(){
        if(currentDay()==6 || currentDay()==7){
            return true;
        }
        else
            return false;
    }

    public int currentYear(){

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        String tarih = dateFormat.format(date);
        int intTarih= Integer.parseInt(tarih);
        return intTarih;
    }
}