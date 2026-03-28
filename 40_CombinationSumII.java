class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int remain, int start, List<Integer> cur, List<List<Integer>> res) {
        if (remain == 0) { res.add(new ArrayList<>(cur)); return; }
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > remain) break;
            if (i > start && nums[i] == nums[i - 1]) continue;
            cur.add(nums[i]);
            backtrack(nums, remain - nums[i], i + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}