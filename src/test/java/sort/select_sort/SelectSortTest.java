package sort.select_sort;

import org.junit.Test;

/**
 * @author liuqian
 * @date 2018/4/19 23:24.
 */
public class SelectSortTest {

  @Test
  public void selectSortTest() {
    int[] a = {53, 36, 48, 36, 60, 17, 18, 41};
    System.out.print("排序前：");
    displayArray(a);
    selectSort(a);
    System.out.print("排序后：");
    displayArray(a);
  }

  /**
   * 简单选择排序
   *
   * @param records
   */
  private void selectSort(int[] records) {
    int temp;
    for (int i = 0; i < records.length; i++) {
      for (int j = i + 1; j < records.length; j++) {
        if (records[j] < records[i]) {
          temp = records[i];
          records[i] = records[j];
          records[j] = temp;
        }
      }
    }
  }

  private void displayArray(int[] records) {
    for (int i : records) {
      System.out.printf("%4d", i);
    }
    System.out.println();
  }
}
