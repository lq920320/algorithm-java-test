package leetcode.solution;

import org.junit.Test;

/**
 * #35. 搜索插入的位置
 * 难度：简单
 *
 * @author zetu
 * @date 2021/6/6
 */
public class SearchInsert {

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 你可以假设数组中无重复元素。
     * <p>
     * 示例 1:
     * 输入: [1,3,5,6], 5
     * 输出: 2
     * <p>
     * 示例2:
     * 输入: [1,3,5,6], 2
     * 输出: 1
     * <p>
     * 示例 3:
     * 输入: [1,3,5,6], 7
     * 输出: 4
     * <p>
     * 示例 4:
     * 输入: [1,3,5,6], 0
     * 输出: 0
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-insert-position
     */
    @Test
    public void solutionTest() {
        int[] nums = {1, 3, 5, 6};
        int target1 = 5;
        // 2
        System.out.println(searchInsert(nums, target1));

        int target2 = 2;
        // 1
        System.out.println(searchInsert(nums, target2));

        int target3 = 7;
        // 4
        System.out.println(searchInsert(nums, target3));

        int target4 = 0;
        // 0
        System.out.println(searchInsert(nums, target4));
    }

    /**
     * 与二分查找法相似，只不过返回值改为了 left 而非 mid
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 注意循环条件
        while (left <= right) {
            // 求mid
            int mid = left + ((right - left) >> 1);
            // 查询成功
            if (target == nums[mid]) {
                return mid;
                // 右区间
            } else if (nums[mid] < target) {
                left = mid + 1;
                // 左区间
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        // 返回插入位置
        return left;
    }


}
