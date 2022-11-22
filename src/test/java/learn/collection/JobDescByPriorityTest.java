package learn.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class JobDescByPriorityTest {
    @Test
    public void whenCompareTwoNumPlusOne() {
        int res = new JobDescByName().compare(new Job("a", 3), new Job("b", 2));
        assertThat(res, greaterThan(0));
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
                new Job("a", 12),
                new Job("d", 8),
                new Job("b", 5),
                new Job("c", 1)

        );
        arr.sort(new JobDescByPriority());
        assertThat(expected, is(arr));
    }
}
