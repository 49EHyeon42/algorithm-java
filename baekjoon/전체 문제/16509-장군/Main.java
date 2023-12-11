import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int maxY = 10;
    private static final int maxX = 9;
    private static final int[][] array = new int[maxY][maxX];
    private static final boolean[][] visited = new boolean[maxY][maxX];
    private static final Queue<Coordinate> queue = new ArrayDeque<>();

    private static int R2;
    private static int C2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R1 = Integer.parseInt(st.nextToken());
        int C1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        R2 = Integer.parseInt(st.nextToken());
        C2 = Integer.parseInt(st.nextToken());

        visited[R1][C1] = true;

        queue.offer(new Coordinate(R1, C1, 0));

        int minWeight = Integer.MAX_VALUE;

        // BFS
        while (!queue.isEmpty()) {
            Coordinate currentCoordinate = queue.poll();

            if (currentCoordinate.y == R2 && currentCoordinate.x == C2) {
                minWeight = currentCoordinate.weight;
                break;
            }

            moveUp(currentCoordinate.y, currentCoordinate.x, currentCoordinate.weight);
            moveRight(currentCoordinate.y, currentCoordinate.x, currentCoordinate.weight);
            moveLeft(currentCoordinate.y, currentCoordinate.x, currentCoordinate.weight);
            moveDown(currentCoordinate.y, currentCoordinate.x, currentCoordinate.weight);
        }

        bw.write(Integer.toString(minWeight == Integer.MAX_VALUE ? -1 : minWeight));
        bw.flush();

        br.close();
        bw.close();
    }

    private static void moveUp(int y, int x, int weight) {
        if (!canMove(y - 1, x)) {
            return;
        }

        moveUpLeft(y - 1, x, weight);
        moveUpRight(y - 1, x, weight);
    }

    private static void moveRight(int y, int x, int weight) {
        if (!canMove(y, x + 1)) {
            return;
        }

        moveUpRight(y, x + 1, weight);
        moveDownRight(y, x + 1, weight);
    }

    private static void moveDown(int y, int x, int weight) {
        if (!canMove(y + 1, x)) {
            return;
        }

        moveDownRight(y + 1, x, weight);
        moveDownLeft(y + 1, x, weight);
    }

    private static void moveLeft(int y, int x, int weight) {
        if (!canMove(y, x - 1)) {
            return;
        }

        moveDownLeft(y, x - 1, weight);
        moveUpLeft(y, x - 1, weight);
    }

    private static void moveUpLeft(int y, int x, int weight) {
        if (!canMove(y - 1, x - 1) || !isPossibleRange(y - 2, x - 2) || visited[y - 2][x - 2]) {
            return;
        }

        visited[y - 2][x - 2] = true;

        queue.offer(new Coordinate(y - 2, x - 2, weight + 1));
    }

    private static void moveUpRight(int y, int x, int weight) {
        if (!canMove(y - 1, x + 1) || !isPossibleRange(y - 2, x + 2) || visited[y - 2][x + 2]) {
            return;
        }

        visited[y - 2][x + 2] = true;

        queue.offer(new Coordinate(y - 2, x + 2, weight + 1));
    }

    private static void moveDownRight(int y, int x, int weight) {
        if (!canMove(y + 1, x + 1) || !isPossibleRange(y + 2, x + 2) || visited[y + 2][x + 2]) {
            return;
        }

        visited[y + 2][x + 2] = true;

        queue.offer(new Coordinate(y + 2, x + 2, weight + 1));
    }

    private static void moveDownLeft(int y, int x, int weight) {
        if (!canMove(y + 1, x - 1) || !isPossibleRange(y + 2, x - 2) || visited[y + 2][x - 2]) {
            return;
        }

        visited[y + 2][x - 2] = true;

        queue.offer(new Coordinate(y + 2, x - 2, weight + 1));
    }

    private static boolean canMove(int y, int x) {
        return isPossibleRange(y, x) && !isThereKing(y, x);
    }

    private static boolean isPossibleRange(int y, int x) {
        return y >= 0 && y < maxY && x >= 0 && x < maxX;
    }

    // 기물이 있는 경우
    private static boolean isThereKing(int y, int x) {
        return y == R2 && x == C2;
    }

    private static class Coordinate {

        final int y;
        final int x;
        final int weight;

        Coordinate(int y, int x, int weight) {
            this.y = y;
            this.x = x;
            this.weight = weight;
        }
    }
}
