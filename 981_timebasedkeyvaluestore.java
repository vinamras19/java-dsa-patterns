import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TimeMap {
    private Map<String, List<int[]>> mapTime;
    private Map<String, List<String>> mapValue;

    public TimeMap() {
        mapTime = new HashMap<>();
        mapValue = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        mapTime.computeIfAbsent(key, k -> new ArrayList<>()).add(new int[]{timestamp});
        mapValue.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }

    public String get(String key, int timestamp) {
        if (!mapTime.containsKey(key)) {
            return "";
        }

        List<int[]> times = mapTime.get(key);
        List<String> values = mapValue.get(key);

        int left = 0;
        int right = times.size() - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (times.get(mid)[0] <= timestamp) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result == -1 ? "" : values.get(result);
    }
}