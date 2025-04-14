package colvir.bootcamp.homework02;

import colvir.bootcamp.homework02.converter.TemperatureConverter;
import colvir.bootcamp.homework02.converter.impl.CelsiusConverterImpl;
import colvir.bootcamp.homework02.model.Temperature;
import colvir.bootcamp.homework02.model.enums.TemperatureType;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class CelsiusConverterTest {

    private static double BODY_TEMPERATURE_IN_FAHRENHEIT = 98.2;
    private static double BODY_TEMPERATURE_IN_KELVIN = 310;
    private static double BODY_TEMPERATURE_IN_CELSIUM = 36.8;

    @Test
    public void convertFromFahrenheit() {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.register(CelsiusConverterImpl.class);
            context.refresh();
            Temperature bodyTemperature = new Temperature(TemperatureType.FAHRENHEIT, BODY_TEMPERATURE_IN_FAHRENHEIT);
            TemperatureConverter celsiusConverter = (TemperatureConverter) context.getBean("CELSIUS");
            assertEquals(BODY_TEMPERATURE_IN_CELSIUM, celsiusConverter.convert(bodyTemperature).getValue(), 0.1);
        }
    }
    @Test
    public void convertFromKelvin() {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.register(CelsiusConverterImpl.class);
            context.refresh();
            Temperature bodyTemperature = new Temperature(TemperatureType.KELVIN, BODY_TEMPERATURE_IN_KELVIN);
            TemperatureConverter celsiusConverter = (TemperatureConverter) context.getBean("CELSIUS");
            assertEquals(BODY_TEMPERATURE_IN_CELSIUM, celsiusConverter.convert(bodyTemperature).getValue(), 0.1);
        }
    }

}
