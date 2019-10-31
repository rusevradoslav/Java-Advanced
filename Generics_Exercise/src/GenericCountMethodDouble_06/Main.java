package GenericCountMethodDouble_06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box<Double> box = new Box<>();

        while (n-- > 0) {
            double number = Double.parseDouble(scanner.nextLine());
            box.getCollection().add(number);
        }


        double element = Double.parseDouble(scanner.nextLine());


        System.out.println(box.getCount(box.getCollection(), element));

    }
}
