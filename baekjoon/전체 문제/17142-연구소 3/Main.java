import java.io.*;
import java.util.*;

public class Main {

    private static final List<Virus> viruses = new ArrayList<>();

    private static final int[][] dyx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final Queue<Vertex> queue = new ArrayDeque<>();

    private static int N;
    private static int M;

    private static boolean[][] array;

    private static int blankCount;

    private static int minimumWeight = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new boolean[N][N];

        blankCount = N * N;


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int number = Integer.parseInt(st.nextToken());

                if (number == 2) {
                    viruses.add(new Virus(i, j));
                } else if (number == 1) {
                    array[i][j] = true;

                    blankCount--;
                }
            }
        }

        if (viruses.size() < M) {
            M = viruses.size();
        }

        combination(0, 0);

        bw.write(Integer.toString(minimumWeight == Integer.MAX_VALUE ? -1 : minimumWeight));
        bw.flush();

        br.close();
        bw.close();
    }

    private static void combination(int depth, int start) {
        if (depth == M) {
            minimumWeight = Math.min(minimumWeight, bfs());
            return;
        }

        for (int i = start; i < viruses.size(); i++) {
            viruses.get(i).use = true;
            combination(depth + 1, i + 1);
            viruses.get(i).use = false;
        }
    }

    private static int bfs() {
        int weight = 0;

        int virusCount = 0;

        // -1 = 방문한 상태, 0 = 방문하지 않은 상태, 1 = 비활성화해서 이동만 가능한 상태
        int[][] visited = new int[N][N];

        for (Virus virus : viruses) {
            if (virus.use) {
                visited[virus.y][virus.x] = -1;

                queue.offer(new Vertex(virus.y, virus.x, 0));
            } else {
                visited[virus.y][virus.x] = 1;

                virusCount++; // 활성화 바이러스를 만나지 않은 경우에 사용
            }
        }

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            virusCount++;

            int nextWeight = currentVertex.weight + 1;

            for (int i = 0; i < 4; i++) {
                int nextY = currentVertex.y + dyx[i][0];
                int nextX = currentVertex.x + dyx[i][1];

                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= N) {
                    continue;
                }

                if (array[nextY][nextX]) {
                    continue;
                }

                if (visited[nextY][nextX] == -1) {
                    continue;
                }

                if (visited[nextY][nextX] == 0) { // 방문 X, 비활성화 중 방문 X 일 때만 허용
                    if (weight < nextWeight) {
                        weight = nextWeight;
                    }

                    visited[nextY][nextX] = -1;

                    queue.offer(new Vertex(nextY, nextX, nextWeight));
                } else {
                    virusCount--; // 활성화 바이러스를 만나지 않은 경우에 사용하지만 만났을 경우, 중복 제거

                    visited[nextY][nextX] = -1;

                    queue.offer(new Vertex(nextY, nextX, nextWeight));
                }
            }
        }

        return blankCount == virusCount ? weight : Integer.MAX_VALUE;
    }

    private static class Virus {

        final int y;
        final int x;

        boolean use;

        Virus(int y, int x) {
            this.y = y;
            this.x = x;
            use = false;
        }
    }

    private static class Vertex {

        final int y;
        final int x;
        final int weight;

        Vertex(int y, int x, int weight) {
            this.y = y;
            this.x = x;
            this.weight = weight;
        }
    }
}
