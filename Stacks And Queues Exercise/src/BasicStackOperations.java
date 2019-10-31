import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        int pushElements = Integer.parseInt(tokens[0]);
        int popElelments = Integer.parseInt(tokens[1]);
        int toCheck = Integer.parseInt(tokens[2]);
        int minimum = Integer.MAX_VALUE;

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).limit(pushElements).forEach(stack::push);

        while (popElelments-- > 0) {
            stack.pop();
        }

        if (stack.contains(toCheck)) {
            System.out.println("true");
        } else if (stack.isEmpty()) {
            System.out.println(0);
        } else {
            int number = stack.pop();

            if (number < minimum) {
                minimum = number;
            }
            System.out.println(minimum);
        }

    }
}
