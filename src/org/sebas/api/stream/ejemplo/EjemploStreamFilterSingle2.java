package org.sebas.api.stream.ejemplo;

import org.sebas.api.stream.ejemplo.models.Usuario;

import java.util.stream.Stream;

public class EjemploStreamFilterSingle2 {
    public static void main(String[] args) {

        //TODO: Solo se puede ejecutar un findFirst().get() a la ves si hay varios
        // en diferentes variables ocurren conflictos

        //Ejemplo 1
        Usuario usuario = Stream
                .of("Pato Guzman", "Pepa Ascarate", "Pepito Dominguez","Luis Diaz","Luis Perez")
                .map(ele -> new Usuario(ele.split(" ")[0], ele.split(" ")[1]))
                .filter(u -> u.getNombre().equals("Luis"))
                .findFirst().get();
        //System.out.println(usuario);

        //Ejemplo2
        Usuario user2 = Stream
                .of("Pato Guzman", "Pepa Ascarate", "Pepito Dominguez","Luis Diaz","Luis Perez"
                        ,"Jose Antonio")
                .map(ele -> new Usuario(ele.split(" ")[0], ele.split(" ")[1]))
                .filter(u -> u.getId().equals(2))
                // findFirst() -> Buscar el primer usuario , get() -> Obtener el usuario
                .findFirst().get();
        //System.out.println(user2);


        /*
           Explicacion de como funciona el findFirts().
           Buscamos el id == 2, por lo tanto si lo encuentra
           y aun no ha recorrido toda la lista se detiene ahi
           y devuelve el valor que buscaba

           Si ponemos id == 5, con el peek muestra toda la lista recorrida ya que busca
           el ultimo elemento pero si busca id == 2, el peek solo muestar los nombres
           hasta que id == 2, y no sigue hasta el ultimo
         */
        //System.out.println("Usuario 3: " + getUsuarioNumber3());



        //Prueba personal xd
        String findNumber = Stream.of(3,4,5,7)
                .filter(e -> e > 5)
                .map(String::valueOf)
                .findFirst().get();
        System.out.println(findNumber);

    }
    private static Usuario getUsuarioNumber3(){
        Usuario user;
        return user = Stream
                .of("Pato Guzman", "Pepa Ascarate", "Pepito Dominguez","Luis Diaz","Luis Perez"
                        ,"Jose Antonio", "Maria Antonieta")
                .map(ele -> new Usuario(ele.split(" ")[0], ele.split(" ")[1]))
                .peek(System.out::println)
                .filter(i -> i.getId().equals(3))
                //Por si no cuentra el dato, manejarlo con orElse(), que hace lo mismo que el get()
                //solo que maneja el error
                .findFirst().orElseGet(() -> new Usuario("John","Doe"));

    }
}
