package com.xuebing.algorithm.basis.tree;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRULinkedList<K, V> {

    /**
     * 容量
     */
    private int capacity;

    private final LinkedHashMap<K, V> cacheData;

    public LRULinkedList(int capacity) {
        this.capacity = capacity;
        cacheData = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public V get(K key) {
        return cacheData.get(key);
    }

    public LRULinkedList<K, V> add(K key, V value) {
        cacheData.put(key, value);
        return this;
    }

    public void remove(K key) {
        cacheData.remove(key);
    }

    public void clear() {
        cacheData.clear();
    }

    public void print() {
        for (Map.Entry<K, V> entry : cacheData.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue() + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRULinkedList<String, String> cache = new LRULinkedList<>(2);
        cache.add("1", "a").add("2", "b").add("3", "c");
        cache.print();

        cache.add("4", "d").print();

        cache.get("3");
        cache.print();

        cache.get("1");
        cache.print();
    }
}
