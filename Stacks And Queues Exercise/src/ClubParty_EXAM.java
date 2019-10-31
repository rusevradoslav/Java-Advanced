import java.util.*;
import java.util.stream.Collectors;

public class ClubParty_EXAM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int hallCapacity = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> stack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(e -> stack.push(e));
        ArrayDeque<String> currentHall = new ArrayDeque<>();
        ArrayDeque<Integer> currentHallReservations = new ArrayDeque<>();


        int currentCapacity = 0;
        while (!stack.isEmpty()) {
            String element = stack.pop();
            if (Character.isDigit(element.charAt(0))) {
                if (currentHall.isEmpty()) {
                    continue;
                }
                int reservations = Integer.parseInt(element);
                currentCapacity += reservations;

                if (currentCapacity > hallCapacity) {
                    printMethode(currentHall, currentHallReservations);
                    stack.push(element);
                    currentCapacity = 0;
                    continue;
                } else {
                    currentHallReservations.add(reservations);
                }
            } else {
                currentHall.add(element);

            }

        }


    }

    private static void printMethode(ArrayDeque<String> currentHall, ArrayDeque<Integer> currentHallReservations) {
        System.out.print(currentHall.poll() + " -> ");
        int count = 0;
        for (Integer reservation : currentHallReservations) {
            reservation = currentHallReservations.poll();
            System.out.print(reservation);
            if (count != currentHallReservations.size()) {
                System.out.print(", ");

            }
        }
        System.out.println();
    }
}






