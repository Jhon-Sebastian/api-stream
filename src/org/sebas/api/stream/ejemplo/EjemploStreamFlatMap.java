package org.sebas.api.stream.ejemplo;

import org.sebas.api.stream.ejemplo.models.Usuario;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamFlatMap {
    public static void main(String[] args) {

        /*
            TODO: FlatMap
            Es muy parecido al map pero debemos retornar un Stream

            El flatMap devuelve o retornar varias salidas, por cada elemento
            devuelve un Stream separado, pero por debajo los convierte
            de un solo Stream

            Estos Stream se van a aplanar en una sola corriente, en un
            solo Stream
         */
        Stream<Usuario> usuarios = Stream
                .of("Pato Guzman", "Pepe Ascarate", "Pepito Dominguez","Pepe Diaz","Luis Perez")
                .map(ele -> new Usuario(ele.split(" ")[0], ele.split(" ")[1]))
                .flatMap(u -> {
                    //Hace lo mismo que filter solo que devuelve un Stream
                    if(u.getNombre().equals("Pepe")){
                        //Convertimos el usuario en un Stream
                        return Stream.of(u);
                    }
                    //Si no conciende regresamos un Stream vacio
                    return Stream.empty();
                })
                .peek(System.out::println);

        usuarios.forEach(System.out::println);
    }
}
