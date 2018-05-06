package sort.shell_sort;

import org.junit.Test;

/**
 * @author liuqian
 * @date 2018/3/29 10:11
 */
public class ShellSortTest {

  @Test
  public void shellSortTest() {
    int[] records = {39, 80, 76, 41, 13, 29, 50, 78, 30, 11, 100, 7, 41, 86};
    System.out.print("排序前：");
    displayArray(records);
    shellSort(records);
    System.out.print("排序后：");
    displayArray(records);
  }

  private void shellSort(int[] records) {
    int n = records.length;
    int jump = records.length;   // jump表示步长
    int change;              // change 为交换标志，0表示未交换，1表示交换
    int m;
    int temp;
    int k = 1;
    while (jump > 0) {
      jump = jump / 2;
      do {
        change = 0;
        for (int i = 0; i < n - jump; i++) {
          m = i + jump;
          if (records[i] > records[m]) {
            temp = records[m];
            records[m] = records[i];
            records[i] = temp;
            change = 1;
          }
        }
      } while (change == 1);
      System.out.printf("第%d趟排序结果：", k++);
      displayArray(records);
    }
  }

  private void displayArray(int[] records) {
    for (int i : records) {
      System.out.printf("%4d", i);
    }
    System.out.println();
  }

}
