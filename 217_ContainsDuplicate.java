import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean containsDuplicate(int[] nums)
    {
        // Using HashSet for O(1) lookups
        Set<Integer> visited = new HashSet<>();

        for (int num : nums) {
            if (visited.contains(num)) {
                return true;
            }
            visited.add(num);
        }

        return false;
    }
}