import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[][] dyx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static int N;
    private static int M;
    private static char[][] array;
    private static Coordinate coin1;
    private static Coordinate coin2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new char[N][M];


        for (int i = 0; i < N; i++) {
            String string = br.readLine();

            for (int j = 0; j < M; j++) {
                char c = string.charAt(j);

                if (c == 'o') {
                    if (coin1 == null) {
                        coin1 = new Coordinate(i, j);
                    } else {
                        coin2 = new Coordinate(i, j);
                    }
                }

                array[i][j] = c;
            }
        }

        bw.write(Integer.toString(bfs()));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int bfs() {
        boolean[][][][] visited = new boolean[N][M][N][M];

        Queue<Vertex> queue = new ArrayDeque<>();

        visited[coin1.y][coin1.x][coin2.y][coin2.x] = true;

        queue.offer(new Vertex(coin1.y, coin1.x, coin2.y, coin2.x, 0));

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            if (currentVertex.weight > 9) { // 10번 이상 이동
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nextCoin1Y = currentVertex.coin1Y + dyx[i][0];
                int nextCoin1X = currentVertex.coin1X + dyx[i][1];
                int nextCoin2Y = currentVertex.coin2Y + dyx[i][0];
                int nextCoin2X = currentVertex.coin2X + dyx[i][1];

                boolean flag1 = false;
                boolean flag2 = false;

                if (nextCoin1Y < 0 || nextCoin1Y >= N || nextCoin1X < 0 || nextCoin1X >= M) {
                    flag1 = true;
                }

                if (nextCoin2Y < 0 || nextCoin2Y >= N || nextCoin2X < 0 || nextCoin2X >= M) {
                    flag2 = true;
                }

                if (flag1 && flag2) { // 동전 2개 다 out
                    continue;
                } else if (!flag1 && !flag2) { // 동전 2개 다 in
                    if (array[nextCoin1Y][nextCoin1X] == '#') {
                        nextCoin1Y = currentVertex.coin1Y;
                        nextCoin1X = currentVertex.coin1X;
                    }

                    if (array[nextCoin2Y][nextCoin2X] == '#') {
                        nextCoin2Y = currentVertex.coin2Y;
                        nextCoin2X = currentVertex.coin2X;
                    }

                    if (visited[nextCoin1Y][nextCoin1X][nextCoin2Y][nextCoin2X]) {
                        continue;
                    }

                    visited[nextCoin1Y][nextCoin1X][nextCoin2Y][nextCoin2X] = true;

                    queue.offer(new Vertex(nextCoin1Y, nextCoin1X, nextCoin2Y, nextCoin2X, currentVertex.weight + 1));
                } else { // 동전 2개 중 하나 out
                    return currentVertex.weight + 1;
                }
            }
        }


        return -1;
    }

    private static class Coordinate {

        final int y;
        final int x;

        Coordinate(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static class Vertex {

        final int coin1Y;
        final int coin1X;
        final int coin2Y;
        final int coin2X;
        final int weight;

        Vertex(int coin1Y, int coin1X, int coin2Y, int coin2X, int weight) {
            this.coin1Y = coin1Y;
            this.coin1X = coin1X;
            this.coin2Y = coin2Y;
            this.coin2X = coin2X;
            this.weight = weight;
        }
    }
}
