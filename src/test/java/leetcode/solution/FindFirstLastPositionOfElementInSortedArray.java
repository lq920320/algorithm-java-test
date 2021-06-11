package leetcode.solution;

import org.junit.Test;

import java.util.Arrays;

/**
 * #34. 在排序数组中查找元素的第一个和最后一个位置
 * 难度：中等
 *
 * @author zetu
 * @date 2021/6/10
 */
public class FindFirstLastPositionOfElementInSortedArray {

    /**
     * #34. 在排序数组中查找元素的第一个和最后一个位置
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     * <p>
     * 进阶：
     * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
     * <p>
     * 示例 1：
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     * <p>
     * 示例 2：
     * 输入：nums = [5,7,7,8,8,10], target = 6
     * 输出：[-1,-1]
     * <p>
     * 示例 3：
     * 输入：nums = [], target = 0
     * 输出：[-1,-1]
     * <p>
     * 提示：
     * 0 <= nums.length <= 105
     * -10^9 <= nums[i] <= 10^9
     * nums 是一个非递减数组
     * -10^9 <= target <= 10^9
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
     */
    @Test
    public void solutionTest() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange(nums, 8)));
        System.out.println(Arrays.toString(searchRange(nums, 6)));
    }

    /**
     * 二分查找
     * 我们将小于和等于合并在一起处理，当 target <= nums[mid] 时，我们都移动右指针，也就是 right = mid -1，还有一个需要注意的就是，我们计算下边界时最后的返回值为 left ，当上图结束循环时，left = 3，right = 2，返回 left 刚好时我们的下边界。我们来看一下求下边界的具体执行过程。
     *
     * @param nums   数组
     * @param target 目标值
     * @return {@link int[]} 位置
     */
    public int[] searchRange(int[] nums, int target) {
        int upper = upperBound(nums, target);
        int low = lowerBound(nums, target);
        //不存在情况
        if (upper < low) {
            return new int[]{-1, -1};
        }
        return new int[]{low, upper};
    }

    // 计算下边界
    int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // 这里需要注意，计算mid
            int mid = left + ((right - left) >> 1);
            if (target <= nums[mid]) {
                // 当目标值小于等于nums[mid]时，继续在左区间检索，找到第一个数
                right = mid - 1;
            } else if (target > nums[mid]) {
                // 目标值大于nums[mid]时，则在右区间继续检索，找到第一个等于目标值的数
                left = mid + 1;
            }
        }
        return left;
    }

    // 计算上边界
    int upperBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (target >= nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            }
        }
        return right;
    }
}
