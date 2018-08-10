package numbers.fibonacci;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuqian
 * @date 2018/4/5 21:24.
 */
public class FibonacciTest {

  /**
   * 输出一个斐波那契数列，长度为n
   */
  @Test
  public void fibonacciTest() {
    嚎("斐波那契数列:");
    int n = 30;
    给我一个斐波那契数列(n / 2);
    System.out.println("----------------------------------------------------------------------------------");
    printFibonacciByMap(n);
  }

  private void printFibonacciByMap(int n) {
    Map<Integer, Integer> fibonacciMap = this.createFibonacciMap(n);
    for (int i = 1; i <= n; i++) {
      System.out.printf("%8d", fibonacciMap.get(i));
      if (i % 10 == 0) {
        嚎("     换行！");
      }
    }
  }

  private Map<Integer, Integer> createFibonacciMap(int n) {
    Map<Integer, Integer> fibonacciMap = new HashMap<>();
    for (int i = 1; i <= n; i++) {
      int f = 1;
      if (i > 2) {
        f = fibonacciMap.get(i - 1) + fibonacciMap.get(i - 2);
      }
      fibonacciMap.put(i, f);
    }
    return fibonacciMap;
  }

  /**
   * 输出斐波那契数列--1
   */
  private void 给我一个斐波那契数列(int m) {
    int a = 1, b = 1;
    for (int i = 1; i <= m; i++) {
      System.out.printf("%8d%8d", a, b);
      a = a + b;
      b = a + b;
      if (i % 5 == 0) {
        嚎("     换行！");
      }
    }
  }

  private void 嚎(String string) {
    System.out.println(string);
  }
}
