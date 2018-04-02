package sort.quick_sort;

import org.junit.Test;

/**
 * @author liuqian
 * @date 2018/3/29 10:11
 */
public class QuickSortTest {


  @Test
  public void quickSortTest() {
    int[] records = {15, 10, 22, 18, 66, 80, 20, 13, 99, 32};
    System.out.print("排序前：");
    displayArray(records);
    quickSort(records, 0, 9);
    System.out.print("排序后：");
    displayArray(records);
  }

  private int partition(int[] records, int low, int high) {
    //固定的切分方式
    int key = records[low];
    while (low < high) {
      while (records[high] >= key && low < high) {  //从后半部分向前扫描
        high--;
      }
      records[low] = records[high];
      while (records[low] <= key && low < high) {  //从前半部分向后扫描
        low++;
      }
      records[high] = records[low];
    }
    records[high] = key;
    return high;
  }

  private void quickSort(int[] records, int start, int end) {
    int i;
    if (start < end) {
      i = partition(records, start, end);
      quickSort(records, start, i - 1);
      quickSort(records, i + 1, end);
    }
  }

  private void displayArray(int[] records) {
    for (int i : records) {
      System.out.printf("%4d", i);
    }
    System.out.println();
  }
}
