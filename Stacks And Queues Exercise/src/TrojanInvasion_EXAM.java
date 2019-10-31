import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TrojanInvasion_EXAM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int waves = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> defenders = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        //taka se pulni Ques


        ArrayDeque<Integer> attackers = new ArrayDeque<>();
        for (int i = 1; i <= waves; i++) {
            Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(atacker -> attackers.push(atacker)); //taka se pulni stack
            //.map(Integer::parseInt).forEach(attackers::push);//
            if (i % 3 == 0) {
                int bonusDefenders = Integer.parseInt(scanner.nextLine());
                defenders.offer(bonusDefenders);
            }

            while (!defenders.isEmpty() && !attackers.isEmpty()) {

                int attacker = attackers.pop();
                int defender = defenders.poll();
                if (attacker > defender) {
                    attacker -= defender;
                    attackers.push(attacker);
                } else if (defender > attacker) {
                    defender -= attacker;
                    defenders.addFirst(defender);
                }

            }
            if (!attackers.isEmpty()) {
                break;
            }


        }

        if (defenders.isEmpty()) {
            System.out.println("The Trojans successfully destroyed the Spartan defense.");
            System.out.print("Warriors left: ");
            int count = 0;
            for (Integer attacker : attackers) {
                System.out.print(attacker);
                if (count != attackers.size() - 1) {
                    System.out.print(", ");
                    count++;
                }
            }

        } else {
            System.out.println("The Spartans successfully repulsed the Trojan attack.");
            System.out.print("Plates left: ");
            int count = 0;
            for (Integer defender : defenders) {
                System.out.print(defender);
                if (count != defenders.size() - 1) {
                    System.out.print(", ");
                    count++;
                }
            }
        }
    }
}
