package RawData_04;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Car>> cargoTypes = new LinkedHashMap<>();
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String model = tokens[0];

            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);

            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];

            double tire1Pressure1 = Double.parseDouble(tokens[5]);
            int tireAge1 = Integer.parseInt(tokens[6]);
            double tire1Pressure2 = Double.parseDouble(tokens[7]);
            int tireAge2 = Integer.parseInt(tokens[8]);
            double tire1Pressure3 = Double.parseDouble(tokens[9]);
            int tireAge3 = Integer.parseInt(tokens[10]);
            double tire1Pressure4 = Double.parseDouble(tokens[11]);
            int tireAge4 = Integer.parseInt(tokens[12]);

            Tire[] tires = new Tire[4];
            tires[0] = new Tire(tire1Pressure1, tireAge1);
            tires[1] = new Tire(tire1Pressure2, tireAge2);
            tires[2] = new Tire(tire1Pressure3, tireAge3);
            tires[3] = new Tire(tire1Pressure4, tireAge4);

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            Car car = new Car(model, engine, cargo, tires);

            if (!cargoTypes.containsKey(cargoType)) {
                cargoTypes.put(cargoType, new ArrayList<>());
                cargoTypes.get(cargoType).add(car);
            } else {
                cargoTypes.get(cargoType).add(car);
            }


        }
        String type = scanner.nextLine();

        if (type.equals("fragile")) {
            cargoTypes.get(type).stream().filter(car -> car.getTires()).forEach(car -> System.out.println(String.format("%s", car.getModel())));
        } else {
            cargoTypes.get(type).stream().filter(car -> car.getEngine().getPower() > 250).forEach(car -> System.out.println(car.getModel()));
        }

    }

}
