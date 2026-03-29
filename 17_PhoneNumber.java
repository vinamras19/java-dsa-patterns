class Solution {
    private static final String[] MAP = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) return res;
        backtrack(digits, 0, new StringBuilder(), res);
        return res;
    }

    private void backtrack(String digits, int idx, StringBuilder cur, List<String> res) {
        if (idx == digits.length()) { res.add(cur.toString()); return; }
        for (char c : MAP[digits.charAt(idx) - '0'].toCharArray()) {
            cur.append(c);
            backtrack(digits, idx + 1, cur, res);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}