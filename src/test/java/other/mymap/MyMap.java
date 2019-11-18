package other.mymap;

/**
 * @author liuqian
 * @date 2019/11/17 20:39.
 */
public interface MyMap<K, V> {

    V put(K k, V v);

    V get(K k);

    interface Entry<K, V> {
        K getKey();

        V getValue();
    }
}
