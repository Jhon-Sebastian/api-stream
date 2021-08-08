package org.sebas.api.stream.ejemplo;

import org.sebas.api.stream.ejemplo.models.Usuario;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjemploStreamDistinctUsuarioSum {
    public static void main(String[] args) {

        /*
            TODO: {mapToInt, mapToDouble, mapToLong}

            Estos operadores convierten la salida en objetos de
            esos tipos
            1. mapToInt = IntStream
            2. mapToDouble = DoubleStream
            3. mapToLong = LongStream
         */

        IntStream largoNombres = Stream
                .of("Pato Guzman", "Pepa Ascarate", "Pepito Dominguez","Luis Diaz","Luis Perez"
                ,"Pato Guzman")
                .map(ele -> new Usuario(ele.split(" ")[0], ele.split(" ")[1]))
                .distinct()
                // Convierte los usuarios en un IntStream, el IntStream extiende de Integer
                // se podria decir que tambien es un tipo de dato numerico
                .mapToInt(u -> u.toString().length())
                .peek(System.out::println);

        /*
            TODO: Aqui ocurre algo, si dejamos los dos:
            Ocurre que hay dos operadores finales, pero solo puede haber 1
            por ello ocurre una expcetion, solo pude haber un operador final
            a la ves, para evitar eso podemos usar el peek, esa es la gracia
            del peek.

            largoNombres.forEach(System.out::println);
            System.out.println("Suma de datos:" + largoNombres.sum());

            Si vamos a llamar directamente el max(),min(),average(),count(),
            despues de haber llamdado al sum(), ocurre un error ya que todos
            ellos son operadores finales, por lo tanto para solucionar eso
            se crea una instancia de TODO: IntSummaryStatistics
         */
        //largoNombres.forEach(System.out::println);
        IntSummaryStatistics stats = largoNombres.summaryStatistics();
        System.out.println("Suma de largo de cadenas: " + stats.getSum());
        System.out.println("Numero mayor: " + stats.getMax());
        System.out.println("Numero menor: " + stats.getMin());
        System.out.println("Promedio: " + stats.getAverage());
        System.out.println("Numero de elementos: " + stats.getCount());



    }
}
