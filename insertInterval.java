import java.util.*;

public class insertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();
    
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[1] < intervals[i][0]) {
                result.add(newInterval);
                result.addAll(Arrays.asList(intervals).subList(i, intervals.length));

                int[][] resultArr = new int[result.size()][2];
                for (int j = 0; j < result.size(); j++) {
                    resultArr[j] = result.get(j);
                }
                return resultArr;

            } else if (newInterval[0] > intervals[i][1]) {
                result.add(intervals[i]);
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }  
            
        }

        result.add(newInterval);

        int[][] resultArr = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            resultArr[i] = result.get(i);
        }

        return resultArr;
    }
}
