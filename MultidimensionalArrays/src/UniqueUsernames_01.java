import java.util.LinkedHashSet;
        import java.util.Scanner;

public class UniqueUsernames_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<String> names = new LinkedHashSet<>();
        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {

            String name = scanner.nextLine();

            if (!names.contains(name)) {
                names.add(name);
            }
        }

        for (String s : names) {
            System.out.println(s);
        }
    }
}
