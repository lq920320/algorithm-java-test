package leetcode.solution;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * #剑指 Offer 59 - II. 队列的最大值
 * 难度：中等
 *
 * @author zetu
 * @date 2021/6/14
 */
public class MaxValueInQueue {

    /**
     * #剑指 Offer 59 - II. 队列的最大值
     * <p>
     * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
     * 若队列为空，pop_front 和 max_value 需要返回 -1
     * <p>
     * 示例 1：
     * 输入:
     * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
     * [[],[1],[2],[],[],[]]
     * 输出: [null,null,null,2,1,2]
     * <p>
     * 示例 2：
     * 输入:
     * ["MaxQueue","pop_front","max_value"]
     * [[],[],[]]
     * 输出: [null,-1,-1]
     * <p>
     * 限制：
     * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
     * 1 <= value <= 10^5
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
     */
    @Test
    public void solutionTest() {
        MaxQueue maxQueue = new MaxQueue();

        maxQueue.push_back(1);
        maxQueue.push_back(2);
        maxQueue.push_back(4);
        maxQueue.push_back(0);

        System.out.println(maxQueue.max_value()); // 4
        System.out.println(maxQueue.pop_front()); // 1
        System.out.println(maxQueue.pop_front()); // 2
        System.out.println(maxQueue.pop_front()); // 4
        System.out.println(maxQueue.max_value()); // 0
    }

    /**
     * 1.我们需要维护一个单调双端队列，上面的队列则执行正常操作，下面的队列队头元素则为上面队列的最大值
     * <p>
     * 2.出队时，我们需要进行对比两个队列的队头元素是否相等，如果相等则同时出队，则出队后的双端队列的头部仍未上面队列中的最大值。
     * <p>
     * 3.入队时，我们需要维持一个单调递减的双端队列，因为我们需要确保队头元素为最大值嘛。
     */
    class MaxQueue {
        // 普通队列
        Queue<Integer> que;
        // 双端队列
        Deque<Integer> deq;

        public MaxQueue() {
            que = new LinkedList<>();
            deq = new LinkedList<>();
        }

        // 获取最大值值，返回我们双端队列的对头即可，因为我们双端队列是单调递减的嘛
        public int max_value() {
            return deq.isEmpty() ? -1 : deq.peekFirst();
        }

        // 入队操作
        public void push_back(int value) {
            que.offer(value);
            // 维护单调递减
            while (!deq.isEmpty() && value > deq.peekLast()) {
                deq.pollLast();
            }
            deq.offerLast(value);
        }

        public int pop_front() {
            if (que.isEmpty()) {
                return -1;
            }
            if (que.peek().equals(deq.peekFirst())) {
                deq.pollFirst();
            }
            return que.poll();
        }
    }
}
