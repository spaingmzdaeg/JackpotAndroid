package com.example.aplicacionacelerometrojackpot;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.Sensor;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.aplicacionacelerometrojackpot.db.Resultados;
import com.example.aplicacionacelerometrojackpot.db.ResultadosDbHelper;

public class ListViewResultados extends AppCompatActivity {
    private ResultadosDbHelper dbHelper = new ResultadosDbHelper(this);
    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_resultados);

        lv =  findViewById (R.id.listviewResultados);

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String query = "SELECT * FROM resultado_jackpot"; // No trailing ';'
       // String query = "SELECT * FROM resultado_jackpot ORDER BY  resultado_final"; // No trailing ';'

        Cursor cursor = db.rawQuery(query,null);



        ResultadosAdapter adapter = new ResultadosAdapter(
                this, R.layout.activity_resultados_adapter, cursor, false );



        lv.setAdapter(adapter);

    }

    /*
    Codigo para filtrar resultados va dentro del oncreate despues de definir el
    list view
     SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                BaseColumns._ID,
                Resultados.ResultadosEntrada.COLUMN_RESULTADO_A,
                Resultados.ResultadosEntrada.COLUMN_RESULTADO_B,
                Resultados.ResultadosEntrada.COLUMN_RESULTADO_C,
                Resultados.ResultadosEntrada.COLUMN_RESULTADO_FINAL
        };


        String selection = Resultados.ResultadosEntrada.COLUMN_RESULTADO_FINAL + " = ?";
        String[] selectionArgs = { "jackpot" };


        String sortOrder =
                Resultados.ResultadosEntrada.COLUMN_RESULTADO_B + " DESC";

        Cursor cursor = db.query(
                Resultados.ResultadosEntrada.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder
        );


        ResultadosAdapter adapter = new ResultadosAdapter(
                this, R.layout.activity_resultados_adapter, cursor, false );



        lv.setAdapter(adapter);
     */

}