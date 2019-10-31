package GenericSwapMethodInteger_04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Box<Integer> box = new Box<>();

        while (n-->0){
            int number = Integer.parseInt(scanner.nextLine());
            box.getBoxes().add(number);
        }
        int first = scanner.nextInt();
        int second = scanner.nextInt();

        box.swapper(box.getBoxes(),first,second);
        System.out.println(box.toString());
    }
}
