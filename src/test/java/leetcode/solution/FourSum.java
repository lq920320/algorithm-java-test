package leetcode.solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * # 18 四数之和
 * 难度：中等
 *
 * @author zetu
 * @date 2021/5/14
 */
public class FourSum {

    /**
     * # 18 四数之和
     * <p>
     * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
     * <p>
     * 注意：答案中不可以包含重复的四元组。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,0,-1,0,-2,2], target = 0
     * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
     * 示例 2：
     * <p>
     * 输入：nums = [], target = 0
     * 输出：[]
     * <p>
     * 提示：
     * <p>
     * 0 <= nums.length <= 200
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/4sum
     */
    @Test
    public void solutionTest() {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(fourSum(nums, target));

        int[] nums2 = new int[0];
        System.out.println(fourSum(nums2, 0));
    }

    /**
     * 多指针法
     * 三数之和是，我们首先确定一个数，然后利用双指针去找另外的两个数，我们在这个题目里面的解题思路是需要首先确定两个数然后利用双指针去找另外两个数，和三数之和思路基本一致很容易理解。我们具体思路可以参考下图。
     * <p>
     * 这里需要注意的是，我们的 target 不再和三数之和一样为 0 ，target 是不固定的，所以解题思路不可以完全照搬上面的题目。另外这里也需要考虑去重的情况，思路和上题一致。
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        // 存入
                        arr.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[l], nums[r])));
                        // 去重
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;
                    } else if (sum > target) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return arr;
    }
}
