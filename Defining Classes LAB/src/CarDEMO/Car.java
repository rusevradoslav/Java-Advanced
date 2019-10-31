package CarDEMO;

public class Car {

    public String make;
    public String model;
    public int horsePower;

    public static final String undefinedValue = "unknown";

    public Car(String make, String model, int horsePower) {
        this(make);
        this.model = model;
        this.horsePower = horsePower;
    }

    public Car(String make) {
        this();
        this.make = make;
    }

    public Car() {
        this.make = undefinedValue;
        this.model = undefinedValue;
        this.horsePower = -1;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String getInfo() {
        return String.format("The car is: %s %s - %d HP.", this.getMake(), this.getModel(), this.getHorsePower());
    }
}
