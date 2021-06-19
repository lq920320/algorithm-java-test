package leetcode.solution;

import org.junit.Test;

/**
 * #724. 寻找数组的中心下标
 * 难度：简单
 *
 * @author zetu
 * @date 2021/6/19
 */
public class FindPivotIndex {

    /**
     * #724. 寻找数组的中心下标
     * 给你一个整数数组 nums，请编写一个能够返回数组 “中心下标” 的方法。
     * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
     * 如果数组不存在中心下标，返回 -1 。如果数组有多个中心下标，应该返回最靠近左边的那一个。
     * 注意：中心下标可能出现在数组的两端。
     * <p>
     * 示例 1：
     * 输入：nums = [1, 7, 3, 6, 5, 6]
     * 输出：3
     * 解释：
     * 中心下标是 3 。
     * 左侧数之和 (1 + 7 + 3 = 11)，
     * 右侧数之和 (5 + 6 = 11) ，二者相等。
     * <p>
     * 示例 2：
     * 输入：nums = [1, 2, 3]
     * 输出：-1
     * 解释：
     * 数组中不存在满足此条件的中心下标。
     * <p>
     * 示例 3：
     * 输入：nums = [2, 1, -1]
     * 输出：0
     * 解释：
     * 中心下标是 0 。
     * 下标 0 左侧不存在元素，视作和为 0 ；
     * 右侧数之和为 1 + (-1) = 0 ，二者相等。
     * <p>
     * 提示：
     * nums 的长度范围为 [0, 10000]。
     * 任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-pivot-index
     */
    @Test
    public void solutionTest() {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums)); // 3

        int[] nums2 = {1, 2, 3};
        System.out.println(pivotIndex(nums2)); // -1

        int[] nums3 = {2, 1, -1};
        System.out.println(pivotIndex(nums3)); // 0
    }

    /**
     * 先遍历一遍求出数组的和，然后第二次遍历时，直接进行对比左半部分和右半部分是否相同，如果相同则返回 true，不同则继续遍历。
     *
     * @param nums
     * @return 下标
     */
    public int pivotIndex(int[] nums) {
        // 先算出前缀和
        int prefixSum = 0;
        for (int num : nums) {
            prefixSum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 相等的话就返回索引值
            if (leftSum == prefixSum - nums[i] - leftSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
