package other;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liuqian
 * @date 2020/4/14 10:12
 * <p>
 * 使用 sorted 根据多属性排序，注意排序的顺序性
 */
public class MultiSortedTest {


    @Test
    public void multiSortedTest() throws JsonProcessingException {
        // 根据年纪升序，根据薪水降序，得到一个有序的列表
        // 排序条件逆序设置：先排序的条件放在后面，后排序的条件放前面
        ObjectMapper objectMapper = new ObjectMapper();
        List<Worker> testWorkers = getTestDatas();
        System.out.println(objectMapper.writeValueAsString(testWorkers));
        List<Worker> sortedWorkers = testWorkers.stream()
                .sorted(Comparator.comparing(Worker::getSalary, Comparator.reverseOrder()))
                .sorted(Comparator.comparing(Worker::getAge))
                .collect(Collectors.toList());
        System.out.println(objectMapper.writeValueAsString(sortedWorkers));
    }


    private List<Worker> getTestDatas() {
        List<Worker> workers = new ArrayList<>();
        workers.add(new Worker() {{
            setId(1);
            setAge(20);
            setSalary(1000);
        }});
        workers.add(new Worker() {{
            setId(2);
            setAge(22);
            setSalary(1200);
        }});
        workers.add(new Worker() {{
            setId(3);
            setAge(20);
            setSalary(800);
        }});
        workers.add(new Worker() {{
            setId(4);
            setAge(20);
            setSalary(700);
        }});
        workers.add(new Worker() {{
            setId(5);
            setAge(22);
            setSalary(1800);
        }});
        workers.add(new Worker() {{
            setId(6);
            setAge(21);
            setSalary(1100);
        }});
        workers.add(new Worker() {{
            setId(7);
            setAge(22);
            setSalary(1600);
        }});
        workers.add(new Worker() {{
            setId(8);
            setAge(21);
            setSalary(1200);
        }});
        workers.add(new Worker() {{
            setId(9);
            setAge(20);
            setSalary(600);
        }});
        workers.add(new Worker() {{
            setId(10);
            setAge(20);
            setSalary(1200);
        }});
        workers.add(new Worker() {{
            setId(11);
            setAge(21);
            setSalary(1500);
        }});
        workers.add(new Worker() {{
            setId(12);
            setAge(20);
            setSalary(400);
        }});
        workers.add(new Worker() {{
            setId(13);
            setAge(20);
            setSalary(1100);
        }});
        workers.add(new Worker() {{
            setId(14);
            setAge(21);
            setSalary(1500);
        }});
        workers.add(new Worker() {{
            setId(15);
            setAge(21);
            setSalary(1600);
        }});
        return workers;
    }


    @Data
    private class Worker {
        /**
         * ID
         */
        private Integer id;
        /**
         * 年纪
         */
        private Integer age;
        /**
         * 薪水
         */
        private Integer salary;
    }
}