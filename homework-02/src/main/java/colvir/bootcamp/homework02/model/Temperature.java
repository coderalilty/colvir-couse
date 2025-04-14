package colvir.bootcamp.homework02.model;

import colvir.bootcamp.homework02.model.enums.TemperatureType;

public class Temperature {
    private TemperatureType temperatureType;
    private double value;

    public Temperature(TemperatureType temperatureType, double value) {
        this.temperatureType = temperatureType;
        this.value = value;
    }

    public TemperatureType getTemperatureType() {
        return temperatureType;
    }
    public void setTemperatureType(TemperatureType temperatureType) {
        this.temperatureType = temperatureType;
    }
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }
}
