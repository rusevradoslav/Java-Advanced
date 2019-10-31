package softUniParkingEXAM;

public class Car {
    private String make;
    private String model;
    private int horsePower;
    private String registrationNumber;

    public Car(String make, String model, int horsePower, String registrationNumber) {
        this.make = make;
        this.model = model;
        this.horsePower = horsePower;
        this.registrationNumber = registrationNumber;
    }

    public String getMake() {
        return   this.make;
    }

    public String getModel() {
        return   this.model;
    }

    public int getHorsePower() {
        return   this.horsePower;
    }

    public String getRegistrationNumber() {
        return   this.registrationNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Make: %s\n",this.make));
        sb.append(String.format("Model: %s\n",this.model));
        sb.append(String.format("HorsePower: %d\n",this.horsePower));
        sb.append(String.format("RegistrationNumber: %s",this.registrationNumber));
        return sb.toString().trim();
    }
}
