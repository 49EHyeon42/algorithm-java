class Solution {

    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(array -> array[0]));

        int count = 0;

        int previousEndDay = 0;

        for (int[] meeting : meetings) {
            if (previousEndDay < meeting[0]) {
                count += meeting[0] - previousEndDay - 1;
            }

            previousEndDay = Math.max(previousEndDay, meeting[1]);
        }

        return count + days - previousEndDay;
    }
}
