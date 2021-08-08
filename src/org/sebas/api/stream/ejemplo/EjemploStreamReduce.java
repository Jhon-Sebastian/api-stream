package org.sebas.api.stream.ejemplo;

import java.util.stream.Stream;

public class EjemploStreamReduce {
    public static void main(String[] args) {

        /*
            TODO: Reduce - operador terminal

            Para reducir el flujo de varios elementos en un solo elemento,
            y estos elementos se puede ir combinando, si es Int ir sumando,
            si es String ir concatenando
         */

        Stream<String> nombres = Stream.of("Pato Guzman", "Pepa Ascarate", "Pato Guzman","Luis Diaz","Luis Perez")
                .distinct();

        /*
            Recibe dos argumentos
            1. Valor inicial
            2. (a,b) -> a=anterior, b=actual
         */
        String resultado = nombres.reduce("Resultado concatenacion ",(a,b) -> a+" # "+b);
        System.out.println(resultado);

    }
}
