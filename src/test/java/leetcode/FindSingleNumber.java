package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuqian
 * @date 2019/3/27 21:23.
 */
public class FindSingleNumber {

  /**
   * #136 只出现一次的数字
   * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
   * <p>
   * 说明：
   * <p>
   * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
   * <p>
   * 示例 1:
   * <p>
   * 输入: [2,2,1]
   * 输出: 1
   * <p>
   * 示例 2:
   * <p>
   * 输入: [4,1,2,1,2]
   * 输出: 4
   */
  @Test
  public void findSingleNumberTest() {
    int[] nums1 = {2, 2, 1};
    int[] nums2 = {4, 1, 2, 1, 2};
    Assert.assertEquals(1, solution(nums1));
    Assert.assertEquals(4, solution(nums2));

    Assert.assertEquals(1, solution1(nums1));
    Assert.assertEquals(4, solution1(nums2));
  }

  /**
   * 与或运算
   *
   * @param nums 数组
   * @return 结果
   */
  private int solution(int[] nums) {
    int res = 0;
    for (int num : nums) {
      res ^= num;
    }
    return res;
  }

  /**
   * HashMap
   *
   * @param nums 数组
   * @return 结果
   */
  private int solution1(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      if (map.containsKey(num)) {
        map.remove(num);
      } else {
        map.put(num, 1);
      }
    }
    return map.entrySet().iterator().next().getKey();
  }


  /**
   * Java 中的与运算、或运算、与或运算
   * <p>
   * 都是先将数字转为二进制数，再进行运算
   */
  @Test
  public void logicCalculateInJava() {
    int number1 = 6; //  0110
    int number2 = 12; // 1100
    int number3 = 6; //  0110

    int number4 = 5; //  0101
    int number5 = 12; // 1100
    int number6 = 5; //  0101

    // 与运算 &  规则 ：都为1时才为1
    System.out.println("********与运算******************");
    System.out.println(number1 & number2);  // 4 --> 0100
    System.out.println(number1 & number3);  // 6 --> 0110
    System.out.println(number2 & number1);  // 4 --> 0100
    System.out.println("-------------------------------");
    System.out.println(number4 & number5);  // 4 --> 0100
    System.out.println(number4 & number6);  // 5 --> 0101
    System.out.println(number5 & number4);  // 4 --> 0100

    // 或运算 | 规则：有一个为1，则为1
    System.out.println("********或运算******************");
    System.out.println(number1 | number2);  // 14 --> 1110
    System.out.println(number1 | number3);  // 6 --> 0110
    System.out.println(number2 | number1);  // 14 --> 1110
    System.out.println("-------------------------------");
    System.out.println(number4 | number5);  // 13 --> 1101
    System.out.println(number4 | number6);  // 5 --> 0101
    System.out.println(number5 | number4);  // 13 --> 1101

    // 异或运算 ^ 规则：不同为1. 任何值与0异或都是其本身, 两个相同的数字异或为0
    System.out.println("********异或运算****************");
    System.out.println(number1 ^ number2);  // 10 --> 1010
    System.out.println(number1 ^ number3);  // 0 --> 0000
    System.out.println(number2 ^ number1);  // 10 --> 1010
    System.out.println("-------------------------------");
    System.out.println(number4 ^ number5);  // 9 --> 1001
    System.out.println(number4 ^ number6);  // 0 --> 0000
    System.out.println(number5 ^ number4);  // 9 --> 1001
  }
}
