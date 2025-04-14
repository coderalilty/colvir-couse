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

            TemperatureConverter celsiusConverter = (TemperatureConverter) context.getBean("CELSIUS");
            TemperatureConverter fahrenheitConverter = (TemperatureConverter) context.getBean("FAHRENHEIT");
            TemperatureConverter kelvinConverter = (TemperatureConverter) context.getBean("KELVIN");

            Temperature kelvinTemperature = new Temperature(TemperatureType.KELVIN, 100);
            System.out.println("Kelvin 100 to celsius =" + celsiusConverter.convert(kelvinTemperature).getValue());
            System.out.println("Kelvin 100 to Fahrenheit =" + fahrenheitConverter.convert(kelvinTemperature).getValue());
            System.out.println("Kelvin 100 to Kelvin =" + kelvinConverter.convert(kelvinTemperature).getValue());
        }
    }
}

