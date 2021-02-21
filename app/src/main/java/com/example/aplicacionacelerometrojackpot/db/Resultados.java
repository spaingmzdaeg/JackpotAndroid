package com.example.aplicacionacelerometrojackpot.db;

import android.provider.BaseColumns;

public final class Resultados  {

    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private Resultados() {}

    /* Inner class that defines the table contents */
    public static class ResultadosEntrada implements BaseColumns {

        public static final String TABLE_NAME = "resultado_jackpot";
       // public static final String COLUMN_ID_RESULTADO = "id_resultado";
        public static final String COLUMN_RESULTADO_A = "resultado_a";
        public static final String COLUMN_RESULTADO_B = "resultado_b";
        public static final String COLUMN_RESULTADO_C = "resultado_c";
        public static final String COLUMN_RESULTADO_FINAL = "resultado_final";
    }

}

