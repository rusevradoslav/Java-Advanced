import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class TrojanInvasion_chernova {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int waves = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> defenders = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(integer -> defenders.offer(integer));

        ArrayDeque<Integer> attackers = new ArrayDeque<>();


        for (int i = 1; i <= waves; i++) {
            Arrays.stream(scanner.nextLine()
                    .split("\\s+"))
                    .map(Integer::parseInt)
                    .forEach(integer -> attackers.push(integer));

            while (!attackers.isEmpty() && !defenders.isEmpty()) {
                int attacker = attackers.poll();
                int defender = defenders.pop();

                if (defender > attacker) {
                    defender -= attacker;
                    defenders.addFirst(defender);
                } else if (defender < attacker) {
                    attacker -= defender;
                    attackers.push(attacker);
                } else {

                }
            }
            if (i % 3 == 0) {
                Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                        .map(Integer::parseInt)
                        .forEach(integer -> defenders.offer(integer));
            }
            if (defenders.isEmpty()) {
                break;
            }

        }
        if (!defenders.isEmpty()) {
            System.out.println("The Spartans successfully repulsed the Trojan attack.");
            int count = 0;
            System.out.print("Plates left: ");
            for (Integer defender : defenders) {
                System.out.print(defender);
                if (count != defenders.size() - 1) {
                    System.out.print(", ");
                    count++;
                }
            }
        } else {
            System.out.println("The Trojans successfully destroyed the Spartan defense.");
            int count = 0;
            System.out.print("Warriors left: ");
            for (Integer attacker : attackers) {
                System.out.print(attacker);
                if (count != attackers.size() - 1) {
                    System.out.print(", ");
                    count++;
                }
            }
        }
    }
}


