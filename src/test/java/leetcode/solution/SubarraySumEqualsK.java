package leetcode.solution;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * # 560. 和为K的子数组
 * 难度：中等
 *
 * @author zetu
 * @date 2021/4/24
 */
public class SubarraySumEqualsK {

    /**
     * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
     * <p>
     * 示例 1 :
     * 输入:nums = [1,1,1], k = 2
     * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
     * <p>
     * 说明 :
     * 数组的长度为 [1, 20,000]。
     * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
     */
    @Test
    public void subarraySumEqualsTest() {
        int[] nums = {1, 1, 1};
        int k = 2;
        // 2
        Assert.assertEquals(2, subarraySum1(nums, k));
    }

    /**
     * 暴力解法
     * 返回和为 k 的子数组的个数，所以我们直接利用双重循环解决该题
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum1(int[] nums, int k) {
        int len = nums.length;
        int sum = 0;
        int count = 0;
        for (int i = 0; i < len; ++i) {
            for (int j = i; j < len; ++j) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
            sum = 0;
        }
        return count;
    }

    /**
     * 前缀和处理
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k) {
        // 前缀和数组
        int[] presum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            // 这里需要注意，我们的前缀和是presum[1]开始填充的
            presum[i + 1] = nums[i] + presum[i];
        }
        //统计个数
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i; j < nums.length; ++j) {
                // 注意偏移，因为我们的nums[2]到nums[4]等于presum[5]-presum[2]
                // 所以这样就可以得到nums[i,j]区间内的和
                if (presum[j + 1] - presum[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * HashMap + 前缀和处理
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum3(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        // 细节，这里需要预存前缀和为 0 的情况，会漏掉前几位就满足的情况
        // 例如输入[1,1,0]，k = 2 如果没有这行代码，则会返回0,漏掉了1+1=2，和1+1+0=2的情况
        // 输入：[3,1,1,0] k = 2时则不会漏掉
        // 因为presum[3] - presum[0]表示前面 3 位的和，所以需要map.put(0,1),垫下底
        map.put(0, 1);
        int count = 0;
        int presum = 0;
        for (int x : nums) {
            presum += x;
            // 当前前缀和已知，判断是否含有 presum - k的前缀和，那么我们就知道某一区间的和为 k 了。
            if (map.containsKey(presum - k)) {
                count += map.get(presum - k);// 获取presum-k前缀和出现次数
            }
            // 更新
            map.put(presum, map.getOrDefault(presum, 0) + 1);
        }
        return count;
    }
}
