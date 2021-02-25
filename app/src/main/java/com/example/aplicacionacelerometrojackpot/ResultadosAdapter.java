package com.example.aplicacionacelerometrojackpot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.view.View;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

public class ResultadosAdapter extends ResourceCursorAdapter {

    public ResultadosAdapter(Context context, int layout, Cursor c, boolean autoRequery) {
        super(context, layout, c, autoRequery);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView id_resultado = (TextView) view.findViewById(R.id.text_view_id_resultado);
        id_resultado.setText("ID:"+cursor.getString(cursor.getColumnIndex(BaseColumns._ID)));

        TextView resultado_a = (TextView) view.findViewById(R.id.text_view_resultado_a);
        resultado_a.setText("resultado_a:"+cursor.getString(cursor.getColumnIndex("resultado_a")));

        TextView resultado_b = (TextView) view.findViewById(R.id.text_view_resultado_b);
        resultado_b.setText("resultado_b:"+cursor.getString(cursor.getColumnIndex("resultado_b")));

        TextView resultado_c = (TextView) view.findViewById(R.id.text_view_resultado_c);
        resultado_c.setText("resultado_c:"+cursor.getString(cursor.getColumnIndex("resultado_c")));

        TextView resultado_juego = (TextView) view.findViewById(R.id.text_view_resultado_juego);
        resultado_juego.setText("resultado_juego:"+cursor.getString(cursor.getColumnIndex("resultado_juego")));

        TextView resultado_final = (TextView) view.findViewById(R.id.text_view_resultado_final);
        resultado_final.setText("resultado_final:"+cursor.getString(cursor.getColumnIndex("resultado_final")));

    }
}