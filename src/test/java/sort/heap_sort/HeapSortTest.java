package sort.heap_sort;

import org.junit.Test;

/**
 * @author liuqian
 * @date 2018/4/9 22:56.
 */
public class HeapSortTest {

  @Test
  public void heapSortTest() {
    Integer[] array = new Integer[]{36, 25, 48, 12, 65, 43, 20, 58};
    System.out.print("排序前：");
    printArray(array);
    heapSort(array);
    System.out.print("排序后：");
    printArray(array);
  }

  private void shift(Integer[] array, int i, int m) {
    /*堆的筛选算法——在r[i]到r[m]中调整堆*/
    int j = 2 * i;
    Integer temp = array[i];
    while (j <= m) {                             /*j <= m, array[2*i]是array[i]的左孩子*/
      if ((j < m) && (array[j] < array[j + 1])) {
        j++;                                     /*j指向array[i]左右孩子中较大者*/
      }
      if (temp < array[j]) {
        array[i] = array[j];                    /*将array[j]调到父亲结点的位置*/
        i = j;                                  /*修改i和j的值，以便继续“筛结点”*/
        j = 2 * i;
      } else {
        j = m + 1;
      }
    }                                          /*调整完毕，退出循环*/
    array[i] = temp;                           /*将被筛选的结点放入正确的位置*/
  }

  private void printArray(Integer[] array) {
    for (Integer i : array) {
      System.out.printf("%4d", i);
    }
    System.out.println();
  }

  private void heapSort(Integer[] array) {
    Integer temp;
    int n = array.length;
    int i;
    for (i = (n - 1) / 2; i >= 0; i--) {      /*建立初始堆*/
      shift(array, i, n - 1);
    }
    for (i = n - 1; i >= 0; i--) {            /*进行n-1趟筛选、交换和调整*/
      temp = array[0];                        /*将堆顶元素与最后一个元素进行交换*/
      array[0] = array[i];
      array[i] = temp;
      shift(array, 0, i - 1);            /*将元素r[0]到r[i-1]重新调整为堆*/
    }
  }


}
