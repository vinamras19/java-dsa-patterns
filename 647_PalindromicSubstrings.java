class Solution
{
public int countSubstrings(String s)
{
    int count = 0;
    for (int i = 0; i < s.length(); i++)
    {
        count += expand(s, i, i);
        count += expand(s, i, i + 1);
    }
    return count;
}

private int expand(String s, int l, int r)
{
    int cnt = 0;
    while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r))
    {
        cnt++;
        l--; r++;
    }
    return cnt;
}
}