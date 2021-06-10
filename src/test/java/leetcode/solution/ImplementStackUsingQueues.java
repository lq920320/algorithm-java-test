package leetcode.solution;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * #225. 用队列实现栈
 * 难度：简单
 *
 * @author zetu
 * @date 2021/6/10
 */
public class ImplementStackUsingQueues {

    /**
     * #225. 用队列实现栈
     * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通队列的全部四种操作（push、top、pop 和 empty）。
     * 实现 MyStack 类：
     * <p>
     * void push(int x) 将元素 x 压入栈顶。
     * int pop() 移除并返回栈顶元素。
     * int top() 返回栈顶元素。
     * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
     * <p>
     * 注意：
     * <p>
     * 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
     * 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列, 只要是标准的队列操作即可。
     * <p>
     * 示例：
     * 输入：
     * ["MyStack", "push", "push", "top", "pop", "empty"]
     * [[], [1], [2], [], [], []]
     * 输出：
     * [null, null, null, 2, 2, false]
     * <p>
     * 解释：
     * MyStack myStack = new MyStack();
     * myStack.push(1);
     * myStack.push(2);
     * myStack.top(); // 返回 2
     * myStack.pop(); // 返回 2
     * myStack.empty(); // 返回 False
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= x <= 9
     * 最多调用100 次 push、pop、top 和 empty
     * 每次调用 pop 和 top 都保证栈不为空
     * <p>
     * 进阶：你能否实现每种操作的均摊时间复杂度为 O(1) 的栈？换句话说，执行 n 个操作的总时间复杂度 O(n) ，尽管其中某个操作可能需要比其他操作更长的时间。你可以使用两个以上的队列。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
     */
    @Test
    public void solutionTest() {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // 返回 2
        System.out.println(myStack.pop()); // 返回 2
        System.out.println(myStack.empty()); // 返回 False
    }

    /**
     * 我们利用队列先进先出的特点，每次队列模拟入栈时，我们先将队列之前入队的元素都出列，仅保留最后一个进队的元素。
     * <p>
     * 然后再重新入队，这样就实现了颠倒队列中的元素。比如我们首先入队1，然后再入队2，我们需要将元素1出队，然后再重新入队，则实现了队列内元素序列变成了2,1。
     */
    class MyStack {

        /**
         * Initialize your data structure here.
         */
        Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            queue.offer(x);
            // 将之前的全部都出队，然后再入队
            for (int i = 1; i < queue.size(); i++) {
                queue.offer(queue.poll());
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return queue.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return queue.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
