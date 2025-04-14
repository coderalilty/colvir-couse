package colvir.bootcamp.homework02.converter.impl;

import org.springframework.stereotype.Component;

import colvir.bootcamp.homework02.converter.TemperatureConverter;
import colvir.bootcamp.homework02.model.Temperature;

import static colvir.bootcamp.homework02.model.enums.TemperatureType.*;

@Component("KELVIN")
public class KelvinConverterImpl implements TemperatureConverter {
    @Override
    public Temperature convert(Temperature needToConvert) {
        return switch (needToConvert.getTemperatureType()) {
            case KELVIN-> needToConvert;
            case CELSIUS -> new Temperature(KELVIN, needToConvert.getValue()+473.15);
            case FAHRENHEIT -> new Temperature(KELVIN, (needToConvert.getValue() - 459.67)/1.8);
        };
    }
}