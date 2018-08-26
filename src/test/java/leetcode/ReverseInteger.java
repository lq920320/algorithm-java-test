package leetcode;

import org.junit.Test;

/**
 * @author liuqian
 * @date 2018/8/26 19:18.
 * <p>
 * tag: Easy
 */
public class ReverseInteger {

  /**
   * 给定一个 32 位有符号整数，将整数中的数字进行反转。
   * <p>
   * 示例 1:
   * <p>
   * 输入: 123
   * 输出: 321
   * 示例 2:
   * <p>
   * 输入: -123
   * 输出: -321
   * 示例 3:
   * <p>
   * 输入: 120
   * 输出: 21
   * 注意:
   * <p>
   * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
   */
  @Test
  public void reverseIntegerTest() {
    System.out.println(String.valueOf(reverse(123)));
    System.out.println(String.valueOf(reverse(-123)));
    System.out.println(String.valueOf(reverse(120)));
    System.out.println(String.valueOf(reverse(Integer.MAX_VALUE)));
  }

  public int reverse(int x) {
    int reverse = 0;
    while (x != 0) {
      int pop = x % 10;
      x /= 10;
      if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && pop == 7)) {
        return 0;
      }
      if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && pop == -8)) {
        return 0;
      }
      reverse = reverse * 10 + pop;
    }
    return reverse;
  }
}
