package com.example.fusga_v1;

import static com.example.fusga_v1.R.id.backPrincipal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.R.*;
public class MainActivity2 extends AppCompatActivity {
    private ConstraintLayout back;

    private Switch cambiar_tema;

    MainActivity tema= new MainActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        //Icono en el Action Bar
        /*getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);*/

        back=(ConstraintLayout)findViewById(R.id.back);

        cambiar_tema=(Switch) findViewById(R.id.Switch);

        cambiar_tema.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (cambiar_tema.isChecked()){
                    updateTheme("Default","#FFFFFF");
                }else {
                    updateTheme("Dark", "#000000");
                }

            }
        });
        cargarTema();
    }

    public void updateTheme(String key,String c1){
        SharedPreferences savePreferences= getSharedPreferences("confi_theme", MODE_PRIVATE);
        SharedPreferences.Editor objEditor=savePreferences.edit();
        objEditor.putString("theme",key);
        objEditor.apply();

        back.setBackgroundColor(Color.parseColor(c1));




    }

    public  void cargarTema(){
        SharedPreferences loadPreferences = getSharedPreferences("confi_theme",MODE_PRIVATE);
        String TemaActual=loadPreferences.getString("theme", "Dark");
        if (TemaActual.equals("Dark")){
            updateTheme("Dark", "#000000");
        } else if (TemaActual.equals("Default")) {
            updateTheme("Default","#FFFFFF");
            cambiar_tema.setChecked(true);
        }
    }
}