import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private final Queue<Character> queue = new LinkedList<>();

    private int m;
    private int n;
    private char[][] blocks;
    private int currentDeleteCount = 0;
    private int totalDeleteCount = 0;

    public int solution(int m, int n, String[] board) {
        this.m = m;
        this.n = n;

        initBlocks(board);

        while (true) {
            deleteBlocks();

            if (currentDeleteCount == 0) {
                return totalDeleteCount;
            }

            dropBlocks();
        }
    }

    private void initBlocks(String[] board) {
        char[][] newBlocks = new char[m][n];

        for (int i = 0; i < m; i++) {
            newBlocks[i] = board[i].toCharArray();
        }

        blocks = newBlocks;
    }

    private void deleteBlocks() {
        currentDeleteCount = 0;

        boolean[][] deleted = new boolean[m][n];

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (blocks[i][j] == '.') {
                    continue;
                }

                if (blocks[i][j] == blocks[i][j + 1] &&
                        blocks[i][j] == blocks[i + 1][j] &&
                        blocks[i][j] == blocks[i + 1][j + 1]) {
                    deleted[i][j] = deleted[i][j + 1] = deleted[i + 1][j] = deleted[i + 1][j + 1] = true;

                    currentDeleteCount++;
                }
            }
        }

        if (currentDeleteCount == 0) {
            return;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (blocks[i][j] != '.' && deleted[i][j]) {
                    blocks[i][j] = '.';

                    totalDeleteCount++;
                }
            }
        }
    }

    private void dropBlocks() {
        for (int j = 0; j < n; j++) {
            int count = 0;

            for (int i = 0; i < m; i++) {
                if (blocks[i][j] == '.') {
                    count++;

                    continue;
                }

                queue.offer(blocks[i][j]);
            }

            int i;

            for (i = 0; i < count; i++) {
                blocks[i][j] = '.';
            }

            while (!queue.isEmpty()) {
                blocks[i++][j] = queue.poll();
            }
        }
    }
}
