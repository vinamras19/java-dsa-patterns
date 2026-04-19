class DetectSquares {
    Map<String, Integer> cnt;
    List<int[]> points;

    public DetectSquares() {
        cnt = new HashMap<>();
        points = new ArrayList<>();
    }

    public void add(int[] point) {
        String key = point[0] + "," + point[1];
        cnt.merge(key, 1, Integer::sum);
        points.add(point);
    }

    public int count(int[] point) {
        int res = 0, px = point[0], py = point[1];
        for (int[] p : points) {
            if (Math.abs(px - p[0]) != Math.abs(py - p[1]) || px == p[0]) continue;
            res += cnt.getOrDefault(px + "," + p[1], 0)
                    * cnt.getOrDefault(p[0] + "," + py, 0);
        }
        return res;
    }
}