package colvir.bootcamp.homework02.converter.impl;

import org.springframework.stereotype.Component;

import colvir.bootcamp.homework02.converter.TemperatureConverter;
import colvir.bootcamp.homework02.model.Temperature;

import static colvir.bootcamp.homework02.model.enums.TemperatureType.*;

@Component("CELSIUS")
public class CelsiusConverterImpl implements TemperatureConverter {
    @Override
    public Temperature convert(Temperature needToConvert) {
        return switch (needToConvert.temperatureType()) {
            case CELSIUS-> needToConvert;
            case FAHRENHEIT -> new Temperature(CELSIUS, (needToConvert.value()-32)/1.8);
            case KELVIN -> new Temperature(CELSIUS, needToConvert.value() - 273.15);
        };
    }
}
