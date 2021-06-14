package leetcode.solution;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * #1438. 绝对差不超过限制的最长连续子数组
 * 难度：中等
 *
 * @author zetu
 * @date 2021/6/14
 */
public class LongestSubarray {

    /**
     * #1438. 绝对差不超过限制的最长连续子数组
     * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
     * 如果不存在满足条件的子数组，则返回 0 。
     * <p>
     * 示例 1：
     * 输入：nums = [8,2,4,7], limit = 4
     * 输出：2
     * 解释：所有子数组如下：
     * [8] 最大绝对差 |8-8| = 0 <= 4.
     * [8,2] 最大绝对差 |8-2| = 6 > 4.
     * [8,2,4] 最大绝对差 |8-2| = 6 > 4.
     * [8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
     * [2] 最大绝对差 |2-2| = 0 <= 4.
     * [2,4] 最大绝对差 |2-4| = 2 <= 4.
     * [2,4,7] 最大绝对差 |2-7| = 5 > 4.
     * [4] 最大绝对差 |4-4| = 0 <= 4.
     * [4,7] 最大绝对差 |4-7| = 3 <= 4.
     * [7] 最大绝对差 |7-7| = 0 <= 4.
     * 因此，满足题意的最长子数组的长度为 2 。
     * <p>
     * 示例 2：
     * 输入：nums = [10,1,2,4,7,2], limit = 5
     * 输出：4
     * 解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。
     * <p>
     * 示例 3：
     * 输入：nums = [4,2,2,2,4,4,2,2], limit = 0
     * 输出：3
     * <p>
     * 提示：
     * 1 <= nums.length <= 10^5
     * 1 <= nums[i] <= 10^9
     * 0 <= limit <= 10^9
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit
     */
    @Test
    public void solutionTest() {
        // nums = [8,2,4,7], limit = 4
        int[] nums1 = {8, 2, 4, 7};
        System.out.println(longestSubarray(nums1, 4)); // 2

        // nums = [10,1,2,4,7,2], limit = 5
        int[] nums2 = {10, 1, 2, 4, 7, 2};
        System.out.println(longestSubarray(nums2, 5)); // 4

        // nums = [4,2,2,2,4,4,2,2], limit = 0
        int[] nums3 = {4, 2, 2, 2, 4, 4, 2, 2};
        System.out.println(longestSubarray(nums3, 0)); // 3
    }

    /**
     * 那么我们同样可以借助双端队列，来维护一个单调递增的双端队列，来获取滑动窗口的最小值。既然知道了最大值和最小值，我们就可以判断当前窗口是否符合要求，如果符合要求则扩大窗口，不符合要求则缩小窗口，循环结束返回最大的窗口值即可。
     * <p>
     * 题解：https://github.com/chefyuan/algorithm-base/blob/main/animation-simulation/%E6%95%B0%E7%BB%84%E7%AF%87/leetcode1438%E7%BB%9D%E5%AF%B9%E5%80%BC%E4%B8%8D%E8%B6%85%E8%BF%87%E9%99%90%E5%88%B6%E7%9A%84%E6%9C%80%E9%95%BF%E5%AD%90%E6%95%B0%E7%BB%84.md
     *
     * @param nums
     * @param limit
     * @return {@link int}
     */
    public int longestSubarray(int[] nums, int limit) {
        // 滑动窗口中最大值队列
        Deque<Integer> maxdeque = new LinkedList<>();
        // 滑动窗口中最小值队列
        Deque<Integer> mindeque = new LinkedList<>();
        int len = nums.length;
        int right = 0, left = 0, maxwin = 0;

        while (right < len) {
            while (!maxdeque.isEmpty() && maxdeque.peekLast() < nums[right]) {
                maxdeque.removeLast();
            }
            while (!mindeque.isEmpty() && mindeque.peekLast() > nums[right]) {
                mindeque.removeLast();
            }
            maxdeque.addLast(nums[right]);
            mindeque.addLast(nums[right]);
            while (maxdeque.peekFirst() - mindeque.peekFirst() > limit) {
                if (maxdeque.peekFirst() == nums[left]) maxdeque.removeFirst();
                if (mindeque.peekFirst() == nums[left]) mindeque.removeFirst();
                left++;
            }
            // 保留最大窗口
            maxwin = Math.max(maxwin, right - left + 1);
            right++;
        }
        return maxwin;
    }
}
