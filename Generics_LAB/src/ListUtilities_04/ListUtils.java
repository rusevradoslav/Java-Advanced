package ListUtilities_04;

import java.util.List;

public class ListUtils {

    public static <T extends Comparable<T>> T getMax(List<T> items) {
        if (items.size() == 0) {
            throw new IllegalArgumentException("max on empty list");
        }
     //  T max = items.get(0);

     //  for (int i = 1; i < items.size(); i++) {
     //      T current = items.get(i);
     //      if (max.compareTo(current) < 0) {
     //          max = current;
     //      }

     //  }
        // Solution with stream;
       T max = items.stream().reduce(items.get(0), (acc, c) -> acc.compareTo(c) < 0 ? c : acc);
        return max;
    }

    public static <T extends Comparable<T>> T getMin(List<T> items) {
        if (items.size() == 0) {
            throw new IllegalArgumentException("max on empty list");
        }
      //  T min = items.get(0);

       //for (int i = 1; i < items.size(); i++) {
       //    T current = items.get(i);
       //    if (min.compareTo(current) > 0) {
       //        min = current;
       //    }

       //}
        //Solution with stream;
        T min = items.stream().reduce(items.get(0), (acc, c) -> acc.compareTo(c) > 0 ? c : acc);
        return min;
    }
}
