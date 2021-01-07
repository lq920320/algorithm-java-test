package lintcode.microsoft;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author liuqian
 * @date 2021/1/7 22:33.
 */
public class StringCompress {
    /**
     * #213 字符串压缩
     * 设计一种方法，通过给重复字符计数来进行基本的字符串压缩。
     * <p>
     * 例如，字符串 aabcccccaaa 可压缩为 a2b1c5a3 。而如果压缩后的字符数不小于原始的字符数，则返回原始的字符串。
     * <p>
     * 可以假设字符串仅包括 a-z 的字母。
     * <p>
     * 样例 1：
     * <p>
     * 输入：str = "aabcccccaaa"
     * 输出："a2b1c5a3"
     * <p>
     * 样例 2：
     * <p>
     * 输入：str = "aabbcc"
     * 输出："aabbcc"
     */
    @Test
    public void stringCompressTest() {
        String a = "aabcccccaaa";
        System.out.println("before compress: " + a);
        System.out.println("after compressed: " + solution1(a));

        String b = "aabbcc";
        System.out.println("before compress: " + b);
        System.out.println("after compressed: " + solution1(b));

    }

    /**
     * 使用 map 来记录每个字符出现的次数，最后拼接成字符串返回
     *
     * @param str
     * @return
     */
    public String solution1(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            Character key = str.charAt(i);

            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
            if (map.size() == 2) {
                Character lastKey = str.charAt(i - 1);
                sb.append(lastKey);
                sb.append(map.get(lastKey));
                map.remove(lastKey);
            }
        }

        Set<Character> keySet = map.keySet();
        for (Character key : keySet) {
            sb.append(key).append(map.get(key));
        }
        if (sb.length() >= length) {
            return str;
        }
        return sb.toString();
    }

    /**
     * 使用双指针解决
     *
     * @param str
     * @return
     */
    public String solution2(String str) {
        return "";
    }
}
