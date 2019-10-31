package CarSaleman_05;

import java.util.*;

public class Car {
    private String carModel;
    private Engine engines;
    private String weight;
    private String color;

    public Car(String carModel, Engine engines) {
        this.carModel = carModel;
        this.engines = engines;
        this.weight = "n/a";
        this.color = "n/a";
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Engine getEngines() {
        return engines;
    }

    public void setEngines(Engine engines) {
        this.engines = engines;
    }

    public String getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public String toString() {
        Engine eng = this.getEngines();
        return String.format("%s:%n%s:%nPower: %s%nDisplacement: %s%nEfficiency: %s%nWeight: %s%nColor: %s",
                this.getCarModel(), eng.getModelEngine(), eng.getPower(), eng.getDisplacement(), eng.getEficiency(), this.getWeight(), this.getColor());
    }


}
