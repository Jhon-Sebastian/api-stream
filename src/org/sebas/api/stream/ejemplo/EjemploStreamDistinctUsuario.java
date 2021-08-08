package org.sebas.api.stream.ejemplo;

import org.sebas.api.stream.ejemplo.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamDistinctUsuario {
    public static void main(String[] args) {

        /*
            En String es facil hacer el distinct porque compara entre cadenas,
            pero con objetos lo compara con el metodo equals por lo tanto
            toca implementarlo
         */

        Stream<Usuario> usuarios = Stream
                .of("Pato Guzman", "Pepa Ascarate", "Pepito Dominguez","Luis Diaz","Luis Perez"
                ,"Pato Guzman")
                .map(ele -> new Usuario(ele.split(" ")[0], ele.split(" ")[1]))
                .distinct();

        usuarios.forEach(System.out::println);


    }
}
