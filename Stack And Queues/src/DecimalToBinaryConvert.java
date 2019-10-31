import java.util.ArrayDeque;
        import java.util.Collection;
        import java.util.Collections;
        import java.util.Scanner;

public class DecimalToBinaryConvert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> bits = new ArrayDeque<>();
        if (number == 0) {
            System.out.println(0);

        }
        while (number > 0) {
            int decimal = number % 2;
            bits.push(decimal);
            number = number / 2;
        }

        int size = bits.size();
        for (int i = 0; i < size; i++) {
            System.out.print(bits.pop());
        }
    }

}
