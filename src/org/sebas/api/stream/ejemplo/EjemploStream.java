package org.sebas.api.stream.ejemplo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStream {
    public static void main(String[] args) {

        /*
            TODO: ¿QUE ES UN STREAM?
            Un stream es una representación abstracta de una secuencia de elementos.
            Su propósito principal es facilitar la ejecución de operaciones sobre dicha secuencia.
            Operaciones individuales sobre cada elemento, sobre un subconjunto de ellos,
            o sobre la totalidad de los mismos. Ejecutadas de forma secuencial o paralela.
            Evaluadas normalmente de forma perezosa.
            Y con el propósito de modificar los elementos de la secuencia,
            obtener una nueva secuencia, extraer un elemento individual,
            o calcular un valor agregado.

            TODO: CARACTERISTICAS
            - No almacenan datos
            - Orientado a la programacion funcional
            - No modifica la instancia original
            - No tiene un tamaño fijo

            TODO:CREAR UN STREAM
            Para crear un Stream hay varios formas
            1. Atraves de un arreglo
            2. De forma estatica con la interfaz Stream y metodo estatico of();
            3. O a partir de una coleccion

            TODO: TIPOS DE OPERADORES EN LOS STREAMS
            Para hacer algo con estos datos, se invocan a los operadores
            1. Intermedios = Realizan trasnformaciones
            2. Finales = Para hacer alguna accion o convertir a algun tipo los datos o flujo
         */




        //TODO: 1 Forma crear un Stream [Metodo of]
        Stream<String> nombres = Stream.of("Pato","Pepa","Pepito");
        // **OPERADOR FINAL**
        // Solo muestra la informacion, no la modifica y no retorna nada
        nombres.forEach(System.out::println);


        //TODO: 2 Forma crear un Stream [Arreglo usando la clase helpers Arrays]
        String[] arr = {"Pato","Pepa","Pepito"};
        Stream<String> nombres2 = Arrays.stream(arr);
        nombres2.forEach(System.out::println);

        //TODO: 3 Forma crear un Stream [ Usando Builder ]
        //.build() -> Lo transoforma a Stream<T>
        Stream<String> nombres3 = Stream.<String>builder().add("Carlos")
                .add("Luis")
                .add("Pepa")
                .add("Paco")
                .build();
        nombres3.forEach(System.out::println);

        //TODO: 4 Forma crear un Stream [ Usando tipo Collection {List,Set}]
        List<String> lista = new ArrayList<>();
        lista.add("Anival");
        lista.add("Ra");
        lista.add("Venito");
        lista.add("Churchill");
        /*  1. Forma
            Stream<String> nombres4 = lista.stream();
            nombres4.forEach(System.out::println);
         */
        lista.stream().forEach(System.out::println);

    }
}
