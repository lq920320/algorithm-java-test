package other.calculator;

/**
 * 使用位运算，而不是运算符（"+"、"-"、"*"、"/"）实现一个计算器，可以计算两个32位整数简单的四则运算
 *
 * @author liuqian
 * @date 2021/1/14 21:35.
 */
public class Calculator {

    /**
     * 实现 a + b ，其中 a 与 b 均为 32 位正整数
     *
     * @param a
     * @param b
     * @return a 与 b 和
     */
    public static int add(int a, int b) {
        int sum = 0;
        // 进位
        int carry;
        while (b != 0) {
            sum = a ^ b;
            // 对应位和的进位，既然是进位，就要整体左移一位
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return sum;
    }

    /**
     * 实现 a - b，其实就是 a + (-b)，其中 a 与 b 均为 32 位正整数
     *
     * @param a
     * @param b
     * @return a - b 的差
     */
    public static int subtract(int a, int b) {
        // 引入 c = -b
        int c = add(~b, 1);

        return add(a, c);
    }


    /**
     * 实现 a * b，即将被乘数累加乘数次得到的结果，先计算绝对值累加，再求符号
     *
     * @param a
     * @param b
     * @return
     */
    public static int multiply(int a, int b) {
        // 将乘数和被被乘数都取绝对值
        int multiplier = a < 0 ? add(~a, 1) : a;
        int multiplicand = b < 0 ? add(~b, 1) : b;

        // 计算绝对值的乘积
        int product = 0;
        int count = 0;

        while (count < multiplier) {
            product = add(product, multiplicand);
            count = add(count, 1);
        }

        // 计算乘积的符号
        if ((a ^ b) < 0) {
            product = add(~product, 1);
        }
        return product;
    }

    /**
     * 我们把累加的过程进行一下优化
     *
     * @param a
     * @param b
     * @return
     */
    public static int multiplyEx(int a, int b) {
        // 将乘数和被被乘数都取绝对值
        int multiplier = a < 0 ? add(~a, 1) : a;
        int multiplicand = b < 0 ? add(~b, 1) : b;

        // 计算绝对值的乘积
        int product = 0;

        while (multiplier > 0) {
            if ((multiplier & 0x1) == 1) {
                product = add(product, multiplicand);
            }
            multiplicand = multiplicand << 1;
            multiplier = multiplier >> 1;
        }

        // 计算乘积的符号
        if ((a ^ b) < 0) {
            product = add(~product, 1);
        }
        return product;
    }

    /**
     * 计算 a / b 的值，即不停地用除数去减被除数，直到被除数小于除数时，此时所减的数就是我们需要的商，而此时的被除数就是余数。注意符号。
     *
     * @param a
     * @param b
     * @return
     */
    public static int divide(int a, int b) {
        // 对被除数和除数去绝对值
        int dividend = a < 0 ? add(~a, 1) : a;
        int divisor = b < 0 ? add(~b, 1) : b;

        // 对被除数和除数的绝对值求商
        int remainder = dividend;
        int quotient = 0;

        while (remainder >= divisor) {
            remainder = subtract(remainder, divisor);
            quotient = add(quotient, 1);
        }

        // 求商的符号
        if ((a ^ b) < 0) {
            quotient = add(~quotient, 1);
        }

        return quotient;
    }

    //求余
    public static int remainder(int a, int b) {
        //对被除数和除数取绝对值
        int dividend = a < 0 ? add(~a, 1) : a;
        int divisor = b < 0 ? add(~b, 1) : b;

        //对被除数和除数的绝对值求商
        int remainder = dividend;
        int quotient = 0;

        while (remainder >= divisor) {
            remainder = subtract(remainder, divisor);
            quotient = add(quotient, 1);
        }
        //求余的符号
        if (a < 0) {
            remainder = add(~remainder, 1);
        }

        return remainder;
    }




}
