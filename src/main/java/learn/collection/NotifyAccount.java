package learn.collection;

import java.util.HashSet;
import java.util.List;

public class NotifyAccount {

    public static HashSet<Account> sent(List<Account> list) {
        HashSet<Account> rsl = new HashSet<>();
        for (Account acc : list) {
            rsl.add(acc);
        }
        return rsl;
    }
}
