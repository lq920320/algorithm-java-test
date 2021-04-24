package leetcode.solution;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * # 66. 加一
 * 难度： 简单
 *
 * @author zetu
 * @date 2021/4/24
 */
public class PlusOne {

    /**
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     * <p>
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * <p>
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：digits = [1,2,3]
     * 输出：[1,2,4]
     * 解释：输入数组表示数字 123。
     * 示例 2：
     * <p>
     * 输入：digits = [4,3,2,1]
     * 输出：[4,3,2,2]
     * 解释：输入数组表示数字 4321。
     * 示例 3：
     * <p>
     * 输入：digits = [0]
     * 输出：[1]
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= digits.length <= 100
     * 0 <= digits[i] <= 9
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/plus-one
     */
    @Test
    public void plusOneTest() {
        int[] digits1 = {4, 3, 2, 1};
        int[] digits2 = {4, 3, 2, 9};
        int[] digits3 = {9, 9, 9, 9};

        // {4, 3, 2, 2}
        System.out.println(Arrays.toString(plusOne(digits1)));
        // {4, 3, 3, 0}
        System.out.println(Arrays.toString(plusOne(digits2)));
        // {1, 0, 0, 0, 0}
        System.out.println(Arrays.toString(plusOne(digits3)));
    }

    /**
     * 根据当前位 余10来判断
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i > 0; i--) {
            digits[i] = (digits[i] + 1) % 10;
            // 如果此时某一位不为 0 ，则直接返回即可。
            if (digits[i] != 0) {
                return digits;
            }
        }
        // 对于类似 [9,9,9,9] 的情况
        int[] arr = new int[len + 1];
        arr[0] = 1;
        return arr;
    }
}
