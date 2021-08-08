package org.sebas.api.stream.ejemplo;

import java.util.stream.Stream;

public class EjemploStreamReduceEnteros {
    public static void main(String[] args) {

        Stream<Integer> nombres = Stream.of(5,10,15,20);

        //int resultado = nombres.reduce(0, (a,b) -> a+b);
        int resultado = nombres.reduce(0, Integer::sum);
        System.out.println("Suma de los elementos: " + resultado);

    }
}
