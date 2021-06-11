package leetcode.solution;

import org.junit.Test;

/**
 * 边界值
 *
 * @author zetu
 * @date 2021/6/10
 */
public class BoundNum {

    @Test
    public void solutionTest() {
        // nums = {1,3,5,5,6,6,8,9,11} target = 7
        int[] nums = {1, 3, 5, 5, 6, 6, 8, 9, 11};
        int target = 7;

        // 找出第一个大于目标元素的索引
        System.out.println(lowBoundNum(nums, target, 0, nums.length)); // nums[6] = 8
        // 找出最后一个小于目标元素的索引
        System.out.println(upperBoundNum(nums, target, 0, nums.length)); // nums[5] = 6
    }

    /**
     * 二分查找，找出第一个大于目标元素的索引
     *
     * @param nums
     * @param target
     * @param left
     * @param right
     * @return {@link int}
     */
    public int lowBoundNum(int[] nums, int target, int left, int right) {
        while (left <= right) {
            // 求中间值
            int mid = left + ((right - left) >> 1);
            // 大于目标值的情况
            if (nums[mid] > target) {
                // 返回 mid
                if (mid == 0 || nums[mid - 1] <= target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] <= target) {
                left = mid + 1;
            }
        }
        // 所有元素都小于目标元素
        return -1;
    }

    /**
     * 二分查找，找出最后一个小于目标元素的索引
     *
     * @param nums
     * @param target
     * @param left
     * @param right
     * @return {@link int}
     */
    public int upperBoundNum(int[] nums, int target, int left, int right) {
        while (left <= right) {

            int mid = left + ((right - left) >> 1);
            // 小于目标值
            if (nums[mid] < target) {
                // 看看是不是当前区间的最后一位，如果当前小于，后面一位大于，返回当前值即可
                if (mid == right || nums[mid + 1] >= target) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] >= target) {
                right = mid - 1;
            }
        }
        // 没有查询到的情况
        return -1;
    }
}
