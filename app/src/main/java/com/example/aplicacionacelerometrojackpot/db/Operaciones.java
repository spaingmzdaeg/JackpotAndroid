package com.example.aplicacionacelerometrojackpot.db;

public class Operaciones {
    public static final String SQL_CREAR_ENTRADAS =
            "CREATE TABLE " + Resultados.ResultadosEntrada.TABLE_NAME + " (" +
                    Resultados.ResultadosEntrada._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    Resultados.ResultadosEntrada.COLUMN_RESULTADO_A + " TEXT," +
                    Resultados.ResultadosEntrada.COLUMN_RESULTADO_B + " TEXT," +
                    Resultados.ResultadosEntrada.COLUMN_RESULTADO_C + " TEXT," +
                    Resultados.ResultadosEntrada.COLUMN_RESULTADO_FINAL + " TEXT)";

    public static final String SQL_ELIMINAR_ENTRADAS =
            "DROP TABLE IF EXISTS " + Resultados.ResultadosEntrada.TABLE_NAME;
}
