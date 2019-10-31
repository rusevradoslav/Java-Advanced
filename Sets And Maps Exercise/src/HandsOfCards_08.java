import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HandsOfCards_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, HashSet<String>> map = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("JOKER")) {
            String[] tokens = input.split(":\\s+");
            String name = tokens[0];
            HashSet<String> cards = Arrays.stream(tokens[1].split(",\\s+")).collect(Collectors.toCollection(HashSet::new));

            if (!map.containsKey(name)) {
                map.put(name, cards);
            } else {
                map.get(name).addAll(cards);
            }
            input = scanner.nextLine();
        }
        for (String player : map.keySet()) {
            int cardSum = cardCalculator(map.get(player));
            System.out.printf("%s: %d\n", player, cardSum);

        }

    }

    private static int cardCalculator(HashSet<String> deck) {
        int sum = 0;

        for (String card : deck) {
            int currentPower = 0;
            switch (card.charAt(0)) {
                case '2':
                    currentPower = 2;
                    break;
                case '3':
                    currentPower = 3;
                    break;
                case '4':
                    currentPower = 4;
                    break;
                case '5':
                    currentPower = 5;
                    break;
                case '6':
                    currentPower = 6;
                    break;
                case '7':
                    currentPower = 7;
                    break;
                case '8':
                    currentPower = 8;
                    break;
                case '9':
                    currentPower = 9;
                    break;
                case '1':
                    currentPower = 10;
                    break;
                case 'J':
                    currentPower = 11;
                    break;
                case 'Q':
                    currentPower = 12;
                    break;
                case 'K':
                    currentPower = 13;
                    break;
                case 'A':
                    currentPower = 14;
                    break;
            }
            switch (card.charAt(1)) {
                case 'S':
                    currentPower *= 4;
                    break;
                case 'H':
                    currentPower *= 3;
                    break;
                case 'D':
                    currentPower *= 2;
                    break;
            }
            sum += currentPower;
        }
        return sum;
    }

}
