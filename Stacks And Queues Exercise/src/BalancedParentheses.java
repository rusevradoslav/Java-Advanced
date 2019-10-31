import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String parentheses = scanner.nextLine();

        ArrayDeque<Character> openingBrackets = new ArrayDeque<>();
        boolean isBalance = true;

        for (int i = 0; i < parentheses.length(); i++) {
            char current = parentheses.charAt(i);


            if (current == '{' || current == '[' || current == '(') {
                openingBrackets.push(current);
            } else {
                if (openingBrackets.isEmpty()) {
                    isBalance = false;
                    break;
                }
                char opening = openingBrackets.pop();
                if (current == '}' && opening != '{') {
                    isBalance = false;
                    break;
                } else if (current == ']' && opening != '[') {
                    isBalance = false;
                    break;
                } else if (current == ')' && opening != '(') {
                    isBalance = false;
                    break;
                }

            }
        }
        if (isBalance) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
