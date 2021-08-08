package org.sebas.api.stream.ejemplo;

import org.sebas.api.stream.ejemplo.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStreamListToStream {
    public static void main(String[] args) {

        //Tenemos la lista
        List<Usuario> lista = new ArrayList<>();
        lista.add(new Usuario("Andres","Guzman"));
        lista.add(new Usuario("Luci","Martinez"));
        lista.add(new Usuario("Pepe","Fernandez"));
        lista.add(new Usuario("Cata","Perez"));
        lista.add(new Usuario("Lalo","Mena"));
        lista.add(new Usuario("Exequiel","Doe"));
        lista.add(new Usuario("Bruce","Lee"));
        lista.add(new Usuario("bruce","Willis"));


        //Converti a Stream<Usuario> y luego de tipo String
        Stream<String> nombres = lista.stream()
                .map(u -> u.getNombre().toUpperCase().concat(" ").concat(u.getApellido().toUpperCase()))
                .flatMap(nombre -> {
                    //Como nombre tiene = nombre+apellido, es mejor usar contains
                    //para preguntar si en el String que pasa contiene el value
                    if(nombre.contains("bruce".toUpperCase())){
                        return Stream.of(nombre);
                    }
                    return Stream.empty();
                })
                .map(String::toLowerCase)
                .peek(System.out::println);

        System.out.println(nombres.count());

    }
}
