class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int h : hand) map.merge(h, 1, Integer::sum);
        while (!map.isEmpty()) {
            int first = map.firstKey();
            for (int i = 0; i < groupSize; i++) {
                int card = first + i;
                if (!map.containsKey(card)) return false;
                if (map.get(card) == 1) map.remove(card);
                else map.merge(card, -1, Integer::sum);
            }
        }
        return true;
    }
}