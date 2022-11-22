package learn.collection;


import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

public class LexSortTest {
    @Test
    public void sortNum1and2and10() {
        String[] input = {
                "10. Task.",
                "1. Task.",
                "2. Task."
        };
        String[] out = {
                "1. Task.",
                "2. Task.",
                "10. Task."
        };
        Arrays.sort(input, new LexSort());
        Assert.assertArrayEquals(input, out);
    }
}
