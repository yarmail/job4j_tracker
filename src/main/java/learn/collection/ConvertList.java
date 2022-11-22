package learn.collection;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> rsl = new ArrayList<>();
        for (int[] row : list) {
            for (int num : row) {
                rsl.add(num);
            }
        }
        return rsl;
    }
}
