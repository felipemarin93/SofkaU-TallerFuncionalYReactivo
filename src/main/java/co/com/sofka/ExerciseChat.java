package co.com.sofka;


/**
 * * @Autor Daniel Felipe Marin Giraldo
 *  * v 0.1
 *  Ejercicio 2. Crear un chat, un input donde lo que se ingrese sea almacenado en una lista, para posteriormente cambiar en la lista las malas palabras, para sos y compararlas con la lista
 * del chat y si se encuentra una reemplazarla por: **** , esto respetando los principios de la programación reactiva.
 *
 */

import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class ExerciseChat {

    public static void main(String[] args) {
        System.out.println("Bienvenid@ al Chat sensurado");

        List<String> badWords = List.of("hp", "marica", "pendejo", "perra", "mierda", "malparido", "gonorrea", "estupido", "soplamonda","estupido","hijueputa","verga","malparida","caremonda");
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduza un texto el cual filtrará las groserías");;
        String wordsList = sc.nextLine();
        var newWordList = Arrays.stream(wordsList.split(" ")).toList();

        Flux.fromIterable(newWordList).map(a -> {
            if (badWords.contains(a.toLowerCase())) {
                a = "****";
            }
            return a;
        }).subscribe(a-> System.out.print(a+" "));
    }
}
