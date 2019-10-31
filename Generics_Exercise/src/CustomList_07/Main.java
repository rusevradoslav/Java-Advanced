package CustomList_07;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Box<String> box = new Box<>();

        while (!line.equals("END")) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Add":
                    box.add(tokens[1]);
                    break;
                case "Remove":
                    box.remove(Integer.parseInt(tokens[1]));
                    break;
                case "Contains":
                    System.out.println(box.contains(tokens[1]));
                    break;
                case "Swap":
                    int first = Integer.parseInt(tokens[1]);
                    int second = Integer.parseInt(tokens[2]);
                    box.swapper(first, second);
                    break;
                case "Greater":
                    System.out.println(box.greaterCount(tokens[1]));
                    break;
                case "Max":
                    System.out.println(box.getMax());
                    break;
                case "Min":
                    System.out.println(box.getMin());
                    break;
                case "Print":
                    System.out.println(box.toString());
                    break;
            }


            line = scanner.nextLine();
        }

    }
}
