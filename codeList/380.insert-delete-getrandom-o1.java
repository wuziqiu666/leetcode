import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
 * @lc app=leetcode.cn id=380 lang=java
 *
 * [380] O(1) 时间插入、删除和获取随机元素
 */

// @lc code=start
class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        int site = list.size();
        boolean ans = list.add(val);
        map.put(val, site);
        return ans;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int site = map.get(val);
        int val2 = list.get(list.size() - 1);
        map.put(val2, site);
        list.set(site, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int k = random.nextInt(list.size());
        return list.get(k);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such: RandomizedSet obj = new
 * RandomizedSet(); boolean param_1 = obj.insert(val); boolean param_2 = obj.remove(val); int
 * param_3 = obj.getRandom();
 */
// @lc code=end
