package com.xuebing.algorithm.basis;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 最近最少使用算法 （FIFO）
 * @param <T>
 * @Description: 采用数组+哈希实现，使用哈希表记录数据与位置，使时间复杂度为O(1)
 */
public class LRUArray<T> {

    /**
     * 缓存容量
     */
    private final int capacity;
    /**
     * 已使用的缓存大小
     */
    private int usedCacheSize;
    /**
     * 缓存数据
     */
    private final T[] cacheData;

    /**
     * 缓存数据与位置
     */
    private Map<T, Integer> cacheDataMap;

    public LRUArray(int capacity) {
        this.capacity = capacity;
        cacheData = (T[]) new Object[capacity];
        usedCacheSize = 0;
        cacheDataMap = new HashMap<>(capacity);
    }

    /**
     * 添加数据
     * @param value 数据
     */
    public LRUArray<T> add(T value) {
        Integer valueIndex = cacheDataMap.get(value);
        // 插入数据如果存在缓存中，需要验证缓存数据容器的大小
        if (Objects.isNull(valueIndex)) {
            if (usedCacheSize < capacity) {
                moveCacheData(usedCacheSize);
                usedCacheSize++;
            } else {
                // 缓存已满，需要删除数据
                moveCacheData(usedCacheSize - 1);
                cacheDataMap.remove(cacheData[capacity - 1]);
            }
        } else {
            // 存在缓存中，需要移动到最前面
            moveCacheData(valueIndex);
        }
        cacheData[0] = value;
        cacheDataMap.put(value, 0);
        return this;
    }

    private void moveCacheData(Integer endIndex) {
        for (int i = endIndex - 1; i >= 0; i--) {
            cacheData[i + 1] = cacheData[i];
            cacheDataMap.put(cacheData[i + 1], i + 1);
        }
    }

    public LRUArray<T> del(T value) {
        Integer valueIndex = cacheDataMap.get(value);
        if (Objects.isNull(valueIndex)) {
            throw new RuntimeException("数据不存在");
        }
        cacheDataMap.remove(value);
        for (int i = valueIndex + 1; i < usedCacheSize; i++) {
            cacheData[i - 1] = cacheData[i];
            cacheDataMap.put(cacheData[i - 1], i - 1);
        }
        return this;
    }

    public void print() {
        for (T cacheData : cacheData) {
            if (Objects.isNull(cacheData)) {
                break;
            }
            System.out.print(cacheData + ":" + cacheDataMap.get(cacheData) + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUArray<Integer> lruArray = new LRUArray<>(5);
        lruArray.add(1).add(2).add(3).add(4);

        lruArray.print();

        lruArray.add(5).print();

        lruArray.add(6).print();

        lruArray.add(7).print();

        lruArray.add(4).print();

        lruArray.del(4).print();

        lruArray.add(8).print();
    }

}
