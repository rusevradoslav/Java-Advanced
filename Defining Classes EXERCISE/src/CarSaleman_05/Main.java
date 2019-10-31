package CarSaleman_05;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Engine> engines = new LinkedList<>();
        List<Car> cars = new LinkedList<>();
        while (n-- > 0) {

            String[] tokens = scanner.nextLine().split("\\s+");
            String modelEngine = tokens[0];
            int power = Integer.parseInt(tokens[1]);

            Engine engine1 = null;

            if (tokens.length == 4) {
                engine1 = new Engine(modelEngine, power);

                if (Character.isDigit(tokens[2].charAt(0))) {
                    String displacement = tokens[2];
                    String efficiency = tokens[3];
                    engine1.setDisplacement(displacement);
                    engine1.setEficiency(efficiency);
                }
            } else if (tokens.length == 3) {
                engine1 = new Engine(modelEngine, power);

                if (Character.isDigit(tokens[2].charAt(0))) {
                    String displacement = tokens[2];
                    engine1.setDisplacement(displacement);
                } else {
                    String efficiency = tokens[2];
                    engine1.setEficiency(efficiency);

                }

            }else {
                engine1 = new Engine(modelEngine, power);
            }
            engines.add(engine1);
        }

        int m = Integer.parseInt(scanner.nextLine());

        while (m-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String carModel = input[0];
            String modelEngine2 = input[1];

            Engine engine = null;
            Car car = null;
            for (Engine engine1 : engines) {
                if (engine1.getModelEngine().equals(modelEngine2)) {
                    engine = engine1;
                    break;
                }
            }

            if (input.length == 4) {
                car = new Car(carModel, engine);
                if (Character.isDigit(input[2].charAt(0))) {
                    String weight = input[2];
                    String color = input[3];
                    car.setWeight(weight);
                    car.setColor(color);
                }
            } else if (input.length == 3) {
                 car = new Car(carModel, engine);
                if (Character.isDigit(input[2].charAt(0))) {
                    String weight = input[2];
                    car.setWeight(weight);
                } else {
                    String color = input[2];
                    car.setColor(color);
                }
            }
            else {
                car=new Car(carModel,engine);
            }
            cars.add(car);

        }
        for (Car car : cars) {
            System.out.println(car.toString());
        }

    }


}

