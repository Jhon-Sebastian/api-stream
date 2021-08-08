package org.sebas.api.stream.ejemplo;

import org.sebas.api.stream.ejemplo.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamFilterEmpty {
    public static void main(String[] args) {

        //Pequeño ejercicio que cuenta cuantos elementos son vacios

        long numUsuariosVacios = Stream
                .of("Pato Guzman", "Pepa Ascarate", "", "", "Luis Perez")
                .filter(String::isEmpty)
                .count();
        System.out.println("numUsuariosVacios = " + numUsuariosVacios);

    }
}
