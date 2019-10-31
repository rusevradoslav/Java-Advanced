package GenericSwapMethodInteger_04;

import java.util.ArrayList;

public class Box<T> {
    private ArrayList<T> boxes;

    public Box() {
        this.boxes = new ArrayList<>();
    }

    public ArrayList<T> getBoxes() {
        return boxes;
    }

    public void swapper(ArrayList<T> boxes, int first, int second) {
        T firstItem = boxes.get(first);
        T secondItem = boxes.get(second);
        T temp = firstItem;
        boxes.set(first, secondItem);
        boxes.set(second, firstItem);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T box : boxes) {
            sb.append(String.format("%s: %s", box.getClass().getName(), box));
            sb.append(System.lineSeparator());

        }
        return sb.toString().trim();
    }
}
