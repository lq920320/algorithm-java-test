package leetcode.solution;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * # 219. 存在重复元素 II
 *
 * @author zetu
 * @date 2021/4/21
 */
public class ContainDuplicateII {

    /**
     * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [1,2,3,1], k = 3
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: nums = [1,0,1,1], k = 1
     * 输出: true
     * 示例 3:
     * <p>
     * 输入: nums = [1,2,3,1,2,3], k = 2
     * 输出: false
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
     */
    @Test
    public void containDuplicateIITest() {
        int[] nums1 = {1, 2, 3, 1};
        int k = 3;
        Assert.assertTrue(containDuplicate(nums1, k));
        Assert.assertTrue(containDuplicate2(nums1, k));
    }

    /**
     * HashMap
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containDuplicate(int[] nums, int k) {
        if (nums.length <= 0) {
            return false;
        }
        // 创建一个元素和下标索引的 Map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 如果含有
            if (map.containsKey(nums[i])) {
                // 判断是否小于K，如果小于则直接返回
                int abs = Math.abs(i - map.get(nums[i]));
                if (abs <= k) {
                    // 小于则返回
                    return true;
                }
            }
            // 更新索引，此时有两种情况，不存在，或者存在时，将后出现的索引保存
            map.put(nums[i], i);
        }

        return false;
    }

    /**
     * 这个方法算是属于固定滑动窗口。我们需要维护一个长度为 K 的滑动窗口，如果窗口内含有该值，则直接返回 true，尾部进入新元素时，则将头部的元素去掉。
     * 继续查看是否含有该元素。
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containDuplicate2(int[] nums, int k) {
        if (nums.length <= 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                // 如果在 Set 中存在，返回 true
                return true;
            }
            set.add(nums[i]);
            // 如果长度超过 k，移除前面的元素，维护窗口长度
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }
}
