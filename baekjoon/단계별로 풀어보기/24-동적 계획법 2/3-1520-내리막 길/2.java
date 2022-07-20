import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// bfs
public class Main {

    private static final int[] DY = new int[]{1, -1, 0, 0};
    private static final int[] DX = new int[]{0, 0, 1, -1};

    private static int length, width;
    private static int[][] matrix, count;
    private static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        length = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        matrix = new int[length][width];
        count = new int[length][width];
        isVisited = new boolean[length][width];

        for (int i = 0; i < length; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < width; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(Integer.toString(bfs()));

        bw.flush();
        bw.close();
    }

    private static int bfs() {
        PriorityQueue<Point> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        count[0][0] = 1;
        isVisited[0][0] = true;
        priorityQueue.add(new Point(0, 0, matrix[0][0]));

        while (!priorityQueue.isEmpty()) {
            Point point = priorityQueue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = point.getY() + DY[i];
                int nx = point.getX() + DX[i];

                if (isPossible(ny, nx)
                    && matrix[ny][nx] < matrix[point.getY()][point.getX()]) {
                    count[ny][nx] += count[point.getY()][point.getX()];

                    if (!isVisited[ny][nx]) {
                        isVisited[ny][nx] = true;
                        priorityQueue.offer(new Point(ny, nx, matrix[ny][nx]));
                    }
                }
            }
        }

        return count[length - 1][width - 1];
    }

    private static boolean isPossible(int y, int x) {
        return y >= 0 && x >= 0 && y < length && x < width;
    }

    private static class Point implements Comparable<Point> {

        private final int y;
        private final int x;
        private final int weight;

        public Point(int y, int x, int weight) {
            this.y = y;
            this.x = x;
            this.weight = weight;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }

        @Override
        public int compareTo(Point o) {
            return this.weight - o.weight;
        }
    }
}
