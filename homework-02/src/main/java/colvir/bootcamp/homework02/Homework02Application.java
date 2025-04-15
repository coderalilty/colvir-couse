package colvir.bootcamp.homework02;

import colvir.bootcamp.homework02.converter.TemperatureConverter;
import colvir.bootcamp.homework02.converter.impl.CelsiusConverterImpl;
import colvir.bootcamp.homework02.converter.impl.FahrenheitConverterImpl;
import colvir.bootcamp.homework02.converter.impl.KelvinConverterImpl;
import colvir.bootcamp.homework02.model.Temperature;
import colvir.bootcamp.homework02.model.enums.TemperatureType;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Homework02Application {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.register(CelsiusConverterImpl.class, FahrenheitConverterImpl.class, KelvinConverterImpl.class);
            context.refresh();

            TemperatureConverter celsiusConverter = context.getBean("CELSIUS", TemperatureConverter.class);
            TemperatureConverter fahrenheitConverter = context.getBean("FAHRENHEIT", TemperatureConverter.class);
            TemperatureConverter kelvinConverter = context.getBean("KELVIN", TemperatureConverter.class);

            Temperature kelvinTemperature = new Temperature(TemperatureType.KELVIN, 100);
            System.out.printf("Kelvin 100 to celsius = %.2f%n", celsiusConverter.convert(kelvinTemperature).value());
            System.out.printf("Kelvin 100 to Fahrenheit = %.2f%n", fahrenheitConverter.convert(kelvinTemperature).value());
            System.out.printf("Kelvin 100 to Kelvin = %.2f%n" , kelvinConverter.convert(kelvinTemperature).value());
        }
    }
}

