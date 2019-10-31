import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> history = new ArrayDeque<>();

        while (!input.equals("Home")) {
            boolean error = false;
            if (input.equals("back")) {
                if (history.size() < 2) {
                    System.out.println("no previous URLs");
                    error = true;
                } else {
                    history.pop();
                }
            } else {
                history.push(input);
            }
            if (!error) {
                System.out.println(history.peek());
            }

            input = scanner.nextLine();
        }


    }

}
