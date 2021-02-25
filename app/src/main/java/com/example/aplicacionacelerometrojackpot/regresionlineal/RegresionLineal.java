package com.example.aplicacionacelerometrojackpot.regresionlineal;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;

public class RegresionLineal {
   // public static List<Integer> x = asList(); // cantidad de veces tiradas
    //public static List<Integer> y = asList(); // Resultados Jackpot

    public static Double prediccionParaValor(int prediccionParaVariableDependiente,List<Integer> x,
                                             List<Integer> y) {
        if (x.size() != y.size())
            throw new IllegalStateException("Debe tener puntos de datos X e Y iguales");

        Integer numeroDeDatosValores = x.size();

        List<Double> xCuadrada = x
                .stream()
                .map(posicion -> Math.pow(posicion, 2))
                .collect(Collectors.toList());

        List<Integer> xMultiplicadoPorY = IntStream.range(0, numeroDeDatosValores)
                .map(i -> x.get(i) * y.get(i))
                .boxed()
                .collect(Collectors.toList());

        Integer xSuma = x
                .stream()
                .reduce((anterior, siguiente) -> anterior + siguiente)
                .get();

        Integer ySuma = y
                .stream()
                .reduce((anterior, siguiente) -> anterior + siguiente)
                .get();

        Double sumaDeXCuadrada = xCuadrada
                .stream()
                .reduce((anterior, siguiente) -> anterior + siguiente)
                .get();

        Integer sumaDeXMultiplicadaPorY = xMultiplicadoPorY
                .stream()
                .reduce((anterior, siguiente) -> anterior + siguiente)
                .get();

        int pendienteNominada = numeroDeDatosValores * sumaDeXMultiplicadaPorY - ySuma * xSuma;
        Double pendienteDenominada = numeroDeDatosValores * sumaDeXCuadrada - Math.pow(xSuma, 2);
        Double pendiente = pendienteNominada / pendienteDenominada;

        double interceptarNominador = ySuma - pendiente * xSuma;
        double interceptarDenominador = numeroDeDatosValores;
        Double interceptar = interceptarNominador / interceptarDenominador;

        return (pendiente * prediccionParaVariableDependiente) + interceptar;
    }

    public static void main(String[] args) {

    }
}
