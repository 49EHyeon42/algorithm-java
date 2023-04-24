public class Solution {

    public int solution(int[][] board) {
        int maxLength = 0;

        for (int[] ints : board) {
            if (ints[0] == 1) {
                maxLength = 1;
                break;
            }
        }

        for (int i : board[0]) {
            if (i == 1) {
                maxLength = 1;
                break;
            }
        }

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    continue;
                }

                board[i][j] = min(board[i - 1][j], board[i][j - 1], board[i - 1][j - 1]) + 1;

                if (maxLength < board[i][j]) {
                    maxLength = board[i][j];
                }
            }
        }

        return maxLength * maxLength;
    }

    private int min(int i, int j, int k) {
        return (i <= j && i <= k) ? i : (j < i && j < k) ? j : k;
    }
}
