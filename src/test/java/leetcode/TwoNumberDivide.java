package leetcode;

import org.junit.Test;

/**
 * @author liuqian
 * @date 2018/7/30 22:59.
 */
public class TwoNumberDivide {

  /**
   * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
   * <p>
   * 返回被除数 dividend 除以除数 divisor 得到的商。
   * <p>
   * 示例 1:
   * <p>
   * 输入: dividend = 10, divisor = 3
   * 输出: 3
   * 示例 2:
   * <p>
   * 输入: dividend = 7, divisor = -3
   * 输出: -2
   * 说明:
   * <p>
   * 被除数和除数均为 32 位有符号整数。
   * 除数不为 0。
   * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。
   * <p>
   * 详情请看讨论
   * https://leetcode.com/problems/divide-two-integers/discuss/13397/Clean-Java-solution-with-some-comment.
   */
  @Test
  public void divideTest() {
    System.out.println(divide(10, 3));
    System.out.println(divide(7, -3));
    System.out.println(divide(-3, -1));
    System.out.println(divide(-2147483648, -1));
    System.out.println(divide(-2147483648, 1));
    System.out.println(divide(0, 1));
  }

  public int divide(int dividend, int divisor) {
    int sign = 1;
    if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
      sign = -1;
    }
    long ldividend = Math.abs((long) dividend);
    long ldivisor = Math.abs((long) divisor);
    if (ldivisor == 0) return Integer.MAX_VALUE;
    if ((ldividend == 0) || (ldividend < divisor)) return 0;
    long lans = ldivide(ldividend, ldivisor);

    int ans;
    if (lans > Integer.MAX_VALUE) {
      ans = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    } else {
      ans = (int) (sign > 0 ? lans : 0 - lans);
    }
    return ans;
  }

  private long ldivide(long ldividend, long ldivisor) {
    if (ldividend < ldivisor) return 0;
    long sum = ldivisor;
    long multiple = 1;
    while ((sum + sum) <= ldividend) {
      sum += sum;
      multiple += multiple;
    }
    return multiple + ldivide(ldividend - sum, ldivisor);
  }
}
