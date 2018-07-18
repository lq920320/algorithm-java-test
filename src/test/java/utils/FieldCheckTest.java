package utils;

import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuqian
 * @date 2018/7/18 12:59
 */
public class FieldCheckTest {

  @Test
  public void fieldCheckTest() {
    Man man1 = new Man() {{
      setName("A");
      setAge(24);
      setHigh(1.75f);
      setGender("M");
      setWeight(60.0f);
    }};
    Man man2 = new Man() {{
      setAge(24);
      setName("B");
      setGender("F");
      setWeight(45.00f);
    }};
    Man man3 = new Man() {{
      setAge(24);
      setName("C");
      setHigh(1.80f);
    }};
    Man man4 = new Man() {{
      setName("D");
      setAge(24);
    }};
    Man man5 = new Man() {{
      setName("E");
    }};
    List<Man> manList = new ArrayList<Man>() {{
      add(man1);
      add(man2);
      add(man3);
      add(man4);
      add(man5);
    }};
    manList.forEach(man -> {
      if (FieldCheckUtils.fieldHasNull(man)) {
        System.out.println(man.getName() + "  " + "has null field!");
      }
      if (FieldCheckUtils.fieldHasNoneNull(man)) {
        System.out.println(man.getName() + "  " + "has none null field!");
      }
    });

  }


  @Data
  private class Man {
    private String name;
    private Integer age;
    private Float high;
    private String gender;
    private Float weight;
  }
}
