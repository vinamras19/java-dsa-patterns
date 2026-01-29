import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // frequency of each number
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        // index = Frequency and value = list of numbers with that frequency.
        List<Integer>[] buckets = new List[nums.length + 1];

        for (int key : count.keySet()) {
            int frequency = count.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        // iterate backwards
        int[] res = new int[k];
        int index = 0;

        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                for (int val : buckets[i]) {
                    res[index++] = val;
                    if (index == k) return res;
                }
            }
        }
        return res;
    }
}