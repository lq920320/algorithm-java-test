package other;

import org.junit.Test;

/**
 * @author liuqian
 * @date 2019/3/10 14:43.
 */
public class StringChange {

  private static String str = "";

  @Test
  public void stringChange() {
    str = "Hello";
    changeStr(str);
    // it output "Hello"
    System.out.println(str);
  }

  private static void changeStr(String str) {
    str = "Welcome";
  }
}
