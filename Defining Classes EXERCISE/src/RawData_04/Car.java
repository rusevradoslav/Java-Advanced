package RawData_04;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire[] tires;


    public Car(String model, Engine engine, Cargo cargo, Tire[] tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public boolean getTires() {
        for (int i = 0; i < tires.length; i++) {
            if (tires[i].getPressure() <= 1) {
                return true;
            }
        }
        return false;
    }


    public void setTires(Tire[] tires) {
        this.tires = tires;
    }


}
