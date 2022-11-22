package learn.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OrderConvertTest {
    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        Assert.assertEquals(map.get("3sfe"), new Order("3sfe", "Dress"));
    }

    @Test
    public void whenListFourConvertToHashThree() {
        List<Order> orders = Arrays.asList(
                new Order("3sfe", "Dress"),
                new Order("12Np", "Alt"),
                new Order("1234Jue", "End"),
                new Order("12Np", "Duplicate")
        );
        HashMap<String, Order> map = OrderConvert.process(orders);
        Assert.assertEquals(map.size(), 3);
    }
}