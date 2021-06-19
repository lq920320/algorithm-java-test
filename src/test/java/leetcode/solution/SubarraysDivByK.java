package leetcode.solution;

import org.junit.Test;

import java.util.HashMap;

/**
 * #974. 和可被 K 整除的子数组
 * 难度：中等
 *
 * @author zetu
 * @date 2021/6/19
 */
public class SubarraysDivByK {

    /**
     * #974. 和可被 K 整除的子数组
     * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
     * <p>
     * 示例：
     * 输入：A = [4,5,0,-2,-3,1], K = 5
     * 输出：7
     * 解释：
     * 有 7 个子数组满足其元素之和可被 K = 5 整除：
     * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
     * <p>
     * 提示：
     * 1 <= A.length <= 30000
     * -10000 <= A[i] <= 10000
     * 2 <= K <= 10000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/subarray-sums-divisible-by-k
     */
    @Test
    public void solutionTest() {

    }

    /**
     * 前缀和+HashMap
     *
     * @param nums
     * @param k    被 k 整除
     * @return 子数组数量
     */
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int presum = 0;
        int count = 0;
        for (int x : nums) {
            presum += x;
            // 当前 presum 与 K的关系，余数是几，当被除数为负数时取模结果为负数，需要纠正
            int key = (presum % k + k) % k;
            //查询哈希表获取之前key也就是余数的次数
            if (map.containsKey(key)) {
                count += map.get(key);
            }
            // 存入哈希表当前key，也就是余数
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return count;
    }


    /**
     * 可以用数组，代替 map ，因为此时我们的哈希表存的是余数，余数最大也只不过是 K-1所以我们可以用固定长度 K 的数组来模拟哈希表。
     *
     * @param A
     * @param K
     * @return {@link int}
     */
    public int subarraysDivByK2(int[] A, int K) {
        int[] map = new int[K];
        map[0] = 1;
        int presum = 0;
        int count = 0;
        for (int j : A) {
            presum += j;
            // 求key
            int key = (presum % K + K) % K;
            // count添加次数，并将当前的map[key]++;
            count += map[key]++;
        }
        return count;
    }
}
