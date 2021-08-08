package org.sebas.api.stream.ejemplo;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjemploStreamRange {
    public static void main(String[] args) {

        /*
            TODO: Range
            No es parte del Stream, pero si hay un Stream especial
            para crear un flujo de enteros que si tiene el Range -> IntStream

            Range desde el 5 hasta el 19, se incluye el primero argumento
            pero no el ultimo

            Ademas podemos evitar usar el reduce(), ya que el IntStream
            tiene el operador sum(), que suma los valores automaticamnete

            TODO: RangeClosed
            Hace lo mismo que el range lo unica diferencia es que si incluye
            el 2 argumento
         */
        IntStream numbers = IntStream.range(5,20)
                .peek(System.out::println);


        //int resultado = numbers.reduce(0, Integer::sum);
        //int resultado = numbers.sum();
        //System.out.println("Suma de los elementos: " + resultado);


        //Regresa un objeto de tipo IntSummaryStatistics, el cual trae varias estadisticas como:
        System.out.println("\n**Opcional pero interesante**");

        IntSummaryStatistics statistics = numbers.summaryStatistics();
        System.out.println("Numero mayor: " + statistics.getMax());
        System.out.println("Numero menor: " + statistics.getMin());
        System.out.println("Suma: " + statistics.getSum());
        System.out.println("Promedio:  " + statistics.getAverage());
        System.out.println("Total de elementos: " + statistics.getCount());

        /*
        System.out.println("\n*****");
        IntSummaryStatistics prueba = new IntSummaryStatistics();
        prueba.accept(1);
        prueba.accept(2);
        prueba.accept(3);
        prueba.accept(4);
        System.out.println("Numero mayor: " + prueba.getMax());
        System.out.println("Numero menor: " + prueba.getMin());
        System.out.println("Suma: " + prueba.getSum());
        System.out.println("Promedio:  " + prueba.getAverage());
        System.out.println("Total de elementos: " + prueba.getCount());
         */
    }
}
