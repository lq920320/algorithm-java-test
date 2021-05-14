package leetcode.solution;

import org.junit.Assert;
import org.junit.Test;

/**
 * # 233. 数字 1 的个数
 * 难度： 困难
 *
 * @author zetu
 * @date 2021/5/12
 */
public class NumberOfDigitOne {

    /**
     * # 233. 数字 1 的个数
     * <p>
     * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
     * <p>
     * 示例 1：
     * 输入：n = 13
     * 输出：6
     * <p>
     * 示例 2：
     * 输入：n = 0
     * 输出：0
     * <p>
     * 提示：
     * 0 <= n <= 2 * 10^9
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-digit-one
     */
    @Test
    public void solutionTest() {
        Assert.assertEquals(6, countDigitOne(13));
    }

    /**
     * 题目详解： https://github.com/chefyuan/algorithm-base/blob/main/animation-simulation/%E5%89%91%E6%8C%87offer/1%E7%9A%84%E4%B8%AA%E6%95%B0.md
     *
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        if (n == 0) {
            return 0;
        }
        // 高位
        int high = n;
        // 低位
        int low = 0;
        // 当前位
        int cur = 0;
        int count = 0;
        int num = 1;
        while (high != 0 || cur != 0) {
            cur = high % 10;
            high /= 10;
            // 这里我们可以提出 high * num 因为我们发现无论为几，都含有它
            if (cur == 0) {
                count += high * num;
            } else if (cur == 1) {
                count += high * num + 1 + low;
            } else {
                count += (high + 1) * num;
            }
            // 低位
            low = cur * num + low;
            num *= 10;
        }
        return count;
    }
}
