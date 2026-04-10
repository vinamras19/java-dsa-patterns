class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int n : nums) total += n;
        if (Math.abs(target) > total || (total + target) % 2 != 0) return 0;
        int subsetSum = (total + target) / 2;
        if (subsetSum < 0) subsetSum = -subsetSum;
        int[] dp = new int[subsetSum + 1];
        dp[0] = 1;
        for (int n : nums)
            for (int j = subsetSum; j >= n; j--)
                dp[j] += dp[j - n];
        return dp[subsetSum];
    }
}