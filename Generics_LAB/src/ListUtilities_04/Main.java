package ListUtilities_04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 1, 2, 3, 4, 5, 6, 12);
        Integer maxInteger = ListUtils.getMax(integers);
        System.out.println(maxInteger);
        Integer minValue = ListUtils.getMin(integers);
        System.out.println(minValue);
    }
}
