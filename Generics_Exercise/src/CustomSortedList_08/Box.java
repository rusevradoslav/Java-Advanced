package CustomSortedList_08;

import java.util.ArrayList;

public class Box<T extends Comparable> {
    private ArrayList<T> collections;

    public Box() {
        this.collections = new ArrayList<>();
    }

    public ArrayList<T> getCollections() {
        return collections;
    }

    public void setCollections(ArrayList<T> collections) {
        this.collections = collections;
    }

    public void add(T token) {
        collections.add(token);
    }

    public T remove(int index) {
        return collections.remove(index);
    }


    public boolean contains(T elememt) {
        for (T text : collections) {
            if (text.equals(elememt)) {
                return true;
            }
        }
        return false;
    }

    public void swapper(int first, int second) {
        T firstItem = collections.get(first);
        T secondItem = collections.get(second);
        collections.set(first, secondItem);
        collections.set(second, firstItem);

    }

    public int greaterCount(T element) {
        int count = 0;
        for (T text : collections) {
            if (text.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    public T getMax() {
        return collections.stream().max((f, s) -> f.compareTo(s)).get();
    }

    public T getMin() {
        return collections.stream().min((f, s) -> f.compareTo(s)).get();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T collection : collections) {
            sb.append(collection).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }


}
