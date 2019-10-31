import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class DatingApp1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> male = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(f -> male.push(f));
        ArrayDeque<Integer> female = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(m -> female.offer(m));

        int matches = 0;
        while (!male.isEmpty() && !female.isEmpty()) {
            int maleAge = male.peek();
            int femaleAge = female.peek();

            if (maleAge <= 0) {
                male.pop();
            }
            if (femaleAge <= 0) {
                female.pop();
            }

            if (maleAge % 25 == 0) {
                male.pop();
                if (!male.isEmpty()) {
                    male.pop();
                }

            }
            if (femaleAge % 25 == 0) {
                female.pop();
                if (!female.isEmpty()) {

                    female.pop();
                }

            }

            if (maleAge == femaleAge) {
                male.pop();
                female.pop();
                matches++;
            } else {
                if (!female.isEmpty()) {
                    female.pop();
                }

                male.pop();
                if (maleAge >= 2) {
                    male.push(maleAge - 2);
                }

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

