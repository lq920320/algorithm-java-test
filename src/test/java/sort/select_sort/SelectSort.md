
选择排序主要是指每一趟从待排序列中选取一个关键字最小的记录，也即第一趟从n个记录中选取关键字最小的记录，第二趟从剩下的n-1个记录中选取关键字最小的记录，直到整个序列的记录选完。
这样，由选取记录的顺序，便得到按关键字有序的序列。每一趟在n-i+1(i=1, 2, ..., n-1)个待排序记录中选取关键字最小的记录作为有序序列中第i个记录，直到全部记录排完为止。

## 简单选择排序

简单选择排序的基本思想是：首先从所有待排序的记录中选出关键字最小的记录，将它与待排序的第1个记录互相交换位置；然后从去掉最小的关键字记录后剩余的记录中，再选出关键字最小的记录，并将它与第2个记录交换位置；其余类推，直到所有记录都排完为止。

容易看出，简单选择排序的空间复杂度为O(1)。简单选择排序在最好的情况下，其元素序列已经是非递减有序序列，则不需要移动元素。
在最坏的情况下，其元素序列是按照递减排列，则在每一趟排序的过程中都需要移动元素，因此，需要移动的次数为3(n-1)。
而简单选择排序的比较次数与元素的关键字排序无关，在任何情况下，都需要进行n(n-1)/2次。因此，综合以上考虑，简单选择排序的时间复杂度为O(n²)。简单选择排序是一种不稳定的排序。



代码示例：

[Java版](https://github.com/lq920320/algorithm-java-test/blob/master/src/test/java/sort/select_sort/SelectSortTest.java)

[C语言版](https://github.com/lq920320/Hello-World/blob/master/selectSort.cppss)