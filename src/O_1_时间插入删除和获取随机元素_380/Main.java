package O_1_时间插入删除和获取随机元素_380;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class RandomizedSet {

    private Map<Integer, Integer> map = new HashMap<>();
    private int[] nums = new int[2 * 10_0000];
    private int idx = -1;
    Random random = new Random();

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val, ++idx);
        nums[idx] = val;
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int loc = map.remove(val);
        if(loc != idx){
            map.put(nums[idx], loc);
        }
        nums[loc] = nums[idx--];
        return true;
    }

    public int getRandom() {
        return nums[random.nextInt(idx + 1)];
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
