package leetcode.solution;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author zetu
 * @date 2021/4/14
 */
public class RemoveElement {

    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * <p>
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * <p>
     * <p>
     * 说明:
     * <p>
     * 为什么返回数值是整数，但输出的答案是数组呢?
     * <p>
     * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
     * <p>
     * 你可以想象内部操作如下:
     * <p>
     * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
     * int len = removeElement(nums, val);
     * <p>
     * // 在函数里修改输入数组对于调用者是可见的。
     * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
     * for (int i = 0; i < len; i++) {
     * print(nums[i]);
     * }
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [3,2,2,3], val = 3
     * 输出：2, nums = [2,2]
     * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
     * <p>
     * 示例 2：
     * <p>
     * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
     * 输出：5, nums = [0,1,4,0,3]
     * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * <p>
     * <p>
     * 提示：
     * <p>
     * 0 <= nums.length <= 100
     * 0 <= nums[i] <= 50
     * 0 <= val <= 100
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-element
     */
    @Test
    public void removeElementTest() {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        Assert.assertEquals(2, removeElement(nums, val));

        // nums = [0,1,2,2,3,0,4,2], val = 2
        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int val2 = 2;
        Assert.assertEquals(5, removeElement(nums2, val2));
    }

    /**
     * 双指针
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 0; j < nums.length; ++j) {
            if (nums[j] == val) {
                // 如果和目标值一致，则跳过，继续向后走
                continue;
            }
            // 不等于目标值时，则赋值给num[i],i++
            nums[i++] = nums[j];
        }
        return i;
    }

    /**
     * 暴力解法
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement2(int[] nums, int val) {
        //获取数组长度
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int i;
        for (i = 0; i < len; ++i) {
            //发现符合条件的情况
            if (nums[i] == val) {
                //前移一位
                for (int j = i; j < len - 1; ++j) {
                    nums[j] = nums[j + 1];
                }
                i--;
                len--;
            }
        }
        return i;
    }
}
