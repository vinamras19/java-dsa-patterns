class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(
                helper(nums, 0, nums.length - 2),
                helper(nums, 1, nums.length - 1)
        );
    }

    private int helper(int[] nums, int lo, int hi) {
        int prev2 = 0, prev1 = 0;
        for (int i = lo; i <= hi; i++) {
            int tmp = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = tmp;
        }
        return prev1;
    }
}