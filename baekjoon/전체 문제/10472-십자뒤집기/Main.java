import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {

    private static final int[] dy = {-1, 1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};

    private static final Queue<Vertex> queue = new ArrayDeque<>();

    private static char[][] endBoard;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int P = Integer.parseInt(br.readLine());

        while (P-- > 0) {
            endBoard = new char[3][3];

            for (int i = 0; i < 3; i++) {
                String string = br.readLine();

                for (int j = 0; j < 3; j++) {
                    endBoard[i][j] = string.charAt(j);
                }
            }

            sb.append(bfs()).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static int bfs() {
        queue.clear();

        List<char[][]> boards = new ArrayList<>();

        char[][] board = initBoard();

        boards.add(board);

        queue.offer(new Vertex(board, -1, -1, 0));

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            if (isSameBoard(currentVertex.board, endBoard)) {
                return currentVertex.count;
            }

            for (int i = 0; i < 3; i++) {

                loop:
                for (int j = 0; j < 3; j++) {
                    if (i == currentVertex.y && j == currentVertex.x) {
                        continue;
                    }

                    char[][] changeBoard = changeBoard(currentVertex.board, i, j);

                    for (char[][] createdBoard : boards) {
                        if (isSameBoard(changeBoard, createdBoard)) {
                            continue loop;
                        }
                    }

                    boards.add(changeBoard);

                    queue.offer(new Vertex(changeBoard, i, j, currentVertex.count + 1));
                }
            }
        }

        // 항상 해가 있다 가정
        return -1;
    }

    private static char[][] initBoard() {
        char[][] board = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '.';
            }
        }

        return board;
    }

    private static char[][] changeBoard(char[][] board, int y, int x) {
        char[][] newBoard = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                newBoard[i][j] = board[i][j];
            }
        }

        newBoard[y][x] = board[y][x] == '*' ? '.' : '*';

        for (int i = 0; i < 4; i++) {
            int changeY = y + dy[i];
            int changeX = x + dx[i];

            if (changeY < 0 || changeY > 2 || changeX < 0 || changeX > 2) {
                continue;
            }

            newBoard[changeY][changeX] = board[changeY][changeX] == '*' ? '.' : '*';
        }

        return newBoard;
    }

    private static boolean isSameBoard(char[][] a, char[][] b) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static class Vertex {

        final char[][] board;
        final int y;
        final int x;
        final int count;

        Vertex(char[][] board, int y, int x, int count) {
            this.board = board;
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
}
