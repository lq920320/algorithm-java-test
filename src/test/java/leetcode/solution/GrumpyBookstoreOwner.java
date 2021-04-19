package leetcode.solution;

import org.junit.Assert;
import org.junit.Test;

/**
 * # 1052. 爱生气的书店老板
 * 难度：中等
 *
 * @author zetu
 * @date 2021/4/19
 */
public class GrumpyBookstoreOwner {

    /**
     * # 1052. 爱生气的书店老板
     * <p>
     * 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
     * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
     * <p>
     * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
     * <p>
     * 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
     * <p>
     * 示例：
     * 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
     * 输出：16
     * 解释：
     * 书店老板在最后 3 分钟保持冷静。
     * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
     * <p>
     * 提示：
     * <p>
     * 1 <= X <= customers.length == grumpy.length <= 20000
     * 0 <= customers[i] <= 1000
     * 0 <= grumpy[i] <= 1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/grumpy-bookstore-owner
     */
    @Test
    public void grumpyBookstoreOwnerTest() {
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        int X = 3;

        Assert.assertEquals(16, maxSatisfied(customers, grumpy, X));
    }

    /**
     * 该题目思想就是，我们将 customer 数组的值分为三部分， leftsum, winsum, rightsum。
     * 我们题目的返回值则是三部分的最大和。
     * <p>
     * winsum 是窗口内的所有值，不管 grumpy[i] 的值是 0 还是 1,窗口的大小，就对应 K 的值，也就是老板的技能发动时间，该时间段内，老板不会生气，所以为所有的值。
     * <p>
     * leftsum 是窗口左边区间的值，此时我们不能为所有值，只能是 grumpy[i] == 0 时才可以加入，因为此时不是技能发动期，老板只有在 grumpy[i] == 0 时，才不会生气。
     * <p>
     * rightsum 是窗口右区间的值，和左区间加和方式一样。
     *
     * @param customers
     * @param grumpy
     * @param X
     * @return
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int winSum = 0;
        int rightSum = 0;
        int len = customers.length;
        // 右区间的值
        for (int i = X; i < len; ++i) {
            if (grumpy[i] == 0) {
                rightSum += customers[i];
            }
        }
        // 窗口的值
        for (int i = 0; i < X; ++i) {
            winSum += customers[i];
        }
        int leftSum = 0;
        // 窗口左边缘
        int left = 1;
        // 窗口右边缘
        int right = X;
        int maxCustomer = winSum + leftSum + rightSum;
        while (right < customers.length) {
            // 重新计算左区间的值，也可以用 customer 值和 grumpy 值相乘获得
            if (grumpy[left - 1] == 0) {
                leftSum += customers[left - 1];
            }
            // 重新计算右区间值
            if (grumpy[right] == 0) {
                rightSum -= customers[right];
            }
            // 窗口值
            winSum = winSum - customers[left - 1] + customers[right];
            // 保留最大值
            maxCustomer = Math.max(maxCustomer, winSum + leftSum + rightSum);
            // 移动窗口
            left++;
            right++;
        }
        return maxCustomer;
    }


}
