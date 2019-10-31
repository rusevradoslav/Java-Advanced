package RawData_04;

import java.util.ArrayList;
import java.util.List;

public class Engine {
    private int speed;
    private int power;
    private List<Car> cars;

    public Engine() {
        this.cars = new ArrayList<>();
    }

    public Engine(int speed, int power) {
        this.speed = speed;
        this.power = power;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public boolean validEngine() {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getEngine().getPower() >= 250) {
                return true;
            }
        }
        return false;
    }
}
