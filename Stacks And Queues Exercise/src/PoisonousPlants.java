import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedList<Long> pesticide = new LinkedList<>();
        String[] longNumbers = scanner.nextLine().split(" ");

        for (int i = 0; i < longNumbers.length; i++) {
            pesticide.add(Long.valueOf(Integer.parseInt(longNumbers[i])));
        }

        System.out.println(dayCounting(pesticide));
    }

    private static int dayCounting(List<Long> pesticide) {
        int count = 0;
        List<Integer> toRemove = new ArrayList<>();
        while (true) {

            for (int j = 0; j < pesticide.size() - 1; j++) {
                if (pesticide.get(j) < pesticide.get(j + 1)) {
                    toRemove.add(j + 1);
                }
            }

            if (toRemove.isEmpty()) {
                break;
            }

            int index = 0;

            for (Integer j : toRemove) {
                pesticide.remove(j - index);
                index++;
            }

            toRemove.clear();
            count++;
        }

        return count;
    }
}
