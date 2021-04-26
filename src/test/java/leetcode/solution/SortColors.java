package leetcode.solution;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zetu
 * @date 2021/4/26
 */
public class SortColors {

    /**
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * <p>
     * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [2,0,2,1,1,0]
     * 输出：[0,0,1,1,2,2]
     * 示例 2：
     * <p>
     * 输入：nums = [2,0,1]
     * 输出：[0,1,2]
     * 示例 3：
     * <p>
     * 输入：nums = [0]
     * 输出：[0]
     * 示例 4：
     * <p>
     * 输入：nums = [1]
     * 输出：[1]
     * <p>
     * 提示：
     * n == nums.length
     * 1 <= n <= 300
     * nums[i] 为 0、1 或 2
     * <p>
     * 进阶：
     * <p>
     * 你可以不使用代码库中的排序函数来解决这道题吗？
     * 你能想出一个仅使用常数空间的一趟扫描算法吗？
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sort-colors
     */
    @Test
    public void sortColorsTest() {
        int[] nums1 = {2, 0, 2, 1, 1, 0};
        System.out.println("排序前：" + Arrays.toString(nums1));
        sortColor(nums1);
        System.out.println("排序后：" + Arrays.toString(nums1));
        int[] nums2 = {2, 2, 2, 1, 1, 0};
        System.out.println("排序前：" + Arrays.toString(nums2));
        sortColor2(nums2);
        System.out.println("排序后：" + Arrays.toString(nums2));
        int[] nums3 = {2, 1, 2};
        System.out.println("排序前：" + Arrays.toString(nums3));
        sortColor2(nums3);
        System.out.println("排序后：" + Arrays.toString(nums3));
    }

    /**
     * 一共有 3 个数字，分别是 0，1，2 那么我们就可以把 1 当作中间值，切分数组为三部分，
     * 0 放在 1 之前，2 放在 1 之后
     *
     * @param nums
     * @return
     */
    public void sortColor(int[] nums) {
        int len = nums.length;
        int left = 0;
        // 这里和三向切分不完全一致
        int i = left;
        int right = len - 1;

        while (i <= right) {
            if (nums[i] == 2) {
                swap(nums, i, right--);
            } else if (nums[i] == 0) {
                swap(nums, i++, left++);
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 优化对应的解法
     *
     * @param nums
     */
    public void sortColor2(int[] nums) {
        int left = 0;
        int len = nums.length;
        int right = len - 1;
        for (int i = 0; i <= right; ++i) {
            if (nums[i] == 0) {
                swap(nums, i, left);
                left++;
            }
            if (nums[i] == 2) {
                swap(nums, i, right);
                right--;
                // 如果不等于 1 则需要继续判断，所以不移动 i 指针，i--
                if (nums[i] != 1) {
                    i--;
                }
            }
        }
    }
}
