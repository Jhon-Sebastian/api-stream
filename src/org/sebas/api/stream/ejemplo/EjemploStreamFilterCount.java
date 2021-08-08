package org.sebas.api.stream.ejemplo;

import org.sebas.api.stream.ejemplo.models.Usuario;

import java.util.stream.Stream;

public class EjemploStreamFilterCount {
    public static void main(String[] args) {

        /*
            TODO: Count
            Regresa la cantidad de elementos que hay y no recibe nada por argumento
         */

        long count = Stream
                .of("Pato Guzman", "Pepa Ascarate", "Pepito Dominguez","Luis Diaz","Luis Perez"
                        ,"Jose Antonio", "Maria Antonieta")
                .map(ele -> new Usuario(ele.split(" ")[0], ele.split(" ")[1]))
                .peek(System.out::println)
                .count();
        System.out.println("Numero de elementos: " + count);

    }
}
