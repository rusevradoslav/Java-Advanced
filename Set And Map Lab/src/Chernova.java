import java.util.*;
import java.util.stream.Collectors;

public class Chernova {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPlayerInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());


        List<Integer> secondPlayerInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        LinkedHashSet<Integer> firstPlayer = new LinkedHashSet<>(firstPlayerInput);
        LinkedHashSet<Integer> secondPlayer = new LinkedHashSet<>(secondPlayerInput);

        for (int i = 0; i < 50; i++) {

            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()) {
                return;
            }

            int firstPlayerCard = firstCardDeck(firstPlayer);
            int secondPlayerCard = firstCardDeck(secondPlayer);

            firstPlayer.remove(firstPlayerCard);
            secondPlayer.remove(secondPlayerCard);

            if (firstPlayerCard > secondPlayerCard) {
                firstPlayer.add(firstPlayerCard);
                firstPlayer.add(secondPlayerCard);
            } else if (secondPlayerCard > firstPlayerCard) {
                secondPlayer.add(firstPlayerCard);
                secondPlayer.add(secondPlayerCard);
            } else {
                firstPlayer.add(firstPlayerCard);
                secondPlayer.add(secondPlayerCard);
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

    private static Integer firstCardDeck(LinkedHashSet<Integer> deck) {
        Iterator<Integer> iterator = deck.iterator();
        return iterator.next();

    }
}


