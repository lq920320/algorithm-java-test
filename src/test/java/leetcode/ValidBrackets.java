package leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * @author liuqian
 * @date 2019/4/22 23:16.
 */
public class ValidBrackets {

  /**
   * 20. 有效的括号
   * <p>
   * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
   * <p>
   * 有效字符串需满足：
   * <p>
   * 左括号必须用相同类型的右括号闭合。
   * 左括号必须以正确的顺序闭合。
   * <p>
   * 注意空字符串可被认为是有效字符串。
   * <p>
   * 示例 1:
   * <p>
   * 输入: "()"
   * 输出: true
   * <p>
   * 示例 2:
   * <p>
   * 输入: "()[]{}"
   * 输出: true
   * <p>
   * 示例 3:
   * <p>
   * 输入: "(]"
   * 输出: false
   * <p>
   * 示例 4:
   * <p>
   * 输入: "([)]"
   * 输出: false
   * <p>
   * 示例 5:
   * <p>
   * 输入: "{[]}"
   * 输出: true
   */
  @Test
  public void validBrackets() {
    System.out.println(isValid("()"));
    System.out.println(isValid("()[]{}"));
    System.out.println(isValid("(]"));
    System.out.println(isValid("([)]"));
    System.out.println(isValid("{[]}"));
  }

  /**
   * @param s 字符串
   * @return 验证结果
   * <p>
   * 思路：遍历 string，遇到左括号，压入栈中；遇到右括号，从栈中弹出元素，元素不存在或者元素与该右括号不匹配，返回 false。遍历结束，栈为空则返回 true，否则返回 false。
   */
  private boolean isValid(String s) {
    if (s == null || s.equals("")) {
      return true;
    }
    char[] chars = s.toCharArray();
    Stack<Character> stack = new Stack<>();
    for (char c : chars) {
      if (isLeft(c)) {
        stack.push(c);
      } else if (stack.isEmpty() || !isMatch(stack.pop(), c)) {
        return false;
      }
    }
    return stack.isEmpty();
  }

  private boolean isMatch(char a, char b) {
    return (a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}');
  }

  private boolean isLeft(char a) {
    return a == '(' || a == '[' || a == '{';
  }
}
