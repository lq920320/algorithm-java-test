package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author liuqian
 * @date 2018/8/7 22:09.
 * <p>
 * tag: Easy
 */
public class LongestCommonPrefix {

  /**
   * 编写一个函数来查找字符串数组中的最长公共前缀。
   * <p>
   * 如果不存在公共前缀，返回空字符串 ""。
   * <p>
   * 示例 1:
   * <p>
   * 输入: ["flower","flow","flight"]
   * 输出: "fl"
   * 示例 2:
   * <p>
   * 输入: ["dog","racecar","car"]
   * 输出: ""
   * 解释: 输入不存在公共前缀。
   * 说明:
   * <p>
   * 所有输入只包含小写字母 a-z 。
   */
  @Test
  public void longestCommonPrefixTest() {
    String[] strs = new String[]{"flower", "flight", "flow"};
    System.out.println(longestCommonPrefix(strs));
    strs = new String[]{"dog", "racecar", "car"};
    System.out.println(longestCommonPrefix(strs));
    strs = new String[]{"apple", "air", "all", "alert"};
    System.out.println(longestCommonPrefix(strs));
    strs = new String[]{"flower"};
    System.out.println(longestCommonPrefix(strs));
    strs = new String[]{"flower", "flower", "flow"};
    System.out.println(longestCommonPrefix(strs));
  }

  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    if (strs.length == 1) {
      return strs[0];
    }
    Arrays.sort(strs);
    String str1 = strs[0];
    String str2 = strs[strs.length - 1];
    int minLen = Math.min(str1.length(), str2.length());
    int point = 0;
    for (int i = 0; i < minLen; i++) {
      if (str1.charAt(i) != str2.charAt(i)) {
        break;
      }
      if (i == 0 || point != 0) {
        point++;
      }
    }
    if (point == 0) {
      return "";
    } else {
      return str1.substring(0, point);
    }
  }

}
