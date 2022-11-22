package learn.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
public class JobAscByPriorityTest {

    @Test
    public void whenCompareTwoNumPlusOne() {
        int res = new JobAscByPriority().compare(new Job("a", 3), new Job("b", 2));
        assertThat(res, greaterThan(0));
    }

    @Test
    public void whenSortThisComparator() {
        List<Job> arr = Arrays.asList(
                new Job("b", 5),
                new Job("a", 12),
                new Job("c", 1),
                new Job("b", 8)
        );
        arr.sort(new JobAscByPriority());
        List<Job> expected = Arrays.asList(
                new Job("c", 1),
                new Job("b", 5),
                new Job("b", 8),
                new Job("a", 12)
        );
        assertThat(expected, is(arr));
    }
}
