import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static final PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(vertex -> vertex.mirror));
    private static final int[][] dyx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상, 하, 좌, 우

    private static int H;
    private static int W;

    private static char[][] graph;

    private static int startY;
    private static int startX;
    private static int endY;
    private static int endX;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        graph = new char[H][W];

        startY = -1;
        startX = -1;

        endY = -1;
        endX = -1;

        for (int i = 0; i < H; i++) {
            String string = br.readLine();

            for (int j = 0; j < W; j++) {
                char c = string.charAt(j);

                if (c == 'C') {
                    if (startY == -1) {
                        startY = i;
                        startX = j;
                    } else {
                        endY = i;
                        endX = j;
                    }
                }

                graph[i][j] = c;
            }
        }

        bw.write(Integer.toString(dijkstra()));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int dijkstra() {
        int[][][] mirrors = new int[H][W][4];

        for (int[][] i : mirrors) {
            for (int[] j : i) {
                Arrays.fill(j, Integer.MAX_VALUE);
            }
        }

        for (int i = 0; i < 4; i++) {
            mirrors[startY][startX][i] = 0;
        }

        pq.offer(new Vertex(startY, startX, -1, 0));

        while (!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();

            if (currentVertex.direction != -1 && mirrors[currentVertex.y][currentVertex.x][currentVertex.direction] < currentVertex.mirror) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = currentVertex.y + dyx[i][0];
                int nextX = currentVertex.x + dyx[i][1];

                if (nextY < 0 || nextY >= H || nextX < 0 || nextX >= W) {
                    continue;
                }

                if (graph[nextY][nextX] == '*') {
                    continue;
                }

                if (currentVertex.direction == -1) {
                    mirrors[nextY][nextX][i] = 0;

                    pq.offer(new Vertex(nextY, nextX, i, 0));
                } else {
                    int nextMirror = currentVertex.direction == i ? currentVertex.mirror : currentVertex.mirror + 1;

                    if (mirrors[nextY][nextX][i] <= nextMirror) {
                        continue;
                    }

                    mirrors[nextY][nextX][i] = nextMirror;

                    pq.offer(new Vertex(nextY, nextX, i, nextMirror));
                }
            }
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++) {
            result = Math.min(result, mirrors[endY][endX][i]);
        }

        return result;
    }

    private static class Vertex {

        int y;
        int x;
        int direction;
        int mirror;

        Vertex(int y, int x, int direction, int mirror) {
            this.y = y;
            this.x = x;
            this.direction = direction;
            this.mirror = mirror;
        }
    }
}
