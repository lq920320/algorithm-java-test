package other.mymap;

import org.junit.Test;

/**
 * @author liuqian
 * @date 2019/11/17 21:38.
 */
public class MyMapTest {

    @Test
    public void myMapTest() {
        MyMap<String, String> myMap = new MyHashMap<>();
        for (int i = 0; i < 500; i++) {
            myMap.put("key" + i, "value" + i);
        }

        for (int i = 0; i < 500; i++) {
            System.out.println("key" + i + ", value is : " + myMap.get("key" + i));
        }
    }
}
