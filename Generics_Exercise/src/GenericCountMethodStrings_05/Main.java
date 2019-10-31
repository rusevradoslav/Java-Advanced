package GenericCountMethodStrings_05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box<String> box = new Box<>();

        while (n-- > 0) {
            String line = scanner.nextLine();
            box.getCollection().add(line);
        }
        String element = scanner.nextLine();


        System.out.println(box.getCount(box.getCollection(), element));

    }
}
