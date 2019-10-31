import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Integer> male = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(f -> male.push(f));
        ArrayDeque<Integer> female = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(m -> female.offer(m));


        int matches = 0;
        while (!female.isEmpty() && !male.isEmpty()) {
            int maleeAge = male.pop();
            int femaleAge = female.poll();

            if (femaleAge <= 0) {
                female.poll();
                male.push(maleeAge);
                continue;
            }

            if (maleeAge <= 0) {
                male.pop();
                female.offerFirst(femaleAge);
                continue;

            }
            if (maleeAge % 25 == 0) {
                if (male.isEmpty()) {
                    male.pop();
                    break;
                } else {
                    female.offerFirst(femaleAge);
                    continue;

                }

            }
            if (femaleAge % 25 == 0) {
                if (female.isEmpty()) {
                    female.poll();
                    male.push(maleeAge);
                    break;
                } else {

                    continue;
                }
            }
            if (femaleAge != maleeAge) {
                male.addFirst(maleeAge - 2);
            } else {

                matches++;
            }


        }
        System.out.println(String.format("Matches: %d", matches));
        if (male.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            int count = 0;
            System.out.print("Males left: ");
            for (Integer m : male) {
                System.out.print(m);
                if (count != male.size() - 1) {
                    System.out.print(", ");
                    count++;
                }

            }
            System.out.println();
        }
        if (female.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            int count = 0;
            System.out.print("Females left: ");
            for (Integer f : female) {
                System.out.print(f);
                if (count != female.size() - 1) {
                    System.out.print(", ");
                    count++;
                }

            }
            System.out.println();
        }

    }

}
