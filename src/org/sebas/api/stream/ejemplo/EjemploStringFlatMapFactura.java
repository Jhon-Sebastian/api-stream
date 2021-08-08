package org.sebas.api.stream.ejemplo;

import org.sebas.api.stream.ejemplo.models.Factura;
import org.sebas.api.stream.ejemplo.models.Usuario;

import java.util.Arrays;
import java.util.List;

public class EjemploStringFlatMapFactura {
    public static void main(String[] args) {

        /*
            TODO: Concepto personal
            Lo veo de esta manera, si tenemos un Objeto que a su ves
            tiene una como atributo Lits<Objeto>, para poder llamar
            a esta lista interna en programacion funcional, sin necesidad
            de hacer un for anidado, se usa el flatMap, el cual regresa
            un Stream.

            Por lo cual iteramos todos los Usuarios y a su ves o
            obtener la List<Facturas> de cada Usuario.
            Llamamos el metodo get() para obtener toda la lista de facturas
            y la convertimos a un stream con todo: listFacturas.stream()
            con el objetivo de poder iterar esa lista de facturas

            todo= Conclusion:
            El Stream a mi parecer funciona para iterar y si tenemos una lista
            interna que queremos iterar solo la convertimos a un stream para
            que itere cada elemento de esa lista interna y el flatMap es perfecto
         */

        Usuario u1 = new Usuario("Jhon","Doe");
        Usuario u2 = new Usuario("Pepe","Perez");

        u1.addFactura(new Factura("Compras Tecnologia"));
        u1.addFactura(new Factura("Compras Muebles"));

        u2.addFactura(new Factura("Bicicleta"));
        u2.addFactura(new Factura("Notebook Gamer"));

        List<Usuario> usuarios = Arrays.asList(u1,u2);
        /*
        Debemos devolver un Stream, por lo tanto obtenemos la lista de Facturas
        y la convertimos a un stream

            TODO: Me gusto mas esta forma que encontre
         */
        usuarios.stream()
                .peek(usuario -> System.out.println("\n**"+usuario.getNombre()+"**= "))
                .flatMap(u -> u.getFacturas().stream())
                .forEach(f -> System.out.println(f.getDescripcion()));


        /* TODO: Otra manera de hacer lo mismo
        usuarios.stream()
                .map(Usuario::getFacturas)
                .flatMap(List::stream)
                .forEach(f -> System.out.println(f.getDescripcion()));
         */

        /* TODO: Otra manera de hacer lo mismo
        usuarios.stream()
                .map(Usuario::getFacturas)
                .flatMap(List::stream)
                .forEach(f -> System.out.println(f.getDescripcion()
                        .concat(" : cliente")
                        .concat(f.getUsuario().toString())));
        */

    }
}
