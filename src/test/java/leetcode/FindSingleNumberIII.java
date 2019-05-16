package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuqian
 * @date 2019/5/16 21:54.
 */
public class FindSingleNumberIII {

  /**
   * # 260. 只出现一次的数字 III
   * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
   * <p>
   * 示例 :
   * <p>
   * 输入: [1,2,1,3,2,5]
   * 输出: [3,5]
   * <p>
   * 注意：
   * <p>
   * 1. 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
   * 2. 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
   */
  @Test
  public void findSingleNumberTest() {
    int[] nums = {1, 2, 1, 3, 2, 5};
    System.out.println(Arrays.toString(singleNumber(nums)));
  }

  /**
   * 使用Map，存储key以及出现次数
   *
   * @param nums 数组
   * @return 出现一次的数字的数组
   */
  public int[] singleNumber(int[] nums) {
    int[] result = new int[2];
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      if (map.containsKey(num)) {
        map.put(num, map.get(num) + 1);
      } else {
        map.put(num, 1);
      }
    }
    int i = 0;
    for (Integer key : map.keySet()) {
      if (map.get(key) == 1) {
        result[i] = key;
        i++;
      }
    }
    return result;
  }
}
