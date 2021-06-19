package leetcode.solution;

import org.junit.Test;

import java.util.HashMap;

/**
 * #1248. 统计「优美子数组」
 * 难度：中等
 *
 * @author zetu
 * @date 2021/6/19
 */
public class CountNumberOfNiceSubarrays {

    /**
     * #1248. 统计「优美子数组」
     * 给你一个整数数组 nums 和一个整数 k。
     * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
     * 请返回这个数组中「优美子数组」的数目。
     * <p>
     * 示例 1：
     * 输入：nums = [1,1,2,1,1], k = 3
     * 输出：2
     * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
     * <p>
     * 示例 2：
     * 输入：nums = [2,4,6], k = 1
     * 输出：0
     * 解释：数列中不包含任何奇数，所以不存在优美子数组。
     * <p>
     * 示例 3：
     * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
     * 输出：16
     * <p>
     * 提示：
     * 1 <= nums.length <= 50000
     * 1 <= nums[i] <= 10^5
     * 1 <= k <= nums.length
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-number-of-nice-subarrays
     */
    @Test
    public void solutionTest() {
        int[] nums = {1, 1, 2, 1, 1};
        System.out.println(numberOfSubarrays(nums, 3)); // 2
    }

    /**
     * @param nums
     * @param k    k 个奇数数字
     * @return 优美子数组数量
     */
    public int numberOfSubarrays(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        // 统计奇数个数，相当于我们的 presum
        int oddnum = 0;
        int count = 0;
        map.put(0, 1);
        for (int x : nums) {
            // 统计奇数个数
            oddnum += x & 1;
            // 发现存在，则 count增加
            if (map.containsKey(oddnum - k)) {
                count += map.get(oddnum - k);
            }
            // 存入
            map.put(oddnum, map.getOrDefault(oddnum, 0) + 1);
        }
        return count;
    }

    /**
     * 我们是统计奇数的个数，数组中的奇数个数肯定不会超过原数组的长度，所以这个题目中我们可以用数组来模拟 HashMap ，用数组的索引来模拟 HashMap 的 key，用值来模拟哈希表的 value。
     *
     * @param nums
     * @param k
     * @return {@link int}
     */
    public int numberOfSubarrays2(int[] nums, int k) {
        int len = nums.length;
        int[] map = new int[len + 1];
        map[0] = 1;
        int oddnum = 0;
        int count = 0;
        for (int num : nums) {
            // 如果是奇数则加一，偶数加0，相当于没加
            oddnum += num & 1;
            if (oddnum - k >= 0) {
                count += map[oddnum - k];
            }
            map[oddnum]++;
        }
        return count;
    }

}
