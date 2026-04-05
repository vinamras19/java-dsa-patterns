class Solution {
    public int rob(int[] nums) {
        int prev2 = 0, prev1 = 0;
        for (int n : nums) {
            int tmp = Math.max(prev1, prev2 + n);
            prev2 = prev1;
            prev1 = tmp;
        }
        return prev1;
    }
}