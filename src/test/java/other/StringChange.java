package other;

import org.junit.Test;

/**
 * @author liuqian
 * @date 2019/3/10 14:43.
 */
public class StringChange {

  /**
   * Java 中是值传递的
   * <p>
   * Java程序设计语言总是采用按值调用。
   * 也就是说，方法得到的是所有参数值的一个拷贝，
   * 也就是说，方法不能修改传递给它的任何参数变量的内容。
   *
   * Java中方法参数的使用情况：
   * 1. 一个方法不能修改一个基本数据类型的参数（即数值型或布尔型）
   * 2. 一个方法可以改变一个对象参数的状态
   * 3. 一个方法不能让对象参数引用一个新的对象
   */
  @Test
  public void stringChange() {
    String str = "Hello";
    changeStr(str);
    // it output "Hello"
    System.out.println(str);
  }

  private static void changeStr(String str) {
    str = "Welcome";
  }
}
