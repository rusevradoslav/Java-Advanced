package CarDEMO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {

            String[] carParts = scanner.nextLine().split(" ");
            Car current;
            if (carParts.length == 1) {
                current = new Car(carParts[0]);
              //  current.setMake(carParts[0]);
            } else {
                int horsePower= Integer.parseInt(carParts[2]);
                current = new Car(carParts[0],carParts[1],horsePower);
               // current.setMake(carParts[0]);
               // current.setModel(carParts[1]);
               // current.setHorsePower(Integer.parseInt(carParts[2]));
            }

            System.out.println(current.getInfo());
        }

    }
}
