package colvir.bootcamp.homework02.converter.impl;

import org.springframework.stereotype.Component;

import colvir.bootcamp.homework02.converter.TemperatureConverter;
import colvir.bootcamp.homework02.model.Temperature;

import static colvir.bootcamp.homework02.model.enums.TemperatureType.*;

@Component("FAHRENHEIT")
public class FahrenheitConverterImpl implements TemperatureConverter {
    @Override
    public Temperature convert(Temperature needToConvert) {
        return switch (needToConvert.temperatureType()) {
            case FAHRENHEIT-> needToConvert;
            case CELSIUS -> new Temperature(FAHRENHEIT, needToConvert.value()*1.8+32);
            case KELVIN -> new Temperature(FAHRENHEIT, needToConvert.value()*1.8 - 459.67);
        };
    }
}
