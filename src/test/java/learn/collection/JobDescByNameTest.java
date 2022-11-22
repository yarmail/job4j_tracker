package learn.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class JobDescByNameTest {

    @Test
    public void whenCompareTwoNumPlusOne() {
        int res = new JobDescByName().compare(new Job("b", 3), new Job("a", 2));
        assertThat(res, lessThan(0));
    }

    @Test
    public void whenSortThisComparator() {
        List<Job> arr = Arrays.asList(
                new Job("b", 5),
                new Job("a", 12),
                new Job("c", 1),
                new Job("d", 8)
        );
        List<Job> expected = Arrays.asList(
                new Job("d", 8),
                new Job("c", 1),
                new Job("b", 5),
                new Job("a", 12)
        );
        arr.sort(new JobDescByName());
        assertThat(expected, is(arr));
    }
}
