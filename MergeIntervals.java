import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class MergeIntervals {
  public static void main(String[] args) {
    int[][] intervals = new int[][] { { 1, 4 }, { 4, 5 } };
    merge(intervals);
  }

  // public int[][] merge(int[][] intervals) {
  // if (intervals.length <= 1) {
  // return intervals;
  // }
  // Arrays.sort(intervals, new IntArrComparator());
  // ArrayList<int[]> result = new ArrayList<>();
  // int pointer = 0;
  // while (pointer < intervals.length - 1) {
  // int currStart = intervals[pointer][0];
  // int tempPointer = pointer;
  // int currEnd = intervals[pointer][1];
  // while (tempPointer < intervals.length - 1 && currEnd >= intervals[tempPointer
  // + 1][0]) {
  // currEnd = Math.max(currEnd, intervals[tempPointer + 1][1]);
  // tempPointer++;
  // }
  // pointer = tempPointer;
  // int[] newInterval = new int[2];
  // newInterval[0] = currStart;
  // newInterval[1] = currEnd;
  // result.add(newInterval);
  // pointer++;
  // }

  // if (result.get(result.size() - 1)[1] < intervals[intervals.length - 1][1]) {
  // result.add(intervals[intervals.length - 1]);
  // }

  // int[][] resultArr = new int[result.size()][2];
  // for (int i = 0; i < result.size(); i++) {
  // resultArr[i] = result.get(i);
  // }
  // return resultArr;
  // }

  public static int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, new IntArrComparator());
    int first = intervals[0][0];
    int second = intervals[0][1];
    ArrayList<int[]> resultArr = new ArrayList<>();
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] >= first && intervals[i][0] <= second) {
        second = Math.max(second, intervals[i][1]);
      } else {
        int[] pair = new int[2];
        pair[0] = first;
        pair[1] = second;
        resultArr.add(pair);
        first = intervals[i][0];
        second = intervals[i][1];
      }
    }
    int[] pair = new int[2];
    pair[0] = first;
    pair[1] = second;
    resultArr.add(pair);

    int[][] result = new int[resultArr.size()][2];
    for (int i = 0; i < resultArr.size(); i++) {
      result[i] = resultArr.get(i);
    }

    return result;
  }

  public static class IntArrComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] a, int[] b) {
      return a[0] - b[0];
    }
  }
}
