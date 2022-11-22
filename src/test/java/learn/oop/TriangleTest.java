package learn.oop;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

import learn.oop.Point;
import learn.oop.Triangle;
import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

    @Test
    public void when00and40and04Then8() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        double expected = 8;
        Assert.assertEquals(expected, rsl, 0.001);
    }

    @Test
    public void when44and00and00ThenMinus1() {
        Point a = new Point(4, 4);
        Point b = new Point(0, 0);
        Point c = new Point(0, 0);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        double expected = -1;
        Assert.assertEquals(expected, rsl, 0.001);
    }
}