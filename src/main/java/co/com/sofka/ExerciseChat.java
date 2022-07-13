package co.com.sofka;

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
            if (badWords.contains(a)) {
                a = "****";
            }
            return a;
        }).subscribe(a-> System.out.print(a+" "));
    }
}
