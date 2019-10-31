package GenericArrayCreator_02;

import java.lang.reflect.Array;

public class ArrayCreator<T> {

    public static <T> T[] create(int lenght, T item) {
        T[] result = (T[])new Object[lenght];
        for (int i = 0; i < lenght; i++) {
            result[i] = item;
        }
        return result;
    }

    public static <T> T[] create(Class<T> clazz, int lenght, T item) {

        T[] result = (T[]) Array.newInstance(clazz,lenght);

        for (int i = 0; i < lenght; i++) {
            result[i] = item;
        }
        return result;
    }
}
