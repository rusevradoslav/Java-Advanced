package JarOfT_01;

public class Main {
    public static void main(String[] args) {
        Jar<Integer> jar = new Jar();

        jar.add(5);
        jar.add(6);
        jar.add(7);
        jar.add(8);

        System.out.println(jar.remove());
        Jar<String> stringJar = new Jar();
       stringJar.add("asd");
       stringJar.add("asd");
       stringJar.add("asd");
       stringJar.add("asd");
        System.out.println(stringJar.remove());
    }
}
