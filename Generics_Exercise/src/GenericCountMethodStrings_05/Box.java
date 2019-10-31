package GenericCountMethodStrings_05;

import java.util.ArrayList;

public class Box<T extends Comparable> {
    private ArrayList<T> collection;

    public Box() {
        this.collection = new ArrayList<>();
    }

    public ArrayList<T> getCollection() {
        return collection;
    }


    public int getCount(ArrayList<T> collection, T element) {
        int count = 0;

        for (T text : collection) {
            if (text.compareTo(element) > 0) {
                count++;
            }
        }

        return count;
    }
}
