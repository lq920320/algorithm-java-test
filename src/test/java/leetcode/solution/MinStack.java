package leetcode.solution;

import org.junit.Test;

import java.util.Stack;

/**
 * #155. 最小栈
 * 难度：简单
 *
 * @author zetu
 * @date 2021/6/14
 */
public class MinStack {

    /**
     * #155. 最小栈
     * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
     * push(x) —— 将元素 x 推入栈中。
     * pop() —— 删除栈顶的元素。
     * top() —— 获取栈顶元素。
     * getMin() —— 检索栈中的最小元素。
     * <p>
     * 示例:
     * <p>
     * 输入：
     * ["MinStack","push","push","push","getMin","pop","top","getMin"]
     * [[],[-2],[0],[-3],[],[],[],[]]
     * 输出：
     * [null,null,null,null,-3,null,0,-2]
     * 解释：
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.getMin();   --> 返回 -2.
     * <p>
     * 提示：
     * pop、top 和 getMin 操作总是在 非空栈 上调用。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/min-stack
     */
    @Test
    public void solutionTest() {
        MinStack1 minStack = new MinStack1();

        minStack.push(8);
        minStack.push(1);
        minStack.push(2);

        System.out.println(minStack.getMin()); // 1
    }

    /**
     * 使用辅助栈完成最小值的获取
     */
    class MinStack1 {

        // 初始化
        Stack<Integer> A, B;

        public MinStack1() {
            A = new Stack<>();
            // B 存储最小值
            B = new Stack<>();
        }

        // 入栈，如果插入值，当前插入值小于栈顶元素，则入栈，栈顶元素保存的则为当前栈的最小元素
        public void push(int val) {
            A.push(val);
            if (B.isEmpty() || B.peek() >= val) {
                B.push(val);
            }
        }

        // 出栈，如果A出栈等于B栈顶元素，则说明此时栈内的最小元素改变了。
        // 这里需要使用 equals() 代替 == 因为 Stack 中存储的是 int 的包装类 Integer
        public void pop() {
            if (A.pop().equals(B.peek())) {
                B.pop();
            }
        }

        // A栈的栈顶元素
        public int top() {
            return A.peek();
        }

        // B栈的栈顶元素
        public int getMin() {
            return B.peek();
        }
    }

}
