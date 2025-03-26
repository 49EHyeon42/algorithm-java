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

        for (int value : array) {
            int difference = Math.abs(array[array.length / 2] - value);

            if (difference % x != 0) {
                return -1;
            }

            count += difference / x;
        }

        return count;
    }
}
