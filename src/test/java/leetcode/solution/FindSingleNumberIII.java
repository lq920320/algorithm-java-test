package leetcode.solution;

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
    System.out.println(Arrays.toString(singleNumber2(nums)));
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

  /**
   * #260 在这里把所有元素都异或，那么得到的结果就是那两个只出现一次的元素异或的结果。
   * 然后，因为这两个只出现一次的元素一定是不相同的，所以这两个元素的二进制形式肯定至少有某一位是不同的，即一个为 0 ，另一个为 1 ，现在需要找到这一位。
   * 根据异或的性质 任何一个数字异或它自己都等于 0 ，得到这个数字二进制形式中任意一个为 1 的位都是我们要找的那一位。
   * 再然后，以这一位是 1 还是 0 为标准，将数组的 n 个元素分成两部分。
   * 1. 将这一位为 0 的所有元素做异或，得出的数就是只出现一次的数中的一个
   * 2. 将这一位为 1 的所有元素做异或，得出的数就是只出现一次的数中的另一个。
   * 这样就解出题目。忽略寻找不同位的过程，总共遍历数组两次，时间复杂度为O(n)。
   * 使用位运算
   *
   * @param nums 数组
   * @return 只出现一次数字的数组
   */
  public int[] singleNumber2(int[] nums) {
    int diff = 0;
    for (int num : nums) {
      diff ^= num;
    }
    // 得到最低的有效位
    diff &= -diff;
    int[] result = new int[2];
    for (int num : nums) {
      if ((num & diff) == 0) {
        result[0] ^= num;
      } else {
        result[1] ^= num;
      }
    }
    return result;
  }
}
