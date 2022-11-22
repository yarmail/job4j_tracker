package learn.collection;

import java.util.Collections;
import java.util.HashSet;

public class UniqueText {

    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        Collections.addAll(check, origin);
        for (String elem : text) {
            if (!check.contains(elem)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
