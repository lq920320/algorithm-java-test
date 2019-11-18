package other.mymap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuqian
 * @date 2019/11/17 20:41.
 */
public class MyHashMap<K, V> implements MyMap<K, V> {
    // 数组的默认初始化长度
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    // 阈值比例
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int defaultInitSize;
    private float defaultLoadFactor;

    // Map 中 entry 的数量
    private int entryUseSize = 0;
    // 数组
    private Entry<K, V>[] table = null;

    public MyHashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int defaultInitialCapacity, float defaultLoadFactor) {
        if (defaultInitialCapacity < 0) {
            throw new IllegalArgumentException("Illegal initial capacity: " + defaultInitialCapacity);
        }
        if (defaultLoadFactor <= 0 || Float.isNaN(defaultLoadFactor)) {
            throw new IllegalArgumentException("Illegal load factor:" + defaultLoadFactor);
        }
        this.defaultInitSize = defaultInitialCapacity;
        this.defaultLoadFactor = defaultLoadFactor;
        table = new Entry[this.defaultInitSize];
    }

    static class Entry<K, V> implements MyMap.Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> next;

        public Entry() {
        }

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }
    }

    @Override
    public V put(K k, V v) {
        V oldValue = null;
        // 是否需要扩容
        // 扩容完毕，肯定需要重新散列
        if (entryUseSize >= defaultInitSize * defaultLoadFactor) {
            resize(2 * defaultInitSize);
        }
        // 得到 Hash 值，计算出数组的位置
        int index = hash(k) & (defaultInitSize - 1);
        if (table[index] == null) {
            table[index] = new Entry<K, V>(k, v, null);
            ++entryUseSize;
        } else {
            Entry<K, V> entry = table[index];
            Entry<K, V> e = entry;
            while (e != null) {
                if (k == e.getKey() || k.equals(e.getKey())) {
                    oldValue = e.value;
                    e.value = v;
                    return oldValue;
                }
                e = e.next;
            }
            table[index] = new Entry<K, V>(k, v, entry);
            ++entryUseSize;
        }
        return oldValue;
    }

    private int hash(K k) {
        int hashCode = k.hashCode();
        hashCode ^= (hashCode >>> 20) ^ (hashCode >>> 12);
        return hashCode ^ (hashCode >>> 7) ^ (hashCode >>> 4);
    }

    private void resize(int i) {
        Entry[] newTable = new Entry[i];
        // 改变数组的大小
        defaultInitSize = i;
        entryUseSize = 0;
        rehash(newTable);
    }

    private void rehash(Entry<K, V>[] newTable) {
        // 得到原来老的 Entry 集合，注意遍历列表
        List<Entry<K, V>> entryList = new ArrayList<>();
        for (Entry<K, V> entry : table) {
            if (entry != null) {
                while (entry != null) {
                    entryList.add(entry);
                    entry = entry.next;
                }
            }
        }
        // 覆盖旧的引用
        if (newTable.length > 0) {
            table = newTable;
        }
        // 所谓重新 Hash ，就是重新 Put Entry 到 HashMap
        for (Entry<K, V> entry : entryList) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public V get(K k) {
        int index = hash(k) & (defaultInitSize - 1);
        if (table[index] == null) {
            return null;
        } else {
            Entry<K, V> entry = table[index];
            do {
                if (k == entry.getKey() || k.equals(entry.getKey())) {
                    return entry.value;
                }
                entry = entry.next;
            } while (entry != null);
        }
        return null;
    }
}
