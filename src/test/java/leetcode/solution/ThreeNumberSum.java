package leetcode.solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * # 15. 三数之和
 * 难度：中等
 *
 * @author liuqian
 * @date 2018/7/23 21:51.
 * <p>
 * tag: Medium
 */
public class ThreeNumberSum {

    /**
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
     * 找出所有满足条件且不重复的三元组。
     * <p>
     * 注意：答案中不可以包含重复的三元组。
     * <p>
     * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     * <p>
     * 满足要求的三元组集合为：
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     */
    @Test
    public void threeNumberSumTest() {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    /**
     * 我们这个题目的哈希表解法是很容易理解的，我们首先将数组排序，排序之后我们将排序过的元素存入哈希表中，我们首先通过两层遍历，确定好前两位数字，那么我们只需要哈希表是否存在符合情况的第三位数字即可，跟暴力解法的思路类似，很容易理解，
     * <p>
     * 但是这里我们需要注意的情况就是，例如我们的例子为[-2 , 1 , 1],如果我们完全按照以上思路来的话，则会出现两个解，[-2 , 1 , 1]和[1 , 1, -2]。具体原因，确定 -2，1之后发现 1 在哈希表中，存入。确定 1 ，1 之后发现 -2 在哈希表中，存入。
     * <p>
     * 所以我们需要加入一个约束避免这种情况，那就是我们第三个数的索引大于第二个数时才存入。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException("No three sum solution");
        }
        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = length - 1;
            int sum = -nums[i];
            while (j < k) {
                if (j - 1 != i && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                if (k + 1 != length && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }
                if (nums[j] + nums[k] == sum) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
                if (nums[j] + nums[k] < sum) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }

    /**
     * 多指针法，先排序，然后确定左侧指针和右侧指针，移动中间指针来求和
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> arr = new ArrayList<>();
        if (nums.length < 3) {
            return arr;
        }
        //排序
        Arrays.sort(nums);
        if (nums[0] > 0) {
            return arr;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i];
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    // 存入符合要求的值
                    arr.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                    // 这里需要注意顺序
                    while (l < r && nums[l] == nums[l + 1])
                        l++;
                    while (l < r && nums[r] == nums[r - 1])
                        r--;
                    l++;
                    r--;
                } else if (nums[l] + nums[r] > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return arr;
    }
}
