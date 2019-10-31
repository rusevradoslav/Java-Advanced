import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] stringNumbers = scanner.nextLine().split(", ");

        List<Integer> evenNumbers = Arrays.stream(stringNumbers)
                .map(Integer::parseInt)
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());

        List<String> numbers = evenNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        System.out.printf(String.join(", ", numbers));
        System.out.println();

        evenNumbers.sort(Integer::compare);

        List<String> sort = evenNumbers.stream().map(String::valueOf).collect(Collectors.toList());

        System.out.printf(String.join(", ", sort));

    }
}
