package leetcode.solution;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * @author liuqian
 * @date 2019/8/12 17:35.
 * <p>
 * leetcode # 150
 */
public class EvalRpn {
  /*
   * 根据逆波兰表示法，求表达式的值。
   *
   * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
   *
   * 说明：
   *
   *     整数除法只保留整数部分。
   *     给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
   *
   * 示例 1：
   *
   * 输入: ["2", "1", "+", "3", "*"]
   * 输出: 9
   * 解释: ((2 + 1) * 3) = 9
   *
   * 示例 2：
   *
   * 输入: ["4", "13", "5", "/", "+"]
   * 输出: 6
   * 解释: (4 + (13 / 5)) = 6
   *
   * 示例 3：
   *
   * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
   * 输出: 22
   * 解释:
   *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
   * = ((10 * (6 / (12 * -11))) + 17) + 5
   * = ((10 * (6 / -132)) + 17) + 5
   * = ((10 * 0) + 17) + 5
   * = (0 + 17) + 5
   * = 17 + 5
   * = 22
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
   */
  @Test
  public void evalRpnTest() {
    Assert.assertEquals(9, evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    Assert.assertEquals(6, evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    Assert.assertEquals(22, evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));

  }

  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    int result;
    for (String t : tokens) {
      switch (t) {
        case "+":
          result = stack.pop() + stack.pop();
          break;
        case "*":
          result = stack.pop() * stack.pop();
          break;
        case "/":
          // 除法需要保持顺序，比如 "13", "5", "/" => 应该是 13 / 5 而不是 5 / 13
          int last = stack.pop();
          result = stack.pop() / last;
          break;
        case "-":
          // 减法顺序和除法一样
          last = stack.pop();
          result = stack.pop() - last;
          break;
        default:
          result = Integer.parseInt(t);
          break;
      }
      // 将计算结果或者元素本身推入栈中
      stack.push(result);
    }
    return stack.pop();
  }
}
