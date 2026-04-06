class Solution {
public String longestPalindrome(String s) {
    int[] res = {0, 0};
    for (int i = 0; i < s.length(); i++) {
        expand(s, i, i, res);
        expand(s, i, i + 1, res);
    }
    return s.substring(res[0], res[0] + res[1]);
}

private void expand(String s, int l, int r, int[] res) {
    while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) { l--; r++; }
    int len = r - l - 1;
    if (len > res[1]) { res[0] = l + 1; res[1] = len; }
}
}