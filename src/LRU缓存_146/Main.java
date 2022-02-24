package LRU缓存_146;

import sun.java2d.pipe.SolidTextRenderer;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {

    Map<Integer, Integer> map;
    int capacity;

    public LRUCache(int _capacity) {
        capacity = _capacity;
        map = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public int get(int key) {
        Integer ans = map.get(key);
        return ans == null ? -1 : ans;
    }

    public void put(int key, int value) {
        if(!map.containsKey(key) && map.size() >= capacity)
            map.remove(map.entrySet().iterator().next().getKey());
        map.put(key, value);
    }
}

public class Main {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.get(2);
        lruCache.put(2, 6);
        lruCache.get(1);
        lruCache.put(1, 5);
        lruCache.put(1, 2);
        lruCache.get(1);
        lruCache.get(2);
    }
}
