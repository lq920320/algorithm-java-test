package dynamic_programming.edit_distance;

import org.junit.Test;

/**
 * @author liuqian
 * @date 2018/4/4 17:27
 */
public class EditDistanceTest {

  @Test
  public void editDistanceTest() {
    String str1 = "abcdef";
    String str2 = "wbcdek";
    System.out.println("两个字符串的编辑距离为：" + getDistance(str1, str2));

    String str3 = "这是一首简单的小情歌";
    String str4 = "这是一手简单的小禽歌";
    System.out.println("两个字符串的编辑距离为：" + getDistance(str3, str4));
  }

  /**
   * 输入两个字符串，返回这两个字符串的编辑距离
   */
  private static int getDistance(String strA, String strB) {
    int distance = -1;
    /*输入参数合法性检查*/
    if (null == strA || null == strB || strA.isEmpty() || strB.isEmpty()) {
      return distance;
    }
    /*两个字符串相等，编辑距离为0*/
    if (strA.equals(strB)) {
      return 0;
    }
    System.out.println("第一个字符串：" + strA);
    System.out.println("第二个字符串：" + strB);
    int lengthA = strA.length();
    int lengthB = strB.length();
    int length = Math.max(lengthA, lengthB);
    /*申请一个二维数组，存储转移矩阵*/
    int array[][] = new int[length + 1][length + 1];
    /*边界条件初始化*/
    for (int i = 0; i <= length; i++) {
      array[i][0] = i;

    }
    /*边界条件初始化*/
    for (int j = 0; j <= length; j++) {
      array[0][j] = j;
    }
    /*状态转移方程*/
    for (int i = 1; i <= lengthA; i++) {
      for (int j = 1; j <= lengthB; j++) {
        array[i][j] = min(array[i - 1][j] + 1,
          array[i][j - 1] + 1,
          array[i - 1][j - 1] + (strA.charAt(i - 1) == strB.charAt(j - 1) ? 0 : 1));
      }
    }
    /*打印转移表格*/
    System.out.println("状态转移表格：");
    for (int i = 0; i <= lengthA; i++) {
      for (int j = 0; j <= lengthB; j++) {
        System.out.printf("%4d", array[i][j]);
      }
      System.out.println();
    }
    return array[lengthA][lengthB];
  }

  /*取三个数中的最小值*/
  private static int min(int a, int b, int c) {
    return Math.min(Math.min(a, b), c);
  }


}
