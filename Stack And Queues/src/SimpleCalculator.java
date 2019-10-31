import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        ArrayDeque<Integer> digits = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            if (Character.isDigit(input[i].charAt(0))) {
                digits.push(Integer.parseInt(input[i]));
            } else if (input[i].charAt(0) == '+') {
                int left = digits.pop();
                int right = Integer.parseInt(input[i + 1]);

                int result = left + right;
                digits.push(result);
                i++;
            } else if (input[i].charAt(0) == '-') {
                int left = digits.pop();
                int right = Integer.parseInt(input[i + 1]);

                int result = left - right;
                digits.push(result);
                i++;
            }
        }

        System.out.println(digits.peek());

    }
}
