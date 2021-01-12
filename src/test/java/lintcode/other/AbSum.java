package lintcode.other;

import org.junit.Test;

/**
 * @author liuqian
 * @date 2021/1/12 22:43.
 */
public class AbSum {

    /**
     * #2 A + B 问题
     * 尝试使用位运算解决 A + B 的问题
     */
    @Test
    public void AbSumTest() {
        System.out.println(aplusb(1, 2));
    }

    public int aplusb(int a, int b) {
        // 主要使用异或位运算来完成
        // 异或运算有一个别名：不进位加法
        // 那么 `a ^ b` 就是 a 和 b 相加之后，该进位的地方不进位的结果
        // 然后下面就要考虑哪些地方需要进位，自然是 a 和 b 里都是 1 的地方
        // `a & b` 就是 a 和 b 里都是 1 位置，`a & b << 1` 就是进位之后的结果。
        // 所以 `a + b = (a ^ b) + (a & b) << 1`，令 `a' = a ^ b, b' = (a & b) << 1`
        // 可以知道，这个过程是在模拟加法的过程，进位不可能一直持续，所以 b 最终会变为 0。
        // 因此重复上述操作就可以求得 `a + b` 的值。
        // 求和的结果
        int sum = 0;
        // 进位
        int carry = 0;
        while (b != 0) {
            sum = a ^ b;
            // 对应位和的进位，既然是进位，就要整体左移一位
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return sum;
    }
}
