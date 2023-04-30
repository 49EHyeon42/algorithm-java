public class Solution {

    public int solution(int[][] triangle) {
        if (triangle.length == 1) {
            return triangle[0][0];
        }

        for (int col = 1; col < triangle.length; col++) {
            for (int row = 0; row <= col; row++) {
                if (row == 0) {
                    triangle[col][row] += triangle[col - 1][row];
                } else if (row == col) {
                    triangle[col][row] += triangle[col - 1][row - 1];
                } else {
                    triangle[col][row] += Math.max(triangle[col - 1][row - 1],
                            triangle[col - 1][row]);
                }
            }
        }

        int max = -1;

        for (int i = 0; i < triangle.length; i++) {
            if (max < triangle[triangle.length - 1][i]) {
                max = triangle[triangle.length - 1][i];
            }
        }

        return max;
    }
}
