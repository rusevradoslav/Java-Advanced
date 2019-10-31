package GenericScale_03;

public class Main {
    public static void main(String[] args) {

        Scale<Integer> integer = new Scale<>(5, 7);
        Scale<String> strings = new Scale<>("left", "right");
        System.out.println(integer.getHeavier());
        System.out.println(strings.getHeavier());
    }


}
