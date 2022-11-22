package learn.collection;

import learn.collection.ConvertList2Array;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ConvertList2ArrayTest {

    @Test
    public void when7ElementsThen9() {
        int[][] result = ConvertList2Array.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        Assert.assertArrayEquals(expect, result);
    }

    @Test
    public void when5ElementsThen6() {
        int[][] result = ConvertList2Array.toArray(
                Arrays.asList(1, 2, 3, 4, 5),
                2
        );
        int[][] expect = {
                {1, 2},
                {3, 4},
                {5, 0}
        };
        Assert.assertArrayEquals(expect, result);
    }
}

