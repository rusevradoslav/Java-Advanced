package SpeedRacing_03;

public class Car {
    private String model;
    private double fuel;
    private double consumption;
    private int distanceTraveled;

    public Car(String model, double fuel, double consumption) {
        this.model = model;
        this.fuel = fuel;
        this.consumption = consumption;
        this.distanceTraveled = 0;
    }


    public boolean drive(int distance) {
        double fuelNeeded = this.consumption * distance;
        if (fuelNeeded <= this.fuel) {
            this.fuel -= fuelNeeded;
            this.distanceTraveled += distance;
            return true;
        }



        return false;

    }

    public int getDistanceTraveled() {
        return this.distanceTraveled;
    }

    public double getFuel() {
        return this.fuel;
    }
}
