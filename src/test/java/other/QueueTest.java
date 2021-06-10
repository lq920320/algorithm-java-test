package other;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * queue 方法测试
 *
 * @author zetu
 * @date 2021/6/10
 */
public class QueueTest {

    @Test
    public void queueTest() {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);

        System.out.println(queue.peek());

        System.out.println(queue.poll());

        System.out.println(queue.isEmpty());
    }
}
