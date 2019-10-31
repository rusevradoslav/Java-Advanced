package softUniParkingEXAM;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Parking {
    private Map<String, Car> cars;
    private int capacity;

    public Parking(int capacity) {
        this.cars = new HashMap<>();
        this.capacity = capacity;
    }


    public String addCar(Car car) {
        if (this.cars.containsKey(car.getRegistrationNumber())) {
            return "Car with that registration number, already exists!";

        } else if (this.cars.size() == this.capacity) {
            return "Parking is full!";

        }
        this.cars.putIfAbsent(car.getRegistrationNumber(), car);
        return String.format("Successfully added new car %s %s", car.getMake(), car.getRegistrationNumber());
    }

    public String removeCar(String registrationNUmber) {

        if (!this.cars.containsKey(registrationNUmber)) {
            return "Car with that registration number, doesn't exists!";
        }
        this.cars.remove(registrationNUmber);
        return String.format("Successfully removed %s", registrationNUmber);
    }

    public Car getCar(String registrationNUmber) {
        return this.cars.get(registrationNUmber);
    }

    public int getCount() {
        return this.cars.size();

    }

    public void removeSetOfRegistrationNumber(List<String> regNums) {
        for (String regNum : regNums) {
            this.removeCar(regNum);

        }
    }
}

