// 시간 초과
class Solution {

    public int countDays(int days, int[][] meetings) {
        boolean[] array = new boolean[days + 1];

        for (int i = 0; i < meetings.length; i++) {
            for (int j = meetings[i][0]; j <= meetings[i][1]; j++) {
                array[j] = true;
            }
        }

        int count = 0;

        for (int i = 1; i < array.length; i++) {
            if (!array[i]) {
                count++;
            }
        }

        return count;
    }
}
