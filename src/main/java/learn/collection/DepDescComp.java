package learn.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] arr1 = left.split("/");
        String[] arr2 = right.split("/");
        int rsl = arr2[0].compareTo(arr1[0]);
        return rsl == 0 ? left.compareTo(right) : rsl;
    }
}
