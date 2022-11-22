package learn.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class JobTest {

    @Test
    public void whenSortNameAndPriority() {
        Comparator<Job> cmpNameAndPriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNameAndPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenSortAscNameAndPriority() {
        Comparator<Job> cmpNameAndPriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNameAndPriority.compare(
                new Job("Impl task", 12),
                new Job("Impl task", 1)
        );
        assertThat(rsl, greaterThan(0));
    }
}
