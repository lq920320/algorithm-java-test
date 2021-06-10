package leetcode.solution;

import org.junit.Test;

import java.util.Stack;

/**
 * #剑指 Offer 09. 用两个栈实现队列
 * 难度：简单
 *
 * @author zetu
 * @date 2021/6/10
 */
public class ImplementQueueUsingStacks {

    /**
     * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
     * <p>
     * 示例 1：
     * <p>
     * 输入：
     * ["CQueue","appendTail","deleteHead","deleteHead"]
     * [[],[3],[],[]]
     * 输出：[null,null,3,-1]
     * 示例 2：
     * <p>
     * 输入：
     * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
     * [[],[],[5],[2],[],[]]
     * 输出：[null,-1,null,null,5,2]
     * 提示：
     * <p>
     * 1 <= values <= 10000
     * 最多会对 appendTail、deleteHead 进行 10000 次调用
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
     */
    @Test
    public void solutionTest() {
        CQueue queue = new CQueue();
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);

        System.out.println(queue.deleteHead()); // 1
        System.out.println(queue.deleteHead()); // 2
        System.out.println(queue.deleteHead()); // 3
    }

    /**
     * 我们创建两个栈，栈1负责入队列，栈2负责出队列，出队列即把栈1的数据压入栈2中
     * 栈2中的顺序即为队列的顺序
     */
    class CQueue {

        // 初始化两个栈
        Stack<Integer> stack1, stack2;

        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        // 入队，我们往第一个栈压入值
        public void appendTail(int value) {
            stack1.push(value);
        }

        // 出队
        public int deleteHead() {
            // 大家可以自己思考一下为什么if条件为stack2.isEmpty(),细节所在
            // 栈2为空的时候，有两种情况，一是初始状态；
            // 二是表明队列中需要出队列的数据（即排列在队列前面的数据）已经出完了，否则就无需从栈1中获取数据，这时候需要从栈1重新获取数据出队列
            if (stack2.isEmpty()) {
                // 如果此时A栈没有值，则直接-1，我们可以看示例
                if (stack1.isEmpty()) {
                    return -1;
                }
                // 将A栈的值，压入B栈中
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }
}
