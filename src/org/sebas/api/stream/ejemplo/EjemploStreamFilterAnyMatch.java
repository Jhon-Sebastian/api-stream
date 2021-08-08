package org.sebas.api.stream.ejemplo;

import org.sebas.api.stream.ejemplo.models.Usuario;

import java.util.stream.Stream;

public class EjemploStreamFilterAnyMatch {
    public static void main(String[] args) {

        /*
            TODO: AnyMatch
            Buscar el usuario pero en lugar de retonarlo devuelve un boolean

            En este caso no va findFirst() ya que el anyMatch es operador terminal y solo
            puede haber uno

            Ademas no va el filter porque el anyMatch() es una conbinacion entre filter() y findFirst().get()
         */

        boolean existe = Stream
                .of("Pato Guzman", "Pepa Ascarate", "Pepito Dominguez","Luis Diaz","Luis Perez"
                        ,"Jose Antonio", "Maria Antonieta")
                .map(ele -> new Usuario(ele.split(" ")[0], ele.split(" ")[1]))
                .peek(System.out::println)
                .anyMatch(i -> i.getId().equals(1));
        System.out.println("Exite el usuario con id 1: " + existe);

    }
}
