package other;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author liuqian
 * @date 2020/3/14 20:06
 */
public class SortedBySomeOrders {

    /**
     * 把数组按照一定规则进行排序
     */
    @Test
    public void sortedBySomeOrders() {
        List<Integer> sortedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> theOrders = Arrays.asList(10, 9, 8, 7);
        // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        System.out.println(sortedNumbers);
        // commonCourseTypes = commonCourseTypes.stream().sorted(Comparator.comparing(courseType ->
        //                termSortedList.indexOf(courseType.getCourseTypeId()))).collect(Collectors.toList());
        List<Integer> list = new ArrayList<>(sortedNumbers);
        list.sort(Comparator.comparing(theOrders::indexOf));
        sortedNumbers = list;
        // [1, 2, 3, 4, 5, 6, 10, 9, 8, 7]
        System.out.println(sortedNumbers);
    }
}