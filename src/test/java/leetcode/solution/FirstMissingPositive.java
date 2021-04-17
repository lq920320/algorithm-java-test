package leetcode.solution;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author zetu
 * @date 2021/4/16
 */
public class FirstMissingPositive {

    /**
     * 41. 缺失的第一个正数 [困难]
     * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
     * <p>
     * 进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？
     * <p>
     * 示例 1：
     * 输入：nums = [1,2,0]
     * 输出：3
     * <p>
     * 示例 2：
     * 输入：nums = [3,4,-1,1]
     * 输出：2
     * <p>
     * 示例 3：
     * 输入：nums = [7,8,9,11,12]
     * 输出：1
     * <p>
     * 提示：
     * 0 <= nums.length <= 300
     * -231 <= nums[i] <= 231 - 1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/first-missing-positive
     */
    @Test
    public void firstMissingPositiveTest() {
        int[] nums1 = {1, 2, 0};
        // 3
        Assert.assertEquals(3, firstMissingPositive(nums1));

        int[] nums2 = {3, 4, -1, 1};
        // 3
        Assert.assertEquals(2, firstMissingPositive2(nums2));
    }

    /**
     * 构建一个新的正整数数组，利用数组下标来确定第一个缺失的正整数
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        // 因为是返回第一个正整数，不包括 0，所以需要长度加1，细节1
        int[] res = new int[nums.length + 1];
        // 将数组元素添加到辅助数组中
        for (int x : nums) {
            if (x > 0 && x < res.length) {
                res[x] = x;
            }
        }
        // 遍历查找,发现不一样时直接返回
        for (int i = 1; i < res.length; i++) {
            if (res[i] != i) {
                return i;
            }
        }
        // 缺少最后一个，例如 1，2，3此时缺少 4 ，细节2
        return res.length;
    }

    /**
     * 我们通过上面的例子了解这个解题思想，我们有没有办法不使用辅助数组完成呢？
     * 我们可以使用原地置换，直接在 nums 数组内，将值换到对应的索引处，与上个方法思路一致，只不过没有使用辅助数组，比较难理解
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            // 需要考虑指针移动情况，大于0，小于len+1，不等与i+1，两个交换的数相等时，防止死循环
            while (nums[i] > 0 && nums[i] < len + 1 && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        // 遍历寻找缺失的正整数
        for (int i = 0; i < len; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }

    /**
     * 交换
     *
     * @param nums
     * @param i
     * @param j
     */
    public void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
    }
}
