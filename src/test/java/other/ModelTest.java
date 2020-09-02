package other;

import org.junit.Test;
import other.models.TestModelA;
import other.models.TestModelB;
import other.models.TestModelC;
import other.models.TestModelD;

/**
 * @author liuqian
 * @date 2020-09-02 13:35
 */
public class ModelTest {

    /**
     * lombok @Accessor(prefix = "m") 的用法
     * 忽略字段的前缀"m"
     */
    @Test
    public void modelATest() {
        TestModelA modelA = new TestModelA();
        modelA.setId(123);
        modelA.setName("A");

        System.out.println(modelA.getId());
        System.out.println(modelA.getName());
    }

    /**
     * lombok @Accessor(fluent = true) 的用法
     * 使用fluent属性，getter和setter方法的方法名都是属性名，且setter方法返回当前对象
     */
    @Test
    public void modelBTest() {
        TestModelB modelB = new TestModelB();
        modelB.id(124);
        modelB.name("B");

        System.out.println(modelB.id());
        System.out.println(modelB.name());
    }

    /**
     * lombok @Accessor(chain = true) 的用法
     * 使用chain属性，setter方法返回当前对象，且可以像一条链一样进行属性赋值
     */
    @Test
    public void modelCTest() {
        TestModelC modelC = new TestModelC();
        modelC.setId(125).setName("C");

        System.out.println(modelC.getId());
        System.out.println(modelC.getName());
    }

    /**
     * lombok @Builder 注解会使类的无参构造器失效，因此需要加上 @NoArgsConstructor @AllArgsConstructor
     * builder 构造出的结果是 类的Builder 类，需要调用 build() 方法来构造出实体
     */
    @Test
    public void ModelDTest() {
        TestModelD modelD = TestModelD.builder().id(126).name("D").build();

        System.out.println(modelD.getId());
        System.out.println(modelD.getName());

        System.out.println("-------------------------------------------------");

        TestModelD modelD1 = new TestModelD();
        modelD1.setId(127);
        modelD1.setName("D1");

        System.out.println(modelD1.getId());
        System.out.println(modelD1.getName());
    }
}
