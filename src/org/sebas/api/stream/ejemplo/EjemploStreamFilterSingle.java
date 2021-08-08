package org.sebas.api.stream.ejemplo;

import org.sebas.api.stream.ejemplo.models.Usuario;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamFilterSingle {
    public static void main(String[] args) {

        Stream<Usuario> usuarios = Stream
                .of("Pato Guzman", "Pepa Ascarate", "Pepito Dominguez","Luis Diaz","Luis Perez")
                .map(ele -> new Usuario(ele.split(" ")[0], ele.split(" ")[1]))
                .filter(u -> u.getNombre().equals("Luis2"))
                .peek(System.out::println);

        // findFirst -> Para obtener solo el primer usuario
        Optional<Usuario> user = usuarios.findFirst();
        //System.out.println(user.get());


        /*  TODO: orElse
            La idea del Optional es evitar el NullPointerException, por lo tanto
            en lugar de usar el get(), se puede usar el orElse(), que regresa
            un valor por defecto si no se cuentra el que se quiere

            System.out.println(user.orElse(new Usuario("John","Doe")).getNombre());
         */


        /*
            TODO: orElseGet
            Mismo resultado que el orElse(), pero usando una expresion lambda

            System.out.println(user.orElseGet(() -> new Usuario("John","Doe")).getNombre());
         */

        /*
            TODO: isPresent
            Regresa tru si el datoa  buscar se encuentra, todo lo contrario
            a isEmpty pero son parecidos solo que uno es la negacion del otro
         */
        if(user.isPresent()){
            System.out.println(user.get());
        }else{
            System.out.println("No se encontro el objeto!");
        }

    }
}
