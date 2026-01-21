import java.util.HashMap;
import java.util.Map;

public class Solution
{
    public int[] twoSum(int[] nums, int target)
    {
        // map:number->index
        Map<Integer, Integer> prevMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            //complement exists in the map = pair found
            if (prevMap.containsKey(diff)) {
                return new int[]{prevMap.get(diff), i};
            }
            prevMap.put(nums[i], i);
        }
        return new int[]{};
    }
}