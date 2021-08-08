package org.sebas.api.stream.ejemplo;

import org.sebas.api.stream.ejemplo.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamDistinct {
    public static void main(String[] args) {

        //Metodo distinct(), si esta repetido no lo vuelve a mostrar

        Stream.of("Pato Guzman", "Pepa Ascarate", "Pato Guzman","Luis Diaz","Luis Perez")
                .distinct()
                .forEach(System.out::println);

    }
}
