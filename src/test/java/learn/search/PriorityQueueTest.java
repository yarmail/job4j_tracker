package learn.search;

import learn.search.PriorityQueue;
import learn.search.Task;
import org.junit.Assert;
import org.junit.Test;

public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        var queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        var result = queue.take();
        Assert.assertEquals(result.getDesc(), "urgent");
    }
}
