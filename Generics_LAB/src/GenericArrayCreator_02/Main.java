package GenericArrayCreator_02;

public class Main {
    public static void main(String[] args) {

     //   Integer[] integers = (Integer[]) ArrayCreator.create(4, 0);
        String[] strings = ArrayCreator.create(String.class, 10, "asd");
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
