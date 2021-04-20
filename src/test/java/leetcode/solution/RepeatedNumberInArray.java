package leetcode.solution;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * 难度：简单
 *
 * @author zetu
 * @date 2021/4/19
 */
public class RepeatedNumberInArray {

    /**
     * 找出数组中重复的数字。
     * <p>
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     * <p>
     * 示例 1：
     * <p>
     * 输入：
     * [2, 3, 1, 0, 2, 5, 3]
     * 输出：2 或 3
     * <p>
     * 限制：
     * 2 <= n <= 100000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
     */
    @Test
    public void repeatedNumberInArrayTest() {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        // 2
        Assert.assertEquals(2, findRepeatNumber1(nums));
        // 2
        Assert.assertEquals(2, findRepeatNumber2(nums));
    }

    /**
     * 直接使用 HashSet 完成重复数字筛选
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    /**
     * 长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内，那么我们可以使用数组下标来解决问题，
     * 把 nums[i] 放到 nums[nums[i]] 的位置上去
     * <p>
     * 原地置换
     * 解析
     * 这一种方法也是我们经常用到的，主要用于重复出现的数，缺失的数等题目中，下面我们看一下这个原地置换法，
     * 原地置换的大体思路就是将我们指针对应的元素放到属于他的位置（索引对应的地方）。
     * 我们可以这样理解，每个人都有自己的位置，我们需要和别人调换回到属于自己的位置，调换之后，
     * 如果发现我们的位置上有人了，则返回。
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber2(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; ++i) {
            while (nums[i] != i) {
                // 发现重复元素
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                // 置换，将指针下的元素换到属于他的索引处
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
