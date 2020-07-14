package leetcode.solution;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liuqian
 * @date 2020/7/14 23:42.
 */
public class ContainsDuplicate {

    /**
     * 给定一个整数数组，判断是否存在重复元素。
     * <p>
     * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,2,3,1]
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: [1,2,3,4]
     * 输出: false
     * 示例 3:
     * <p>
     * 输入: [1,1,1,3,3,4,3,2,4,2]
     * 输出: true
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/contains-duplicate
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    @Test
    public void containsDuplicateTest() {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(containsDuplicate(nums1)); // false
        System.out.println(containsDuplicate(nums2)); // true
        System.out.println(containsDuplicate2(nums1)); // false
        System.out.println(containsDuplicate2(nums2)); // true
        System.out.println(containsDuplicate3(nums1)); // false
        System.out.println(containsDuplicate3(nums2)); // true

    }

    /**
     * 暴力解法[超时]
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        int length = nums.length;
        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 使用 Set
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x : nums) {
            if (!set.add(x)) return true;
        }
        return false;
    }

    /**
     * 先排序，那么相同的数字应该是相邻的
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate3(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }
}
