package org.sebas.api.stream.ejemplo;

import org.sebas.api.stream.ejemplo.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class EjemploStreamParallel {
    public static void main(String[] args) {

        /*
            TODO: Parallel
            Convertimos el flujo de Stream a un flujo que soporte
            un Pool de Threads, para que se procesen en paralelo

            Antes se demoraba 7 segundos para encontrar el Usuario,
            ahora como lo hace en paralelo se demora 1 segundo
         */

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

        long t1 = System.currentTimeMillis();

        //Converti a Stream<Usuario> y luego de tipo String
        String resultado = lista.stream()
                .parallel()
                .map(u -> u.toString().toUpperCase())
                .peek(n -> {
                    System.out.println("Nombre del Thread: " + Thread.currentThread().getName()
                    + " -> " + n);
                })
                .flatMap(nombre -> {
                    //Como nombre tiene = nombre+apellido, es mejor usar contains
                    //para preguntar si en el String que pasa contiene el value
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(nombre.contains("bruce".toUpperCase())){
                        return Stream.of(nombre);
                    }
                    return Stream.empty();
                })
                .findAny().orElse("");
        long t2 = System.currentTimeMillis();
        System.out.println("Tiempo total: " + (t2-t1));
        System.out.println(resultado);
    }
}
