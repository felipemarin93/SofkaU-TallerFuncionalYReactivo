package co.com.sofka;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ExerciseIntegralAndDerivatesTest {

    @InjectMocks
    ExerciseIntegralAndDerivates integralAndDerivates;

    @Test
    void testIntegrate(){
        var value = integralAndDerivates.integrate(20.0,3.0);
        Assertions.assertEquals("la integral de: ∫20.0x^3.0dx es de: 5.0x^4.0+ C", value);
    }

    @Test
    void testDerivate(){
        var value = integralAndDerivates.derivate(20.0,3.0);
        Assertions.assertEquals("la derivada de: 20.0X^3.0 es de: 60.0X^2.0", value);
    }

}