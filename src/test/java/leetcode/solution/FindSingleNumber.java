package leetcode.solution;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

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

        Assert.assertEquals(1, solution2(nums1));
        Assert.assertEquals(4, solution2(nums2));

        Assert.assertEquals(1, solution3(nums1));
        Assert.assertEquals(4, solution3(nums2));
    }

    /**
     * 异或运算
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
        if (nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.remove(num);
                continue;
            }
            map.put(num, 1);
        }
        return map.entrySet().iterator().next().getKey();
    }

    /**
     * 排序搜索法
     * 解析
     * 这个方法也是特别容易想到的，我们首先对数组进行排序，然后遍历数组，因为数组中其他数字都出现两次，只有目标值出现一次，所以则让我们的指针每次跳两步，当发现当前值和前一位不一样的情况时，返回前一位即可，当然我们需要考虑这种情况，当我们的目标值出现在数组最后一位的情况，所以当数组遍历结束后没有返回值，则我们需要返回数组最后一位.
     *
     * @param nums
     * @return
     */
    public int solution2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i += 2) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            return nums[i - 1];
        }
        return nums[nums.length - 1];
    }

    /**
     * HashSet
     * 与hashmap原理差不多
     * 这个方法也是比较容易实现的，我们利用 HashSet 来完成。HashSet 在我们刷题时出现频率是特别高的，它是基于 HashMap 来实现的，是一个不允许有重复元素的集合。那么在这个题解中，它起到什么作用呢？解题思路如下，我们依次遍历元素并与 HashSet 内的元素进行比较，如果 HashSet 内没有该元素（说明该元素第一次出现）则存入，若是 HashSet 已经存在该元素(第二次出现)，则将其从 HashSet 中去除，并继续遍历下一个元素。最后 HashSet 内剩下的则为我们的目标数。
     *
     * @param nums
     * @return
     */
    public int solution3(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            //已经存在，则去除
            if (set.contains(num)) {
                set.remove(num);
                continue;
            }
            //否则存入
            set.add(num);
        }
        return set.iterator().next();
    }


    /**
     * Java 中的与运算、或运算、异或运算
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
