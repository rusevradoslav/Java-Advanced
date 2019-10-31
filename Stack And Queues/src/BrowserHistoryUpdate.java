import java.util.ArrayDeque;
        import java.util.Scanner;

public class BrowserHistoryUpdate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();
        String input = scanner.nextLine();

        while (!input.equals("Home")) {

            if (input.equals("back")) {
                if (browserHistory.size() < 2) {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                } else {
                    String current = browserHistory.pop();
                    forward.offerFirst(current);
                    System.out.println(browserHistory.peek());
                }

            } else if (input.equals("forward")) {
                if (forward.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    String url = forward.pop();
                    browserHistory.push(url);
                    System.out.println(url);
                }

            } else {
                browserHistory.push(input);
                forward.clear();
                System.out.println(input);

            }
            input = scanner.nextLine();
        }

    }
}
