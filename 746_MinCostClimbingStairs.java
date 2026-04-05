class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int a = 0, b = 0;
        for (int i = 2; i <= cost.length; i++) {
            int tmp = Math.min(a + cost[i - 2], b + cost[i - 1]);
            a = b;
            b = tmp;
        }
        return b;
    }
}