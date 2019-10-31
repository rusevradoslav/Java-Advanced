import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUpperCaseWords_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Predicate<String> upperCase = word -> Character.isUpperCase(word.charAt(0));

        List<String> words = Arrays.stream(scanner.nextLine().split(" ")).filter(upperCase).collect(Collectors.toList());
        System.out.printf("%d\n", words.size());
        words.forEach(n -> System.out.printf("%s\n", n));
    }
}
