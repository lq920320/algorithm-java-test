package leetcode.solution;

import org.junit.Test;

import java.util.Stack;

/**
 * #402. 移掉K位数字
 * 难度：中等
 *
 * @author zetu
 * @date 2021/6/10
 */
public class RemoveKDigits {

    /**
     * #402. 移掉K位数字
     * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
     * <p>
     * 注意:
     * num 的长度小于 10002 且 ≥ k。
     * num 不会包含任何前导零。
     * <p>
     * 示例 1 :
     * 输入: num = "1432219", k = 3
     * 输出: "1219"
     * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
     * <p>
     * 示例 2 :
     * 输入: num = "10200", k = 1
     * 输出: "200"
     * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
     * <p>
     * 示例 3 :
     * 输入: num = "10", k = 2
     * 输出: "0"
     * 解释: 从原数字移除所有的数字，剩余为空就是0。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-k-digits
     */
    @Test
    public void solutionTest() {

        System.out.println(removeKdigits("10324567", 4));
    }

    /**
     * 因为我们需要删除掉K位数字得到最小值，那么我们需要注意的是，删除的数字应该尽量在高位，则当前位小于前一位时，对前一位出栈，当前位入栈。大家思考一下思路是不是这样呢？
     * <p>
     * 另外我们需要注意的是，仅删除K位数字，得到最小值，比如54321，我们删除3位，得到21。但是刚才我们说当前位小于前一位时，则前一位出栈，当前位入栈，所以我们需要加上删除K位的规则。
     *
     * @param num
     * @param k
     * @return {@link String}
     */
    public String removeKdigits(String num, int k) {
        // 特殊情况全部删除
        if (num.length() == k) {
            return "0";
        }
        char[] s = num.toCharArray();
        Stack<Character> stack = new Stack<>();
        // 遍历数组
        for (Character i : s) {
            // 移除元素的情况，k--
            while (!stack.isEmpty() && i < stack.peek() && k > 0) {
                stack.pop();
                k--;
            }
            // 栈为空，且当前位为0时，我们不需要将其入栈
            if (stack.isEmpty() && i == '0') {
                continue;
            }
            stack.push(i);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        if (stack.isEmpty()) {
            return "0";
        }
        // 反转并返回字符串
        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }
        return str.reverse().toString();
    }

}
