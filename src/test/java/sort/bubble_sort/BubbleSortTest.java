package sort.bubble_sort;

import org.junit.Test;

/**
 * @author liuqian
 * @date 2018/3/29 10:10
 */
public class BubbleSortTest {

  @Test
  public void bubbleSortTest() {
    int[] records = {53, 36, 48, 36, 60, 17, 18, 41, 99, 32};
    System.out.print("排序前：");
    displayArray(records);
    bubbleSort(records, records.length);
    System.out.print("排序后：");
    displayArray(records);
  }

  private void bubbleSort(int[] records, int n) {
    int temp;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (records[i] > records[j]) {
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
