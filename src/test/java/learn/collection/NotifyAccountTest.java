package learn.collection;

import learn.collection.Account;
import learn.collection.NotifyAccount;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class NotifyAccountTest {
    @Test
    public void sentNotDuplicate() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001")
        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                        new Account("123", "Petr Arsentev", "eDer3432f"),
                        new Account("142", "Petr Arsentev", "000001")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }

    @Test
    public void sentWithDuplicate() {
        List<Account> list = Arrays.asList(
                new Account("142", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001"),
                new Account("1234", "Isaak New", "121344Er"),
                new Account("023", "Albert En", "34o92t023o"),
                new Account("1234", "Garet Gal", "012034")
        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                        new Account("142", "Petr Arsentev", "000001"),
                        new Account("1234", "Isaak New", "121344Er"),
                        new Account("023", "Albert En", "34o92t023o")
                )
        );
        assertThat(NotifyAccount.sent(list), is(expect));
    }
}
