package other;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liuqian
 * @date 2019/4/22 23:02.
 */
public class CategoryFilter {

  @Test
  public void categoryLambda() throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    System.out.println(objectMapper.writeValueAsString(getCategories()));
    // [{"id":1,"parentId":0,"children":[{"id":6,"parentId":1,"children":[{"id":13,"parentId":6,"children":null},{"id":13,"parentId":6,"children":null}]},{"id":7,"parentId":1,"children":null}]},{"id":2,"parentId":0,"children":null},{"id":3,"parentId":0,"children":[{"id":8,"parentId":3,"children":null}]},{"id":4,"parentId":0,"children":[{"id":9,"parentId":4,"children":null},{"id":10,"parentId":4,"children":null},{"id":12,"parentId":4,"children":null}]},{"id":5,"parentId":0,"children":[{"id":11,"parentId":5,"children":null}]}]

    List<DealCategory> categoryChain = getFullChain(13);
    System.out.println(objectMapper.writeValueAsString(categoryChain));
    // [{"id":13,"parentId":6,"children":null},{"id":6,"parentId":1,"children":null},{"id":1,"parentId":0,"children":null}]

    List<DealCategory> categoryChain1 = getFullChain(8);
    System.out.println(objectMapper.writeValueAsString(categoryChain1));
    // [{"id":8,"parentId":3,"children":null},{"id":3,"parentId":0,"children":null}]
  }

  private List<DealCategory> getCategories() {

    List<DealCategory> dealCategories = getAllWithoutDeleted();  // 这条语句可能是从缓存中或者是从数据库中直接拉去符合条件的数据

    List<DealCategory> roots = dealCategories.stream().filter(dealCategory -> (dealCategory.getParentId() == 0)).collect(Collectors.toList());   //  过滤出 父节点为0 所有分类
    //  过滤出所有的字节点
    List<DealCategory> subs = dealCategories.stream().filter(dealCategory -> dealCategory.getParentId() != 0).collect(Collectors.toList());

    //  对根分类进行遍历操作 -------->>>>>>>> 递归操作

    roots.forEach(root -> buildSubs(root, subs));
    return roots;
  }

  private static void buildSubs(DealCategory parent, List<DealCategory> subs) {
    List<DealCategory> children = subs.stream().filter(sub -> (sub.getParentId().equals(parent.getId()))).collect(Collectors.toList());  //  获取子节点中属于父节点的分类
    //  递归判断开始
    if (!CollectionUtils.isEmpty(children)) { //  说明是有子类
      parent.setChildren(children);   //  把该分类下的子类都构建关联关系
      children.forEach(child -> buildSubs(child, subs));//  再次递归构建
    }
  }

  private List<DealCategory> getFullChain(Integer childId) {
    List<DealCategory> dealCategories = getAllWithoutDeleted();
    List<DealCategory> categoryChain = new ArrayList<>();
    DealCategory dealCategory = dealCategories.stream().filter(category -> childId.equals(category.getId())).findFirst().orElse(null);
    if (dealCategory == null) {
      return Collections.emptyList();
    }
    categoryChain.add(dealCategory);
    Integer parentId = dealCategory.getParentId();
    while (parentId != 0) {
      Integer finalParentId = parentId;
      DealCategory parentCategory = dealCategories.stream().filter(category -> finalParentId.equals(category.getId())).findFirst().orElse(null);
      if (parentCategory != null) {
        parentId = parentCategory.getParentId();
        categoryChain.add(parentCategory);
      }
    }
    return categoryChain;
  }

  @Data
  private static class DealCategory {
    private Integer id;
    private Integer parentId;
    private List<DealCategory> children;
  }

  private List<DealCategory> getAllWithoutDeleted() {
    return new ArrayList<DealCategory>() {{
      add(new DealCategory() {{
        setId(1);
        setParentId(0);
      }});
      add(new DealCategory() {{
        setId(2);
        setParentId(0);
      }});
      add(new DealCategory() {{
        setId(3);
        setParentId(0);
      }});
      add(new DealCategory() {{
        setId(4);
        setParentId(0);
      }});
      add(new DealCategory() {{
        setId(5);
        setParentId(0);
      }});
      add(new DealCategory() {{
        setId(6);
        setParentId(1);
      }});
      add(new DealCategory() {{
        setId(7);
        setParentId(1);
      }});
      add(new DealCategory() {{
        setId(8);
        setParentId(3);
      }});
      add(new DealCategory() {{
        setId(9);
        setParentId(4);
      }});
      add(new DealCategory() {{
        setId(10);
        setParentId(4);
      }});
      add(new DealCategory() {{
        setId(11);
        setParentId(5);
      }});
      add(new DealCategory() {{
        setId(12);
        setParentId(4);
      }});
      add(new DealCategory() {{
        setId(13);
        setParentId(6);
      }});
      add(new DealCategory() {{
        setId(13);
        setParentId(6);
      }});
    }};
  }
}
