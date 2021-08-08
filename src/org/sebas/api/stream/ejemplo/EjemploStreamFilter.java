package org.sebas.api.stream.ejemplo;

import org.sebas.api.stream.ejemplo.models.Usuario;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamFilter {
    public static void main(String[] args) {

        /*
            TODO: Filter
            El operador sirve para filtrar datos y lo que hace es
            regresar una nueva instancia con los valores filtrados
         */

        Stream<Usuario> usuarios = Stream
                .of("Pato Guzman", "Pepa Ascarate", "Pepito Dominguez","Luis Diaz","Luis Perez")
                .map(ele -> new Usuario(ele.split(" ")[0], ele.split(" ")[1]))
                .filter(u -> u.getNombre().equals("Luis"))
                .peek(System.out::println);
        List<Usuario> listaUsuarios = usuarios.collect(Collectors.toList());
        listaUsuarios.forEach(System.out::println);

    }
}
