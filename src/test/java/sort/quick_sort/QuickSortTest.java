package sort.quick_sort;

import org.junit.Test;

/**
 * @author liuqian
 * @date 2018/3/29 10:11
 */
public class QuickSortTest {


  @Test
  public void quickSortTest() {
    System.out.println("递归实现1：");
    int[] records = {15, 10, 22, 18, 66, 80, 20, 13, 99, 32};
    System.out.print("排序前：");
    displayArray(records);
    quickSort(records, 0, 9);
    System.out.print("排序后：");
    displayArray(records);
    System.out.println("-----------------------------------------");
    System.out.println("递归实现2：");
    int[] records2 = {15, 10, 22, 18, 66, 80, 20, 13, 99, 32};
    System.out.print("排序前：");
    displayArray(records2);
    quickSort2(records2, 0, 9);
    System.out.print("排序后：");
    displayArray(records2);
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

  private void quickSort2(int[] records, int low, int high) {
    int start = low;
    int end = high;
    int key = records[start];

    while (end > start) {
      // 从后往前比较
      while (end > start && records[end] >= key) {
        // 如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
        end--;
      }
      if (records[end] < key) {
        int temp = records[end];
        records[end] = records[start];
        records[start] = temp;
      }
      // 从前往后比较
      while (end > start && records[start] <= key) {
        // 如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
        start++;
      }
      if (records[start] >= key) {
        int temp = records[start];
        records[start] = records[end];
        records[end] = temp;
      }
      // 此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
    }
    // 左边序列。第一个索引位置到关键值索引-1
    if (start > low) quickSort2(records, low, start - 1);
    // 右边序列。从关键值索引+1到最后一个
    if (end < high) quickSort2(records, end + 1, high);
  }

  private void displayArray(int[] records) {
    for (int i : records) {
      System.out.printf("%4d", i);
    }
    System.out.println();
  }
}
