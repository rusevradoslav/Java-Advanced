package RawData_04;

public class Tire {
    private double pressure;
    private int tireAge;

    public Tire(double pressure, int tireAge) {
        this.pressure = pressure;
        this.tireAge = tireAge;
    }

    public int getTireAge() {
        return tireAge;
    }

    public void setTireAge(int tireAge) {
        this.tireAge = tireAge;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }


    }
