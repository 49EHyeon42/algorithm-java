import java.util.ArrayList;
import java.util.List;

class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();

        int i = 0;

        for (; i < intervals.length && intervals[i][1] < newInterval[0]; i++) {
            list.add(intervals[i]);
        }

        for (; i < intervals.length && newInterval[1] >= intervals[i][0]; i++) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
        }

        list.add(newInterval);

        for (; i < intervals.length; i++) {
            list.add(intervals[i]);
        }

        return list.toArray(new int[list.size()][]);
    }
}
