package utils;

import lombok.Data;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuqian
 * @date 2018/7/18 12:59
 */
public class FieldCheckTest {

  @Test
  public void fieldCheckTest() {
    getManList().forEach(man -> {
      if (FieldCheckUtils.fieldHasNull(man)) {
        System.out.println(man.getName() + "  " + "has null field!");
      }
      if (FieldCheckUtils.fieldHasNoneNull(man)) {
        System.out.println(man.getName() + "  " + "has none null field!");
      }
    });

  }

  @Test
  public void getFieldTest() {
    getManList().forEach(man -> {
      // 当所有的属性都为public的时候，Class.getFields()才能获取得到，此时的fields.length才不为0
      Field[] fields = man.getClass().getFields();
      System.out.println("fields length is: " + fields.length);
      for (Field field : fields) {
        try {
          field.setAccessible(true);
          if (field.get(man) == null) {
            System.out.println(field.getName() + " is null!");
          }
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        }
      }
    });
  }


  @Data
  public class Man {
    public String name;
    public Integer age;
    public Float high;
    public String gender;
    public Float weight;
  }

  private List<Man> getManList() {
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
    return new ArrayList<Man>() {{
      add(man1);
      add(man2);
      add(man3);
      add(man4);
      add(man5);
    }};
  }
}
