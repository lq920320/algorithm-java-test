package leetcode.solution;

import org.junit.Assert;
import org.junit.Test;

/**
 * 485. 最大连续 1 的个数
 * 难度：简单
 *
 * @author zetu
 * @date 2021/4/18
 */
public class MaxConsecutiveOnes {

    /**
     * # 485. 最大连续 1 的个数
     * <p>
     * 给定一个二进制数组， 计算其中最大连续 1 的个数。
     * <p>
     *  
     * <p>
     * 示例：
     * <p>
     * 输入：[1,1,0,1,1,1]
     * 输出：3
     * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
     *  
     * <p>
     * 提示：
     * <p>
     * 输入的数组只包含 0 和 1 。
     * 输入数组的长度是正整数，且不超过 10,000。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/max-consecutive-ones
     */
    @Test
    public void maxConsecutiveOnesTest() {
        int[] nums = {1, 1, 0, 1, 1, 1};
        // 3
        Assert.assertEquals(3, maxConsecutiveOnes(nums));
        // 3
        Assert.assertEquals(3, maxConsecutiveOnes2(nums));
    }

    /**
     * 使用 Math.max 进行比较。其中遇到 0 的话就将累计的数量值清空
     *
     * @param nums
     * @return
     */
    public int maxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
                continue;
            }
            maxCount = Math.max(count, maxCount);
            count = 0;
        }

        return Math.max(count, maxCount);
    }

    /**
     * 使用双指针：利用 right 指针进行探路，如果遇到 1 则继续走，遇到零时则停下，求当前 1 的个数。
     * <p>
     * 这时我们可以通过 right - left 得到 1 的 个数，因为此时我们的 right 指针指在 0 处，
     * 所以不需要和之前一样通过 right - left + 1 获得窗口长度。
     * <p>
     * 然后我们再使用 while 循环，遍历完为 0 的情况，跳到下一段为 1 的情况，然后移动 left 指针。
     * left = right，站在同一起点，继续执行上诉过程。
     *
     * @param nums
     * @return
     */
    public int maxConsecutiveOnes2(int[] nums) {
        int left = 0, right = 0;
        int maxCount = 0;

        int len = nums.length;
        while (right < len) {
            if (nums[right] == 1) {
                right++;
                continue;
            }
            // 保存最大值
            maxCount = Math.max(maxCount, right - left);
            // 跳过 0 的情况
            while (right < len && nums[right] == 0) {
                right++;
            }
            // 同一起点继续遍历
            left = right;
        }

        return Math.max(maxCount, right - left);
    }
}
