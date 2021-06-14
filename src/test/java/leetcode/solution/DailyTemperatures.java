package leetcode.solution;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * #739. 每日温度
 * 难度：中等
 *
 * @author zetu
 * @date 2021/6/14
 */
public class DailyTemperatures {

    /**
     * #739. 每日温度
     * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
     * <p>
     * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
     * <p>
     * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/daily-temperatures
     */
    @Test
    public void solutionTest() {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        // [1, 1, 4, 2, 1, 1, 0, 0]
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }

    /**
     * 遍历数组，数组中的值为待入栈元素，待入栈元素入栈时会先跟栈顶元素进行对比，如果小于该值则入栈，如果大于则将栈顶元素出栈，新的元素入栈。
     * <p>
     * 例如栈顶为69，新的元素为72，则69出栈，72入栈。并赋值给 arr，69 的索引为4，72的索引为5，则 arr[4] = 5 - 4 = 1，这个题目用到的是单调栈的思想，下面我们来看一下视频解析。
     *
     * @param temperatures
     * @return {@link int[]}
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        if (len == 0) {
            return temperatures;
        }
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            // 单调栈
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                arr[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return arr;
    }
}
