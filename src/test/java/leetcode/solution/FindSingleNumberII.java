package leetcode.solution;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
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

        System.out.println(solution3(nums1));
        System.out.println(solution3(nums2));

        System.out.println(solution4(nums1));
        System.out.println(solution4(nums2));
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
     * 用 one 记录到当前处理的元素为止，二进制1出现“1次”（mod 3 之后的 1）的有哪些二进制位； 用 two 记录到当前计算的变量为止，二进制1出现“2次”（mod 3 之后的 2）的有哪些二进制位。 当 one 和 two 中的某一位同时为1时表示该二进制位上1出现了3次，此时需要清零。即用 二进制 模拟 三进制 运算。最终 one 记录的是最终结果。
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


    /**
     * 求和法 解析
     * 我们在上题中介绍了求和法的解题步骤，现在该题中其他元素都出现三次，我们的目标元素出现一次，所以我们利用求和法也是完全 OK 的。下面我们来看具体步骤吧。
     * 1.通过遍历数组获取所有元素的和以及 HashSet 内元素的和。
     * 2.（SumSet * 3 - SumNum）/ 2即可，除以 2 是因为我们减去之后得到的是 2 倍的目标元素。
     * 注：这个题目中需要注意溢出的情况 。
     *
     * @param nums
     * @return result
     */
    public int solution3(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        long sumset = 0;
        long sumnum = 0;
        for (int x : nums) {
            // 所有元素的和
            sumnum += x;
            if (set.contains(x)) {
                continue;
            }
            // HashSet元素和
            sumset += x;
            set.add(x);
        }
        // 返回只出现一次的数
        return (int) ((3 * sumset - sumnum) / 2);
    }

    /**
     * 位运算 解析
     * 这个方法主要做法是将我们的数的二进制位每一位相加，然后对其每一位的和取余 。
     * 那么我们为什么要这样做呢？大家想一下，如果其他数都出现 3 次，只有目标数出现 1 次，那么每一位的 1 的个数无非有这2种情况，为 3 的倍数（全为出现三次的数） 或 3 的倍数 +1（包含出现一次的数）。这个 3 的倍数 +1 的情况也就是我们的目标数的那一位。
     *
     * @param nums
     * @return result
     */
    public int solution4(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                // 先将数右移，并求出最后一位为 1 的个数
                if ((num >> i & 1) == 1) {
                    count++;
                }
            }
            // 找到某一位取余为 1 的数，并左移，为了将这一位循环结束后移至原位
            if (count % 3 != 0) {
                res = res | 1 << i;
            }
        }
        return res;
    }
}
