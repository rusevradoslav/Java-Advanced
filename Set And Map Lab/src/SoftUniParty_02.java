import java.util.Scanner;
        import java.util.TreeSet;

public class SoftUniParty_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<String> vip = new TreeSet<>();
        TreeSet<String> regular = new TreeSet<>();


        String line = scanner.nextLine();


        while (!line.equals("PARTY")) {
            if (Character.isDigit(line.charAt(0))) {
                vip.add(line);
            } else {
                regular.add(line);
            }
            line = scanner.nextLine();
        }
        while (!line.equals("END")) {
            if (vip.contains(line)) {
                vip.remove(line);
            } else if (regular.contains(line)) {
                regular.remove(line);
            }
            line = scanner.nextLine();
        }
        int people = vip.size() + regular.size();
        System.out.println(people);
        for (String s : vip) {
            System.out.println(s);
        }
        for (String s : regular) {
            System.out.println(s);
        }
    }
}

