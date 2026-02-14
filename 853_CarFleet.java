import java.util.Arrays;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        // pair of [position, time to reach target]
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }

        // sort by position descending
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        int fleets = 0;
        double slowest = 0;

        for (double[] car : cars) {
            double time = car[1];
            if (time > slowest) {
                fleets++;
                slowest = time;
            }
        }

        return fleets;
    }
}