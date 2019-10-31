import java.util.ArrayDeque;
import java.util.Scanner;

public class ClubParty_chernova {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hallCapacity = Integer.parseInt(scanner.nextLine());
        String[] line = scanner.nextLine().split(" ");

        ArrayDeque<String> currentHall = new ArrayDeque<>();
        ArrayDeque<Integer> currentHallReservation = new ArrayDeque<>();
        int currentHallCapacity = 0;
        for (int i = line.length - 1; i >= 0; i--) {


            if (Character.isDigit(line[i].charAt(0))) {
                if (currentHall.isEmpty()) {
                    continue;
                }
                int reservations = Integer.parseInt(line[i]);
                currentHallCapacity += reservations;
                if (currentHallCapacity > hallCapacity) {
                    printMethode(currentHall, currentHallReservation);
                    currentHallCapacity = 0;
                    i++;
                } else {
                    currentHallReservation.offer(reservations);

                }
            } else {
                String hall = line[i];
                currentHall.offer(hall);
            }

        }

    }

    private static void printMethode(ArrayDeque<String> currentHall, ArrayDeque<Integer> currentHallReservation) {
        System.out.print(currentHall.poll() + " -> ");
        int count = 0;
        for (Integer reservation : currentHallReservation) {
            reservation = currentHallReservation.poll();
            System.out.print(reservation);
            if (count != currentHallReservation.size()) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

}
