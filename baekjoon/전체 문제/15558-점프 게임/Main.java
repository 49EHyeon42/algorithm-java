    import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] array = new int[2][N];

        for (int i = 0; i < 2; i++) {
            String string = br.readLine();

            for (int j = 0; j < string.length(); j++) {
                array[i][j] = string.charAt(j) - '0';
            }
        }

        int result = 0;

        boolean[][] visited = new boolean[2][N];
        visited[0][0] = true;

        Queue<Coordinate> queue = new ArrayDeque<>();
        queue.offer(new Coordinate(0, 0, 0));

        while (!queue.isEmpty()) {
            Coordinate currentCoordinate = queue.poll();

            int nextTime = currentCoordinate.time + 1;

            // 앞
            int nextY = currentCoordinate.y;
            int nextX = currentCoordinate.x + 1;

            if (nextX == N) { // 도착
                result = 1;
                break;
            }

            if (array[nextY][nextX] == 1 && !visited[nextY][nextX]) {
                visited[nextY][nextX] = true;
                queue.offer(new Coordinate(nextY, nextX, nextTime));
            }

            // 뒤
            if (currentCoordinate.x - 1 > currentCoordinate.time) {
                nextX = currentCoordinate.x - 1;

                if (array[nextY][nextX] == 1 && !visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    queue.offer(new Coordinate(nextY, nextX, nextTime));
                }
            }

            // 점프
            nextY = currentCoordinate.y == 0 ? 1 : 0;
            nextX = currentCoordinate.x + k;

            if (nextX >= N) { // 도착
                result = 1;
                break;
            }

            if (array[nextY][nextX] == 1 && !visited[nextY][nextX]) {
                visited[nextY][nextX] = true;
                queue.offer(new Coordinate(nextY, nextX, nextTime));
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();

        br.close();
        bw.close();
    }

    private static class Coordinate {

        final int y;
        final int x;
        final int time;

        Coordinate(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }
}
