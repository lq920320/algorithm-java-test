package leetcode.solution;

import org.junit.Test;

/**
 * #209. 长度最小的子数组
 * 难度：中等
 *
 * @author zetu
 * @date 2021/6/6
 */
public class MinimumSizeSubarraySum {

    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     * <p>
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
     * <p>
     * 示例 1：
     * 输入：target = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     * <p>
     * 示例 2：
     * 输入：target = 4, nums = [1,4,4]
     * 输出：1
     * <p>
     * 示例 3：
     * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
     * 输出：0
     * <p>
     * 提示：
     * <p>
     * 1 <= target <= 109
     * 1 <= nums.length <= 105
     * 1 <= nums[i] <= 105
     * <p>
     * 进阶：
     * <p>
     * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
     */
    @Test
    public void solutionTest() {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        // 2
        System.out.println(minSubArrayLen(target, nums));
    }

    /**
     * 滑动窗口：就是通过不断调节子数组的起始位置和终止位置，进而得到我们想要的结果，滑动窗口也是双指针的一种。
     * <p>
     * 下面我们来看一下这道题目的做题思路，其实原理也很简单，我们创建两个指针，一个指针负责在前面探路，并不断累加遍历过的元素的值，当和大于等于我们的目标值时，后指针开始进行移动，判断去除当前值时，是否仍能满足我们的要求，直到不满足时后指针 停止，前面指针继续移动，直到遍历结束。是不是很简单呀。前指针和后指针之间的元素个数就是我们的滑动窗口的窗口大小。
     *
     * @param target
     * @param nums
     * @return len
     */
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int windowLen = Integer.MAX_VALUE;
        int i = 0;
        int sum = 0;
        for (int j = 0; j < len; ++j) {
            sum += nums[j];
            while (sum >= target) {
                windowLen = Math.min(windowLen, j - i + 1);
                sum -= nums[i];
                i++;
            }
        }
        return windowLen == Integer.MAX_VALUE ? 0 : windowLen;
    }
}
