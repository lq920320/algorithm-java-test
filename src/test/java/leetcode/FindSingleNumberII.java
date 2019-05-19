package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuqian
 * @date 2019/4/14 14:09.
 */
public class FindSingleNumberII {

  /**
   * #137 只出现一次的数字II
   * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
   * <p>
   * 说明：
   * <p>
   * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
   * <p>
   * 示例 1:
   * <p>
   * 输入: [2,2,3,2]
   * 输出: 3
   * <p>
   * 示例 2:
   * <p>
   * 输入: [0,1,0,1,0,1,99]
   * 输出: 99
   */
  @Test
  public void findSingleNumberIITest() {
    int[] nums1 = {2, 2, 3, 2};
    int[] nums2 = {0, 1, 0, 1, 0, 1, 99};
    System.out.println(singleNumber(nums1));
    System.out.println(singleNumber(nums2));
    System.out.println(singleNumber2(nums1));
    System.out.println(singleNumber2(nums2));
  }

  /**
   * 使用Map，存储key以及出现次数
   *
   * @param nums 数组
   * @return 出现一次的数字
   */
  private int singleNumber(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      if (map.containsKey(num)) {
        map.put(num, map.get(num) + 1);
      } else {
        map.put(num, 1);
      }
    }
    for (Integer key : map.keySet()) {
      if (map.get(key) == 1) {
        return key;
      }
    }
    return 0;
  }

  /**
   * 用 one 记录到当前处理的元素为止，二进制1出现“1次”（mod 3 之后的 1）的有哪些二进制位； 用 two 记录到当前计算的变量为止，二进制1出现“2次”（mod 3 之后的 2）的有哪些二进制位。 当 one 和 two 中的某一位同时为1时表示该二进制位上1出现了3次，此时需要清零。即用二进制模拟三 进制运算。最终 one 记录的是最终结果。
   * <p>
   * 这里使用了异或、与、取反这些运算
   * 详细解析见：
   * 1. http://liadbiz.github.io/leetcode-single-number-problems-summary/
   * 2. https://leetcode.com/problems/single-number-ii/discuss/43295/detailed-explanation-and-generalization-of-the-bitwise-operation-method-for-single-numbers
   *
   * @param nums 数组
   * @return 出现一次的数字
   */
  public int singleNumber2(int[] nums) {
    int one = 0, two = 0;
    int mask;
    for (int num : nums) {
      two ^= one & num;
      one ^= num;
      mask = ~(one & two);
      one &= mask;
      two &= mask;
    }
    return one;
  }
}
