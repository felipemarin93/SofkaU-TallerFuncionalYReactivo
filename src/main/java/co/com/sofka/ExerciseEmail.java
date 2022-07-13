/**
 * Programación reactiva y funcional
 *
 *
 * Ejercicio 1 - valor 65%
 *
 * Si se realiza bien por completo este ejercicio obtienes el 65% de la nota.
 *
 *
 * Crear una lista de mínimo 30 correos, de los cuales se le deben aplicar los siguientes operadores:
 *
 * Distinct: para ver si hay correo repetidos, si hay correos repetidos eliminarlos
 * Filtro: para saber si hay correos con dominio gmail, hotmail y outlook.
 * Map: para saber si todos los correos cumple con todas las condiciones (Que cuente con el @ y el dominio)
 * Saber la cantidad de correos que hay, sin usar un ciclo
 * Saber la cantidad de correos gmail, hotmail y outlook sin usar un ciclo
 * En la misma lista determinar si se envió un correo o no a cada uno de los correos, si se le envió cambiar el estado en la lista, todo esto respetando la inmutabilidad.
 *
 *
 * @Autor Daniel Felipe Marin
 */

package co.com.sofka;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ExerciseEmail {

    public static void main(String[] args) {
        List<Email> emails = List.of(
                new Email("danielfelipe@hotmail.com", false),
                new Email("danielfelip@hotmail.com", false),
                new Email("danielfelihotmail.com", true),
                new Email("danielfel@gmail.com", false),
//                new Email("danielfe@gmail.com", false),
//                new Email("daniel@outlook.com" , true),
//                new Email("danielf@hotmail.com", false),
//                new Email("dani@hotmail.com", true),
//                new Email("dfmg@hotmail.com", false),
//                new Email("prueba@live.co", true),
//                new Email("daniel@gmail.com",false),
//                new Email("1112222@hotmail.com", false ) ,
//                new Email("333154151outlookcom", true),
//                new Email("akjnsdkjas@gmail.com", false),
//                new Email("98451adsda@hotmail.com", true),
//                new Email("felipe@gmail.com", false),
//                new Email("felipemarin@hotmail.com", true),
//                new Email("feli@hotmail.com", true),
//                new Email("danie@garmendia.cl", true),
//                new Email("651651@hotmail.com", true),
//                new Email("adasd@gmail.com",false),
//                new Email("dsadasd@hotmail.com", false ) ,
//                new Email("ooooo@ outlook.com", true),
//                new Email("dsadsa@gmail.com", true),
//                new Email("lasdasda@hotmail.com", true),
//                new Email("llll@gmail.com", false),
//                new Email("opikoiko@hotmail.com", true),
//                new Email("kjasnsa@hotmail.com", true),
//                new Email("3265@garmendia.cl", true),
                new Email("4546541@outlook.com", false));

        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");


        /**
         * a. Distinct: para ver si hay correo repetidos, si hay correos repetidos eliminarlos
         */

        var emailsDiferents = emails.stream().map(element -> element.getEmail()).distinct().collect(Collectors.toList());


        /**
         * b. Filtro: para saber si hay correos con dominio gmail, hotmail y outlook.
         */

        var emailsWithGmail = emailsDiferents.stream().filter(element -> element.contains("gmail")).collect(Collectors.toList());
        var emailsWithHotmail = emailsDiferents.stream().filter(element -> element.contains("hotmail")).collect(Collectors.toList());
        var emailsWithOutlook = emailsDiferents.stream().filter(element -> element.contains("outlook")).collect(Collectors.toList());

        System.out.println("Correos Outlook: "+emailsWithOutlook);
        System.out.println("Correos Gmail: "+emailsWithGmail);
        System.out.println("Correos Hotmail: "+emailsWithHotmail);
        /**
         * c. Map: para saber si todos los correos cumple con todas las condiciones (Que cuente con el @ y el dominio)
         */

        var emailVerification = emails.stream().map(element -> {
            Matcher matcher = pattern.matcher(element.getEmail());


            if(!matcher.find()){
                System.out.println("El correo ingresado no es correcto.");
                return element ;
            }
            System.out.println("El correo "+ element.getEmail() + " Es correcto");
            return element ;

        }).collect(Collectors.toList());


        /**
         *  d. Saber la cantidad de correos que hay, sin usar un ciclo
         */


        System.out.println("\nEn la lista hay "+emailsDiferents.size()+" correos");

        /**
         *  e. Saber la cantidad de correos gmail, hotmail y outlook sin usar un ciclo
         *  En la misma lista determinar si se envió un correo o no a cada uno de los correos,
         *   si se le envió cambiar el estado en la lista
         *   esto respetando la inmutabilidad.
         */
        System.out.println("La cantidad de correos gmail es: " + emailsWithGmail.size());
        System.out.println("La cantidad de correos hotmail es: " + emailsWithHotmail.size());
        System.out.println("La cantidad de correos outlook es: " + emailsWithOutlook.size());

        List <Email> newList =  emails.stream()
                .filter(email -> {
                    if(email.isSent() == true) {
                        System.out.println("se envio");
                        email.setEstado(false);
                    }
                    return false;
                }).
                collect(Collectors.toList());

        System.out.println("===================");

        emails.stream()
                .map(c -> c.isSent())
                .forEach(System.out::println);
    }


}

