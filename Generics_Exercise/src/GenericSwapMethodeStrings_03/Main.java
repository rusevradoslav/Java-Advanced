package GenericSwapMethodeStrings_03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box<String> box = new Box<>();
        while (n-- > 0) {
            String line = scanner.nextLine();
            box.getBoxes().add(line);
        }
        String[] tokens = scanner.nextLine().split("\\s+");
        int first = Integer.parseInt(tokens[0]);
        int second = Integer.parseInt(tokens[1]);

        box.swapper(box.getBoxes(),first,second);

        System.out.println(box.toString());
    }
}
