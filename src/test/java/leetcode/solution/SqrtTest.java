package leetcode.solution;

import org.junit.Test;

/**
 * @author liuqian
 * @date 2020/7/9 8:24
 */
public class SqrtTest {

    /**
     * 实现 int sqrt(int x) 函数。
     * <p>
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     * <p>
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 4
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: 8
     * 输出: 2
     * 说明: 8 的平方根是 2.82842...,
     *      由于返回类型是整数，小数部分将被舍去。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sqrtx
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    @Test
    public void sqrtTest() {
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(16));
        System.out.println(mySqrt(1));
        System.out.println(mySqrt(2147483647));
        System.out.println(mySqrt2(2147483647));
        System.out.println(mySqrt3(2147483647));
    }


    public int mySqrt(int x) {
        int bound = (x / 2 + 1);
        for (long i = 0; i <= bound; i++) {
            if (i * i > x) {
                return (int) i - 1;
            } else if (i * i == x) {
                return (int) i;
            }
        }
        return 0;
    }


    public int mySqrt2(int x) {
        int left = 0, right = x / 2 + 1;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                left = (int) (mid + 1);
            } else {
                right = (int) (mid - 1);
            }
        }
        return right;
    }

    public int mySqrt3(int x) {
        double pre = 0, cur = 1;
        while (Math.abs(pre - cur) >= 0.000001) {
            pre = cur;
            cur = (x + cur * cur) / (2 * cur);
        }
        return (int) pre;
    }
}