package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuqian
 * @date 2018/7/23 21:51.
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
      int sum = 0 - nums[i];
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
}
