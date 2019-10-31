import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] childere = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue, childere);

        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {

                String child = queue.remove();
                queue.offer(child);
            }
            String name = queue.remove();
            System.out.println("Removed " + name);
        }
        String name = queue.peek();
        System.out.println("Last is " + name);
    }
}
