package org.sebas.api.stream.ejemplo;

import org.sebas.api.stream.ejemplo.models.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamMap {
    public static void main(String[] args) {

        /*
            TODO: Map
            Retorna una nueva instancia con los cambios que
            se le hallan dado, sin modificar la isntancia
            original ya que es inmutable
         */

        /*
            TODO: Peek
            Es solo para mirar, observar, parecido al foreach,
            se ejecuta como un operador intermedio, no es final
            como el foreach que retorna un void
         */

        /*
            TODO: Collect
            Es un operador terminal que convierte a una lista
         */

        Stream<String> nombres = Stream
                .of("Pato", "Pepa", "Pepito")
                .peek(e -> System.out.println(e))
                .map(nombre -> {
                    return nombre.toUpperCase();
                });
        //El foreach es el que gatilla la impresion de datos
        //nombres.forEach(System.out::println);


        //TODO: Otra opcion
        Stream<String> nombres2 = Stream
                .of("Pato", "Pepa", "Pepito")
                .map(nombre -> {
                    return nombre.toUpperCase();
                })
                .peek(e -> System.out.println(e))
                .map(a -> a.toLowerCase());
        //nombres2.forEach(System.out::println);


        //TODO: Optimizando
        Stream<String> nombres3 = Stream
                .of("Pato", "Pepa", "Pepito")
                .map(String::toUpperCase)
                .peek(System.out::println)
                .map(String::toLowerCase);
        //nombres3.forEach(System.out::println);


        //TODO: Si se quiere convertir a una lista con estos cambios
        Stream<String> nombres4 = Stream
                .of("Pato", "Pepa", "Pepito")
                .map(String::toUpperCase)
                .peek(System.out::println)
                .map(String::toLowerCase);
        //List<String> lista = nombres4.collect(Collectors.toList());
        //lista.forEach(System.out::println);
        //nombres4.forEach(System.out::println);


        //TODO: Convertir a un tipo Usuario
        Stream<Usuario> usuarios = Stream
                .of("Pato Guzman", "Pepa Ascarate", "Pepito Dominguez")
                .map(ele -> new Usuario(ele.split(" ")[0], ele.split(" ")[1]))
                .peek(u -> System.out.println(u.getNombre()))
                .map(usuario -> {
                    String nombre = usuario.getNombre().toUpperCase();
                    usuario.setNombre(nombre);
                    return usuario;
                });
        List<Usuario> listaUsuarios = usuarios.collect(Collectors.toList());
        listaUsuarios.forEach(u -> System.out.println(u.getApellido()));

    }
}
