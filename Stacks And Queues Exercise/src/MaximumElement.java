import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cmd = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        while (cmd-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "1":
                    stack.push(Integer.parseInt(tokens[1]));
                    break;
                case "2":
                    stack.pop();
                    break;
                case "3":
                    int max = Collections.max(stack);
                    System.out.println(max);
                    break;

            }
        }
    }
}
