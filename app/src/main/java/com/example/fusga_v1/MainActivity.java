package com.example.fusga_v1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private ImageView iv_logo1;
    private TextView tv_version;
    public ConstraintLayout backPrincipal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backPrincipal=(ConstraintLayout)findViewById(R.id.backPrincipal);

        iv_logo1 = (ImageView)findViewById(R.id.iv_logo1);
        tv_version = (TextView) findViewById(R.id.tv_version);

        /*
           Parámetro (fullscreen)
         */
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        /*
           Crear una instancia(de objeto) de animaciones
         */
        Animation animation1 = AnimationUtils.loadAnimation(this,R.anim.iv_logo1);
        ImageView logo = findViewById(R.id.iv_logo1);
        logo.setAnimation(animation1);

        Animation animation2 = AnimationUtils.loadAnimation(this,R.anim.version_anim);
        TextView version = findViewById(R.id.tv_version);
        version.setAnimation(animation2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                finish();
            }
        },2000);




    }

}