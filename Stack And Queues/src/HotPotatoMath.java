import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class HotPotatoMath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] childere = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue, childere);
        int cycles = 1;

        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {

                String child = queue.remove();
                queue.offer(child);
            }


            String name = queue.peek();
            if (!isPrime(cycles)) {
                System.out.println("Removed " + name);
                queue.remove();
            } else {
                System.out.println("Prime " + name);
            }
            cycles++;
        }
        String name = queue.peek();
        System.out.println("Last is " + name);
    }

    private static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;

    }
}
