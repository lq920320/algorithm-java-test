package other;

import org.junit.Test;

/**
 * @author liuqian
 * @date 2019/5/20 21:23.
 */
public class RightOrLeftShiftTest {
  /**
   * >> 表示右移，如果该数为正，则高位补0，若为负数，则高位补1。如：int i=10; i>>2的结果是2，移出的部分将被抛弃。
   * <p>
   * >>>表示无符号右移，也叫逻辑右移，即若该数为正，则高位补0，而若该数为负数，则右移后高位同样补0。
   */
  @Test
  public void rightShift() {
    int number1 = 10;
    System.out.println("右移前的十进制数为：" + number1);
    System.out.println("右移前的二进制数为：" + Integer.toBinaryString(number1));
    int number2 = number1 >> 2;
    System.out.println("右移后的十进制数为：" + number2);
    System.out.println("右移后的二进制数为：" + Integer.toBinaryString(number2));
    System.out.println();
    int number3 = -10;
    System.out.println("右移前的十进制数为：" + number3);
    System.out.println("右移前的二进制数为：" + Integer.toBinaryString(number3));
    int number4 = number3 >> 2;
    System.out.println("右移后的十进制数为：" + number4);
    System.out.println("右移后的二进制数为：" + Integer.toBinaryString(number4));

    System.out.println("***********************逻辑右移**********************");

    int a = 15;
    System.out.println("逻辑右移前的十进制数为：" + a);
    System.out.println("逻辑右移前的二进制数为：" + Integer.toBinaryString(a));
    int b = a >>> 2;
    System.out.println("逻辑右移后的十进制数为：" + b);
    System.out.println("逻辑右移后的二进制数为：" + Integer.toBinaryString(b));
    System.out.println();
    int c = -15;
    System.out.println("逻辑右移前的十进制数为：" + c);
    System.out.println("逻辑右移前的二进制数为：" + Integer.toBinaryString(c));
    int d = c >>> 2;
    System.out.println("逻辑右移后的十进制数为：" + d);
    System.out.println("逻辑右移后的二进制数为：" + Integer.toBinaryString(d));
  }

  @Test
  public void simpleTest() {
    // 相当于除以 2
    System.out.println(10 >> 1);
    // 相当于乘以 2
    System.out.println(10 << 1);
  }

  /**
   * << 表示左移，如果该数为正，则低位补0，若为负数，则低位补1。如：5<<2的意思为5的二进制位往左挪两位，右边补0，5的二进制位是0000 0101 ， 就是把有效值101往左挪两位就是0001 0100
   */
  @Test
  public void leftShiftTest() {
    int number1 = 5;
    System.out.println("左移前的十进制数为：" + number1);
    System.out.println("左移前的二进制数为：" + Integer.toBinaryString(number1));
    int number2 = number1 << 2;
    System.out.println("左移后的十进制数为：" + number2);
    System.out.println("左移后的二进制数为：" + Integer.toBinaryString(number2));
    System.out.println();
    int number3 = -5;
    System.out.println("左移前的十进制数为：" + number3);
    System.out.println("左移前的二进制数为：" + Integer.toBinaryString(number3));
    int number4 = number3 << 2;
    System.out.println("左移后的十进制数为：" + number4);
    System.out.println("左移后的二进制数为：" + Integer.toBinaryString(number4));
  }
}
