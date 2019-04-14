package other;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liuqian
 * @date 2019/4/14 13:47.
 * <p>
 * 在Java中如何使用Set求交集、差集、并集
 */
public class HashSetTest {

  @Test
  public void hashSetTest() {
    Set<String> result = new HashSet<>();

    Set<String> set1 = new HashSet<String>() {{
      add("One");
      add("Two");
      add("Three");
      add("Four");
      add("Five");
    }};

    Set<String> set2 = new HashSet<String>() {{
      add("Four");
      add("Five");
      add("Six");
      add("Seven");
      add("Eight");
    }};

    result.clear();
    result.addAll(set1);
    result.retainAll(set2);
    System.out.println("set1 与 set2 的交集为：" + result);

    result.clear();
    result.addAll(set1);
    result.removeAll(set2);
    System.out.println("set1 与 set2 的差集为：" + result);

    // 注： set中的元素是无序的
    result.clear();
    result.addAll(set1);
    result.addAll(set2);
    System.out.println("set1 与 set2 的差集为：" + result);
  }
}
