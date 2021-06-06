package search;

import org.junit.Test;

/**
 * 二分查找
 *
 * @author zetu
 * @date 2021/6/6
 */
public class BinarySearch {

    /**
     * 二分查找
     * <p>
     * 二分查找也称折半查找（Binary Search），是一种在有序数组中查找某一特定元素的搜索算法。我们可以从定义可知，运用二分搜索的前提是数组必须是有序的，这里需要注意的是，我们的输入不一定是数组，也可以是数组中某一区间的起始位置和终止位置
     */
    @Test
    public void test() {
        int[] nums = {1, 3, 4, 5, 6, 8, 12, 14, 16};
        int target = 8;
        int left = 0;
        int right = nums.length - 1;

        System.out.println(binarySearch1(nums, target, left, right));

        System.out.println(binarySearch2(nums, target, left, right));
    }

    /**
     * 递归式写法
     *
     * @param nums
     * @param target
     * @param left
     * @param right
     * @return mid
     */
    public static int binarySearch1(int[] nums, int target, int left, int right) {
        if (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                // 查找成功
                return mid;
            } else if (nums[mid] > target) {
                // 新的区间,左半区间
                return binarySearch1(nums, target, left, mid - 1);
            } else if (nums[mid] < target) {
                // 新的区间，右半区间
                return binarySearch1(nums, target, mid + 1, right);
            }
        }
        // 不存在返回-1
        return -1;
    }

    /**
     * 非递归式写法
     *
     * @param nums
     * @param target
     * @param left
     * @param right
     * @return mid 位置
     */
    public static int binarySearch2(int[] nums, int target, int left, int right) {
        // 这里需要注意，循环条件
        while (left <= right) {
            // 这里需要注意，计算mid
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                // 这里需要注意，移动左指针
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 这里需要注意，移动右指针
                right = mid - 1;
            }
        }
        // 没有找到该元素，返回 -1
        return -1;
    }
}
