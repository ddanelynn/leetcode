import java.util.*;

class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new arrayComparator());

        int count = 0;
        int preEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= preEnd) {
                preEnd = intervals[i][1];
            } else {
                count++;
                preEnd = Math.min(intervals[i][1], preEnd);
            }
        }
        return count;
    }

    static class arrayComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        }
    }
}