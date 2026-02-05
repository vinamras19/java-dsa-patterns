import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;

        for (int num : numSet) {
            // start counting if num is the start of a sequence
            if (!numSet.contains(num - 1)) {
                int length = 1;

                while (numSet.contains(num + length)) {
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}