import java.io.BufferedReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }
        while (stack.size() > 0) {
            System.out.print(stack.pop() + " ");
        }
    }
}
