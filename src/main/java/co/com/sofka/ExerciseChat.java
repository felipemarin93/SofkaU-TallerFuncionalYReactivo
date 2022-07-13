package co.com.sofka;

import reactor.core.publisher.Flux;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExerciseChat {

    public static void main(String[] args) {
        System.out.println("Bienvenid@ al Chat sensurado , ingresa una cadena de texto, el cual filtrará las groserías y las reemplaza por **** ");

        Scanner scanner = new Scanner(System.in);
        System.out.println("chat ...... ");
        String cadena = scanner.nextLine().toLowerCase();
        String[] arreglo = cadena.split(" ");
        List<String> chat = Arrays.asList(arreglo);
        Flux<String> nuevoChat = Flux.fromIterable(chat).map(p -> comparar(p));
        nuevoChat.subscribe(x -> System.out.print(" " + x + " "));
    }
    private static String comparar(String palabra) {
        String retorno = "****";

        List<String> groserias = new ArrayList<>();
        groserias.add("guevon");
        groserias.add("marica");
        groserias.add("puta");
        groserias.add("imbecil");
        groserias.add("culo");
        groserias.add("puta");
        groserias.add("estupido");
        groserias.add("gonorrea");
        groserias.add("catrechimba");
        groserias.add("recontragonorrea");
        groserias.add("hijueputa");
        groserias.add("malparido");
        groserias.add("perra");
        groserias.add("careverga");
        groserias.add("hijo de verga");
        groserias.add("carechimba");
        groserias.add("mierda");
        groserias.add("pirobo");
        groserias.add("mama");
        groserias.add("suya");

        Stream<String> respuesta = groserias.stream().filter(x -> x.equals(palabra));

        String response = respuesta.collect(Collectors.joining());

        if(response.equals(palabra)){

            return retorno;
        }
        return palabra;
    }
}
