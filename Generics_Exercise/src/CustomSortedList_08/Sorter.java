package CustomSortedList_08;

import java.util.ArrayList;
import java.util.List;

public class Sorter<T extends Comparable<T>> {


    public void sort(Box<T> box) {
        ArrayList<T> sortedCollection = box.getCollections();
        sortedCollection.sort((t, o) -> t.compareTo(o));
        box.setCollections(sortedCollection);
    }
}
