class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0], curMax = 1, curMin = 1;
        for (int n : nums) {
            int tmpMax = curMax * n;
            int tmpMin = curMin * n;
            curMax = Math.max(n, Math.max(tmpMax, tmpMin));
            curMin = Math.min(n, Math.min(tmpMax, tmpMin));
            res = Math.max(res, curMax);
        }
        return res;
    }
}