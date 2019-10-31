import java.util.*;
import java.util.stream.Collectors;

public class Socks_EXAM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> leftSocks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(leftSock -> leftSocks.push(leftSock));


        ArrayDeque<Integer> rightSocks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(sock -> rightSocks.offer(sock));


        List<Integer> pairs = new ArrayList<>();

        while (!rightSocks.isEmpty() && !leftSocks.isEmpty()) {
            int left = leftSocks.pop();
            int right = rightSocks.poll();
            int sum = 0;
            if (left > right) {
                sum = left + right;
                pairs.add(sum);
            } else if (right > left) {
                rightSocks.addFirst(right);
            } else {
                leftSocks.push(left + 1);
            }

        }
        int max = pairs.stream().mapToInt(e -> e).max().getAsInt();
        //  int max1 = pairs.stream().max((f,s)->Integer.compare(f,s)).get();

        System.out.println(max);
        for (Integer pair : pairs) {
            System.out.print(pair + " ");

        }


    }
}
