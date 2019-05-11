package other;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.lang.System.out;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 * 关于列表去重的几种方式
 *
 * @author liuqian
 * @date 2019/5/8 21:23.
 */
public class ListDistinct {

  /**
   * 第一种，通过 Stream 的 distinct() 方法来进行去重
   */
  @Test
  public void listDistinctByStreamDistinct() throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    // 1. 对于 String 列表去重
    List<String> stringList = new ArrayList<String>() {{
      add("A");
      add("A");
      add("B");
      add("B");
      add("C");
    }};
    out.print("去重前：");
    for (String s : stringList) {
      out.print(s);
    }
    out.println();
    stringList = stringList.stream().distinct().collect(Collectors.toList());
    out.print("去重后：");
    for (String s : stringList) {
      out.print(s);
    }
    out.println();

    // 1. 对于 Student 列表去重
    List<Student> studentList = getStudentList();
    out.print("去重前：");
    out.println(objectMapper.writeValueAsString(studentList));
    studentList = studentList.stream().distinct().collect(Collectors.toList());
    out.print("去重后：");
    out.println(objectMapper.writeValueAsString(studentList));
  }

  @Test
  public void distinctByProperty1() throws JsonProcessingException {
    // 这里第一种方法我们通过新创建一个只有不同元素列表来实现根据对象某个属性去重
    ObjectMapper objectMapper = new ObjectMapper();
    List<Student> studentList = getStudentList();

    out.print("去重前        :");
    out.println(objectMapper.writeValueAsString(studentList));
    studentList = studentList.stream().distinct().collect(Collectors.toList());
    out.print("distinct去重后:");
    out.println(objectMapper.writeValueAsString(studentList));
    // 这里我们引入了两个静态方法，以及通过 TreeSet<> 来达到获取不同元素的效果
    // 1. import static java.util.stream.Collectors.collectingAndThen;
    // 2. import static java.util.stream.Collectors.toCollection;
    studentList = studentList.stream().collect(
      collectingAndThen(
        toCollection(() -> new TreeSet<>(Comparator.comparing(Student::getName))), ArrayList::new)
    );
    out.print("根据名字去重后 :");
    out.println(objectMapper.writeValueAsString(studentList));
  }

  @Test
  public void distinctByProperty2() throws JsonProcessingException {
    // 这里第二种方法我们通过过滤来实现根据对象某个属性去重
    ObjectMapper objectMapper = new ObjectMapper();
    List<Student> studentList = getStudentList();

    out.print("去重前        :");
    out.println(objectMapper.writeValueAsString(studentList));
    studentList = studentList.stream().distinct().collect(Collectors.toList());
    out.print("distinct去重后:");
    out.println(objectMapper.writeValueAsString(studentList));
    // 这里我们将 distinctByKey() 方法作为 filter() 的参数，过滤掉那些不能加入到 set 的元素
    studentList = studentList.stream().filter(distinctByKey(Student::getName)).collect(Collectors.toList());
    out.print("根据名字去重后 :");
    out.println(objectMapper.writeValueAsString(studentList));
  }

  private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
    Set<Object> seen = ConcurrentHashMap.newKeySet();
    return t -> seen.add(keyExtractor.apply(t));
  }


  @Data
  private class Student {
    private String stuNo;
    private String name;
  }

  private List<Student> getStudentList() {
    List<Student> studentList = new ArrayList<>();
    Student student1 = new Student() {{
      setStuNo("001");
      setName("Tom");
    }};
    Student student2 = new Student() {{
      setStuNo("002");
      setName("Mike");
    }};
    Student student3 = new Student() {{
      setStuNo("003");
      setName("Tom");
    }};
    Student student4 = new Student() {{
      setStuNo("004");
      setName("Julia");
    }};
    Student student5 = new Student() {{
      setStuNo("005");
      setName("Lily");
    }};

    Student student6 = new Student() {{
      setStuNo("001");
      setName("Kobe");
    }};

    studentList.add(student1);
    studentList.add(student2);
    studentList.add(student1);
    studentList.add(student3);
    studentList.add(student4);
    studentList.add(student3);
    studentList.add(student5);
    studentList.add(student4);
    studentList.add(student5);
    studentList.add(student2);

    studentList.add(student6);

    return studentList;
  }
}
