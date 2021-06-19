package leetcode.solution;

import org.junit.Test;

import java.util.HashMap;

/**
 * #523. 连续的子数组和
 * 难度：中等
 *
 * @author zetu
 * @date 2021/6/19
 */
public class ContinuousSubarraySum {

    /**
     * #523. 连续的子数组和
     * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
     * 子数组大小 至少为 2 ，且
     * 子数组元素总和为 k 的倍数。
     * 如果存在，返回 true ；否则，返回 false 。
     * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。
     * <p>
     * 示例 1：
     * 输入：nums = [23,2,4,6,7], k = 6
     * 输出：true
     * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
     * <p>
     * 示例 2：
     * 输入：nums = [23,2,6,4,7], k = 6
     * 输出：true
     * 解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。
     * 42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
     * <p>
     * 示例 3：
     * 输入：nums = [23,2,6,4,7], k = 13
     * 输出：false
     * <p>
     * 提示：
     * 1 <= nums.length <= 10^5
     * 0 <= nums[i] <= 10^9
     * 0 <= sum(nums[i]) <= 2^31 - 1
     * 1 <= k <= 2^31 - 1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/continuous-subarray-sum
     */
    @Test
    public void solutionTest() {
        int[] nums = {23, 2, 4, 6, 7};
        System.out.println(checkSubarraySum(nums, 6)); // true
    }

    /**
     * 前缀和 + HashMap
     *
     * @param nums
     * @param k
     * @return {@link boolean}
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        // 余数与索引的 map，当key(余数)为0时的索引
        HashMap<Integer, Integer> map = new HashMap<>();
        // 细节2
        map.put(0, -1);
        int presum = 0;
        for (int i = 0; i < nums.length; ++i) {
            presum += nums[i];
            // 细节1，防止 k 为 0 的情况
            int key = k == 0 ? presum : presum % k;
            if (map.containsKey(key)) {
                if (i - map.get(key) >= 2) {
                    return true;
                }
                // 因为我们需要保存最小索引，当已经存在时则不用再次存入，不然会更新索引值
                continue;
            }
            map.put(key, i);
        }
        return false;
    }
}
