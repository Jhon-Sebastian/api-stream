package org.sebas.api.stream.ejemplo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class EjemploStreamInfinitoGenerate {
    public static void main(String[] args) {

        AtomicInteger contador = new AtomicInteger(0);
        //Crear un Stream infinito, para eso le podemos dar un limite
        Stream.generate( () ->  {
            try {
                TimeUnit.SECONDS.sleep(2);//Le podemos dar un delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return contador.incrementAndGet();
        })
                .limit(7) // # de elementos limite
                .forEach(System.out::println);

    }
}
