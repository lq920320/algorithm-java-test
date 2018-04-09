package numbers.fibonacci;

import org.junit.Test;

/**
 * @author liuqian
 * @date 2018/4/5 21:24.
 */
public class FibonacciTest {

  /**
   * 输出斐波那契数列
   */
  @Test
  public void 给我一个斐波那契数列() {
    嚎("给我一个斐波那契数列");
    嚎("好！");
    int a = 1, b = 1;
    for (int i = 1; i <= 15; i++) {
      System.out.printf("%8d%8d", a, b);
      a = a + b;
      b = a + b;
      if (i % 5 == 0) {
        嚎("             换行！");
      }
    }
  }

  private void 嚎(String string) {
    System.out.println(string);
  }
}
