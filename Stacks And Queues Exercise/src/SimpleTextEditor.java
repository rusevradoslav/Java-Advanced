import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        StringBuilder text = new StringBuilder();
        ArrayDeque<StringBuilder> stack = new ArrayDeque<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split(" ");
            int type = Integer.parseInt(tokens[0]);

            switch (type) {
                case 1:
                    text.append(tokens[1]);
                    stack.push(new StringBuilder(tokens[1]));
                    break;
                case 2:
                    int symbolsToDelete = Integer.parseInt(tokens[1]);
                    int start = symbolsToDelete - text.length();
                    text.delete(start, start + symbolsToDelete);
                    stack.push(new StringBuilder(text));
                    break;
                case 3:
                    int index = Integer.parseInt(tokens[1]);
                    System.out.println(text.charAt(index - 1));
                    break;
                case 4:
                    if (stack.size() > 1) {
                        stack.pop();
                        text = stack.peek();
                    } else {
                        text = new StringBuilder();
                    }
                    break;

            }
        }

    }
}
