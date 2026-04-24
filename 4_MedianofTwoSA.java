class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int m = nums1.length, n = nums2.length, half = (m + n + 1) / 2;
        int lo = 0, hi = m;
        while (lo <= hi) {
            int i = (lo + hi) / 2;
            int j = half - i;
            int aLeft = i > 0 ? nums1[i - 1] : Integer.MIN_VALUE;
            int aRight = i < m ? nums1[i] : Integer.MAX_VALUE;
            int bLeft = j > 0 ? nums2[j - 1] : Integer.MIN_VALUE;
            int bRight = j < n ? nums2[j] : Integer.MAX_VALUE;
            if (aLeft > bRight) hi = i - 1;
            else if (bLeft > aRight) lo = i + 1;
            else {
                int maxLeft = Math.max(aLeft, bLeft);
                if ((m + n) % 2 == 1) return maxLeft;
                return (maxLeft + Math.min(aRight, bRight)) / 2.0;
            }
        }
        return 0;
    }
}