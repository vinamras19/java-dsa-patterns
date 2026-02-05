import java.util.ArrayList;
import java.util.List;

class Solution {

    // Encode
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    // Decode
    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }

            // extract length and the actual string
            int length = Integer.parseInt(str.substring(i, j));
            String s = str.substring(j + 1, j + 1 + length);
            result.add(s);

            i = j + 1 + length;
        }
        return result;
    }
}