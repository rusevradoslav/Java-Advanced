import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchAndBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expressions = scanner.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();


        for (int i = 0; i < expressions.length(); i++) {

            if (expressions.charAt(i) == '(') {
                stack.push(i);

            } else if (expressions.charAt(i) == ')') {
                int opening = stack.pop();
                String current = expressions.substring(opening, i + 1);
                System.out.println(current);
            }

        }


    }
}
