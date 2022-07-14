package co.com.sofka;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ExerciseIntegralAndDerivates {

    public static void main(String[] args) {

    }
    public String derivate(Double coefficient, Double exponent) {
        BiFunction<Double, Double, Double> coeficienteResult = (coef, expo) -> coef * expo;
        Function<Double, Double> exponenteResult = (exponente) -> exponente - 1;

        return "la derivada de: " + coefficient +"X^" + exponent +" es de: " + coeficienteResult.apply(coefficient, exponent) +"X^" + exponenteResult.apply(exponent);
    }
    //
    public String integrate(Double coefficient, Double exponent) {
        BiFunction<Double, Double, Double> coefficientResult = (coef, expo) -> {
            if (coef / (expo + 1) == 1) {
                return 1.0;
            } else {
                return coef / (expo + 1);
            }
        } ;
        Function<Double, Double> exponentResult = (expo) -> expo + 1;

        return "la integral de: ∫" + coefficient +"x^" + exponent +"dx es de: " + coefficientResult.apply(coefficient, exponent) +"x^" + exponentResult.apply(exponent) +"+ C";
    }


}
