class Solution {

    public int minOperations(int[][] grid, int x) {
        int[] array = new int[grid.length * grid[0].length];

        int index = 0;

        for (int[] temp : grid) {
            for (int value : temp) {
                array[index++] = value;
            }
        }

        Arrays.sort(array);

        int count = 0;

        int medianValue = array[array.length / 2];
        int remainderOfMedianValue = medianValue % x;

        for (int value : array) {
            if (remainderOfMedianValue != value % x) {
                return -1;
            }

            count += Math.abs(medianValue - value) / x;
        }

        return count;
    }
}
