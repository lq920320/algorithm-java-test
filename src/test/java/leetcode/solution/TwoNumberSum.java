package leetcode.solution;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * # 1. 两数之和
 * 难度：简单
 *
 * @author liuqian
 * @date 2018/7/22 20:43.
 * <p>
 * tag: Easy
 */
public class TwoNumberSum {


    /**
     * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
     * <p>
     * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
     * <p>
     * 示例:
     * <p>
     * 给定 nums = [2, 7, 11, 15], target = 9
     * <p>
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */
    @Test
    public void twoNumberSumTest() {
        int[] nums = new int[]{3, 3};
        int target = 6;
        System.out.println(Arrays.toString(twoSumOfMe(nums, target)));
        nums = new int[]{2, 7, 11, 15};
        target = 9;
        System.out.println(Arrays.toString(twoSumOfMe(nums, target)));
    }

    /**
     * mySolution
     * 求两数之和
     *
     * @param numbers 给定数组
     * @param target  目标和
     * @return 两个数下标
     */
    public int[] twoSumOfMe(int[] numbers, int target) {
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j > i; j--) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /*****************official solutions*****************
     * 地址：https://leetcode-cn.com/articles/two-sum/
     *
     * ******/

    /**
     * 方法一：暴力法
     * 暴力法很简单。遍历每个元素 xx，并查找是否存在一个值与 target - xtarget−x 相等的目标元素。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 方法二：两遍哈希表
     * 通过以空间换取速度的方式，我们可以将查找时间从 O(n)O(n) 降低到 O(1)O(1)。
     * 哈希表正是为此目的而构建的，它支持以 近似 恒定的时间进行快速查找。我用“近似”来描述，是因为一旦出现冲突，查找用时可能会退化到 O(n)O(n)。
     * 但只要你仔细地挑选哈希函数，在哈希表中进行查找的用时应当被摊销为 O(1)O(1)。
     * <p>
     * 一个简单的实现使用了两次迭代。在第一次迭代中，我们将每个元素的值和它的索引添加到表中。
     * 然后，在第二次迭代中，我们将检查每个元素所对应的目标元素（target - nums[i]target−nums[i]）是否存在于表中。
     * 注意，该目标元素不能是 nums[i]nums[i] 本身！
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 方法三：一遍哈希表
     * 在进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。
     * 如果它存在，那我们已经找到了对应解，并立即将其返回。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
