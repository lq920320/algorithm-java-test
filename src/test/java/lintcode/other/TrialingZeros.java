package lintcode.other;

import org.junit.Test;

/**
 * @author liuqian
 * @date 2021/1/12 22:27.
 */
public class TrialingZeros {
    /**
     * 设计一个算法，计算出n阶乘中尾部零的个数     *
     * 样例  1:
     * 输入: 11
     * 输出: 2
     * <p>
     * 样例解释:
     * 11! = 39916800, 结尾的0有2个。
     * <p>
     * 样例 2:
     * 输入:  5
     * 输出: 1
     * <p>
     * 样例解释:
     * 5! = 120， 结尾的0有1个。
     * <p>
     * 挑战    O(logN)的时间复杂度
     */
    @Test
    public void trialingZerosTest() {
        System.out.println(solution1(11));
        System.out.println(solution1(5));
        System.out.println(solution1(4));
    }

    /**
     * 可以将每个数拆分成素因子的乘积，可以发现，0 是由 `2*5` 产生的，而 5 的数量一定小于2 的数量，因此 5 的个数决定了结尾 0 的个数
     *
     * @param num
     * @return
     */
    public long solution1(long num) {
        long result = 0;
        while (num >= 5) {
            num = num / 5;
            result += num;
        }
        return result;
    }
}
