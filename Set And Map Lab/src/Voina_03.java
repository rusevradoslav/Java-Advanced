import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Voina_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstNumbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondNumbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        LinkedHashSet<Integer> firstPlayer = new LinkedHashSet<>(firstNumbers);
        LinkedHashSet<Integer> secondPlayer = new LinkedHashSet<>(secondNumbers);

        if (firstPlayer.isEmpty() || secondPlayer.isEmpty()) {
            return;
        }
        for (int i = 0; i < 50; i++) {
            int firstNumber = firstPlayer.iterator().next();
            firstPlayer.remove(firstNumber);
            int secondNumber = secondPlayer.iterator().next();
            secondPlayer.remove(secondNumber);

            if (firstNumber > secondNumber) {
                firstPlayer.add(firstNumber);
                firstPlayer.add(secondNumber);
            } else if (firstNumber == secondNumber) {
                firstPlayer.add(firstNumber);
                secondPlayer.add(secondNumber);
            } else {
                secondPlayer.add(firstNumber);
                secondPlayer.add(secondNumber);
            }

        }

        if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else if (secondPlayer.size() > firstPlayer.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw");
        }
    }
}

