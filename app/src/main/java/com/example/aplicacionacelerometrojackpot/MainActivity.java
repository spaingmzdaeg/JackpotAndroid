package com.example.aplicacionacelerometrojackpot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.AnimationDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.FloatMath;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.aplicacionacelerometrojackpot.db.Resultados;
import com.example.aplicacionacelerometrojackpot.db.ResultadosDbHelper;

import java.util.Random;

public class MainActivity extends AppCompatActivity  {

    private ResultadosDbHelper dbHelper = new ResultadosDbHelper(this);

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;

    Button btn1,btn2,btn3;
    ImageView image1,image2,image3;
    Random r;
    int img1,img2,img3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r = new Random();

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateGame();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //insertarDatos();




            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, ListViewResultados.class);
                startActivity(intent1);
            }
        });



        // ShakeDetector initialization
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager
                .getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector();
        mShakeDetector.setOnShakeListener(new ShakeDetector.OnShakeListener() {

            @Override
            public void onShake(int count) {
                /*
                 * The following method, "handleShakeEvent(count):" is a stub //
                 * method you would use to setup whatever you want done once the
                 * device has been shook.
                 */

                calculateGame(count);

            }
        });

    }

    // test para acelerometro para ver si se agita
    public void test(int t){
        Toast.makeText(this,"SHAKEEEEEE!!!!",Toast.LENGTH_SHORT).show();
    }
    // test para insercion de BD

    public void insertarDatos(int n1,int n2,int n3){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        if (n1 == n2 && n2 == n3) {
            values.put(Resultados.ResultadosEntrada.COLUMN_RESULTADO_A,String.valueOf(n1));
            values.put(Resultados.ResultadosEntrada.COLUMN_RESULTADO_B,String.valueOf(n2));
            values.put(Resultados.ResultadosEntrada.COLUMN_RESULTADO_C,String.valueOf(n3));
            values.put(Resultados.ResultadosEntrada.COLUMN_RESULTADO_FINAL,"jackpot");

            long newRowId = db.insert(Resultados.ResultadosEntrada.TABLE_NAME, null, values);

            Toast.makeText(this,String.valueOf(newRowId),Toast.LENGTH_SHORT).show();
        } else if (n1 == n2 || n2 == n3 || n1 == n3) {
            values.put(Resultados.ResultadosEntrada.COLUMN_RESULTADO_A,String.valueOf(n1));
            values.put(Resultados.ResultadosEntrada.COLUMN_RESULTADO_B,String.valueOf(n2));
            values.put(Resultados.ResultadosEntrada.COLUMN_RESULTADO_C,String.valueOf(n3));
            values.put(Resultados.ResultadosEntrada.COLUMN_RESULTADO_FINAL,"amazing");

            long newRowId = db.insert(Resultados.ResultadosEntrada.TABLE_NAME, null, values);

            Toast.makeText(this,String.valueOf(newRowId),Toast.LENGTH_SHORT).show();
        } else {
            values.put(Resultados.ResultadosEntrada.COLUMN_RESULTADO_A,String.valueOf(n1));
            values.put(Resultados.ResultadosEntrada.COLUMN_RESULTADO_B,String.valueOf(n2));
            values.put(Resultados.ResultadosEntrada.COLUMN_RESULTADO_C,String.valueOf(n3));
            values.put(Resultados.ResultadosEntrada.COLUMN_RESULTADO_FINAL,"fail");

            long newRowId = db.insert(Resultados.ResultadosEntrada.TABLE_NAME, null, values);

            Toast.makeText(this,String.valueOf(newRowId),Toast.LENGTH_SHORT).show();
        }


    }



    public void setImages(){
        // imagenes aleatorias
        img1 = r.nextInt(5) + 1;
        img2 = r.nextInt(5) + 1;
        img3 = r.nextInt(5) + 1;

        insertarDatos(img1,img2,img3);

        // obtener primera imagen

        switch (img1) {
            case 1:
                image1.setImageResource(R.drawable.a);
                break;
            case 2:
                image1.setImageResource(R.drawable.b);
                break;
            case 3:
                image1.setImageResource(R.drawable.c);
                break;
            case 4:
                image1.setImageResource(R.drawable.d);
                break;
            case 5:
                image1.setImageResource(R.drawable.e);
                break;
        }

        // obtener segunda imagen

        switch (img2) {
            case 1:
                image2.setImageResource(R.drawable.a);
                break;
            case 2:
                image2.setImageResource(R.drawable.b);
                break;
            case 3:
                image2.setImageResource(R.drawable.c);
                break;
            case 4:
                image2.setImageResource(R.drawable.d);
                break;
            case 5:
                image2.setImageResource(R.drawable.e);
                break;
        }

        // obtener tercera imagen

        switch (img3) {
            case 1:
                image3.setImageResource(R.drawable.a);
                break;
            case 2:
                image3.setImageResource(R.drawable.b);
                break;
            case 3:
                image3.setImageResource(R.drawable.c);
                break;
            case 4:
                image3.setImageResource(R.drawable.d);
                break;
            case 5:
                image3.setImageResource(R.drawable.e);
                break;
        }

    }

    public void getScore(){
        // tres imagenes iguales
        if (img1 == img2 && img2 == img3) {
            Toast.makeText(this,"JACKPOT!!!!",Toast.LENGTH_SHORT).show();
        }

        // dos imagenes iguales
        if (img1 == img2 || img2 == img3 || img1 == img3) {
            Toast.makeText(this,"Increible!!!!",Toast.LENGTH_SHORT).show();
        }
    }

    public void calculateGame(){
        image1.setImageResource(R.drawable.anim);
        final AnimationDrawable image1anim = (AnimationDrawable) image1.getDrawable();
        image1anim.start();

        image2.setImageResource(R.drawable.anim);
        final AnimationDrawable image2anim = (AnimationDrawable) image2.getDrawable();
        image2anim.start();

        image3.setImageResource(R.drawable.anim);
        final AnimationDrawable image3anim = (AnimationDrawable) image3.getDrawable();
        image3anim.start();

        // Detener Animacion
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                image1anim.stop();
                image2anim.stop();
                image3anim.stop();

                setImages();

                getScore();
            }
        },500);
    }

    public void calculateGame(int t){
        image1.setImageResource(R.drawable.anim);
        final AnimationDrawable image1anim = (AnimationDrawable) image1.getDrawable();
        image1anim.start();

        image2.setImageResource(R.drawable.anim);
        final AnimationDrawable image2anim = (AnimationDrawable) image2.getDrawable();
        image2anim.start();

        image3.setImageResource(R.drawable.anim);
        final AnimationDrawable image3anim = (AnimationDrawable) image3.getDrawable();
        image3anim.start();

        // Detener Animacion
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                image1anim.stop();
                image2anim.stop();
                image3anim.stop();

                setImages();

                getScore();
            }
        },500);
    }

    @Override
    public void onResume() {
        super.onResume();
        // Add the following line to register the Session Manager Listener onResume
        mSensorManager.registerListener(mShakeDetector, mAccelerometer,	SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onPause() {
        // Add the following line to unregister the Sensor Manager onPause
        mSensorManager.unregisterListener(mShakeDetector);
        super.onPause();
    }


}