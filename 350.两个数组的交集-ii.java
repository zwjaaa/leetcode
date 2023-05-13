import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=350 lang=java
 *
 * [350] 两个数组的交集 II
 */

// @lc code=start
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            if (map.containsKey(i))
                map.put(i, map.get(i) + 1);
            else
                map.put(i, 1);
        }
        int[] result = new int[nums1.length];
        int curLength = 0;
        for (int i : nums2) {
            if (map.containsKey(i)) {
                int count = map.get(i);
                result[curLength++] = i;
                if (count == 1)
                    map.remove(i);
                else
                    map.put(i, count - 1);
            }
        }
        return Arrays.copyOfRange(result, 0, curLength);
    }
}
// @lc code=end
