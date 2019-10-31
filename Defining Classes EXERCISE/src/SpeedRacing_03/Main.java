package SpeedRacing_03;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Car> garage = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split(" ");
            String model = tokens[0];
            double fuel = Double.parseDouble(tokens[1]);
            double consumption = Double.parseDouble(tokens[2]);
            Car car = new Car(model, fuel, consumption);
            garage.putIfAbsent(model, car);
        }
        String line = scanner.nextLine();
        while (!line.equals("End")) {
            String[] data = line.split("\\s+");

            String model = data[1];
            int distance = Integer.parseInt(data[2]);

            if (!garage.get(model).drive(distance)) {
                System.out.println("Insufficient fuel for the drive");
            }

            line = scanner.nextLine();
        }
        garage.entrySet().stream().forEach(entry -> {
            System.out.println(String.format("%s %.2f %d", entry.getKey(), entry.getValue().getFuel(), entry.getValue().getDistanceTraveled()));
        });

    }
}
