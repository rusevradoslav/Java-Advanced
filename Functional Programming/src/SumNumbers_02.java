import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Function<String, Integer> parse = str -> Integer.parseInt(str);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());

        System.out.printf("Count = %s\n", numbers.size());
        int sum = numbers.stream().mapToInt(n -> n).sum();
        // int sum = numbers.stream().reduce((a, b) -> a + b).get();
        System.out.printf("Sum = %d", sum);
    }
}
