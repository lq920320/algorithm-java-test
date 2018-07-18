package utils;

import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;

/**
 * @author liuqian
 * @date 2018/7/18 12:58
 * <p>
 * 检查一个对象中属性值是否为空
 */
class FieldCheckUtils {
  /**
   * 检查对象中所有字段是否存在空
   *
   * @param obj 需要检查的对象
   * @return 结果
   */
  static boolean fieldHasNull(Object obj) {
    if (obj == null) {
      return true;
    }
    Field[] fields = FieldUtils.getAllFields(obj.getClass());
    for (Field field : fields) {
      try {
        // 设置属性是可以访问的(私有的也可以)，不做检查 直接取值
        field.setAccessible(true);
        if (isNull(field.get(obj))) {
          return true;
        }
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
    }
    return false;
  }

  /**
   * 检查对象中所有字段是否都有值
   *
   * @param obj 需要检查的对象
   * @return 结果
   */
  static boolean fieldHasNoneNull(Object obj) {
    return !fieldHasNull(obj);
  }

  private static boolean isNull(String str) {
    return str == null || "".equals(str.trim()) || "null".equals(str.toLowerCase());
  }

  private static boolean isNull(Object obj) {
    return obj == null || isNull(obj.toString());
  }

}
