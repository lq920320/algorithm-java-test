package leetcode.solution;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuqian
 * @date 2018/7/28 21:09.
 * <p>
 * tag: Easy
 */
public class RomanToIntTest {

  /**
   * 罗马数字包含以下七种字符：I， V， X， L，C，D 和 M。
   * <p>
   * 字符          数值
   * I             1
   * V             5
   * X             10
   * L             50
   * C             100
   * D             500
   * M             1000
   * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
   * <p>
   * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
   * <p>
   * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
   * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
   * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
   * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
   * <p>
   * 示例 1:
   * <p>
   * 输入: "III"
   * 输出: 3
   * 示例 2:
   * <p>
   * 输入: "IV"
   * 输出: 4
   * 示例 3:
   * <p>
   * 输入: "IX"
   * 输出: 9
   * 示例 4:
   * <p>
   * 输入: "LVIII"
   * 输出: 58
   * 解释: C = 100, L = 50, XXX = 30, III = 3.
   * 示例 5:
   * <p>
   * 输入: "MCMXCIV"
   * 输出: 1994
   * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
   */
  @Test
  public void romanToIntTest() {
    String romanStr1 = "III";
    String romanStr2 = "IV";
    String romanStr3 = "IX";
    String romanStr4 = "LVIII";
    String romanStr5 = "MCMXCIV";

    Assert.assertEquals(3, romanToInt(romanStr1));
    Assert.assertEquals(4, romanToInt(romanStr2));
    Assert.assertEquals(9, romanToInt(romanStr3));
    Assert.assertEquals(58, romanToInt(romanStr4));
    Assert.assertEquals(1994, romanToInt(romanStr5));

    System.out.println(romanToInt("VIII"));
    System.out.println(romanToInt("IX"));
    System.out.println(romanToInt("X"));
    System.out.println(romanToInt("XI"));

  }

  private int romanToInt(String s) {
    char[] chars = s.toCharArray();
    Map<Character, Integer> romanMap = new HashMap<Character, Integer>() {{
      put('I', 1);
      put('V', 5);
      put('X', 10);
      put('L', 50);
      put('C', 100);
      put('D', 500);
      put('M', 1000);
    }};
    int result = 0;
    int i = 0;
    while (i < chars.length) {
      if (chars[i] == 'I' && i + 1 != chars.length
        && (chars[i + 1] == 'V' || chars[i + 1] == 'X')) {
        result += (romanMap.get(chars[i + 1]) - 1);
        i += 2;
      } else if (chars[i] == 'X' && i + 1 != chars.length
        && (chars[i + 1] == 'L' || chars[i + 1] == 'C')) {
        result += (romanMap.get(chars[i + 1]) - 10);
        i += 2;
      } else if (chars[i] == 'C' && i + 1 != chars.length
        && (chars[i + 1] == 'D' || chars[i + 1] == 'M')) {
        result += (romanMap.get(chars[i + 1]) - 100);
        i += 2;
      } else {
        result += romanMap.get(chars[i]);
        i += 1;
      }
    }
    return result;
  }
}
