class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int remain, int start, List<Integer> cur, List<List<Integer>> res) {
        if (remain == 0) { res.add(new ArrayList<>(cur)); return; }
        if (remain < 0) return;
        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            backtrack(nums, remain - nums[i], i, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}