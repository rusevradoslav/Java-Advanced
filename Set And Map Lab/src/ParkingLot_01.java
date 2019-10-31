import java.util.*;

public class ParkingLot_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashSet<String> parking = new HashSet<String>();

        String line = scanner.nextLine();

        while (!line.equals("END")) {
            String[] tokens = line.split(", ");

            String command = tokens[0];
            String carNumber = tokens[1];

            switch (command) {
                case "IN":
                    parking.add(carNumber);
                    break;
                case "OUT":
                    parking.remove(carNumber);
                    break;

            }
            line = scanner.nextLine();
        }
        if (parking.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : parking) {
                System.out.println(car);
            }
        }

    }
}
