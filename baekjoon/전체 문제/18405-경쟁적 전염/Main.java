import java.io.*;
import java.util.*;

public class Main {

    private static final int[][] dyx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final Queue<Vertex> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] array = new int[N][N];

        // 바이러스가 1<= K <= 1000 중 없을 수도 있으며, 2개 이상 있을 수도 있다.
        List<Virus> viruses = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());

                if (value != 0) {
                    viruses.add(new Virus(value, i, j));
                }

                array[i][j] = value;
            }
        }

        viruses.sort(Comparator.comparingInt(virus -> virus.type));

        int[][] visited = new int[N][N];

        for (Virus virus : viruses) {
            visited[virus.y][virus.x] = virus.type;

            queue.offer(new Vertex(virus.y, virus.x, 0));
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken()) - 1;
        int Y = Integer.parseInt(st.nextToken()) - 1;

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            if (currentVertex.second == S) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = currentVertex.y + dyx[i][0];
                int nextX = currentVertex.x + dyx[i][1];

                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= N) {
                    continue;
                }

                if (array[nextY][nextX] != 0) {
                    continue;
                }

                if (visited[nextY][nextX] != 0) {
                    continue;
                }

                visited[nextY][nextX] = visited[currentVertex.y][currentVertex.x];

                queue.offer(new Vertex(nextY, nextX, currentVertex.second + 1));
            }
        }

        bw.write(Integer.toString(visited[X][Y]));
        bw.flush();

        br.close();
        bw.close();
    }

    private static class Virus {

        final int type;
        final int y;
        final int x;

        Virus(int type, int y, int x) {
            this.type = type;
            this.y = y;
            this.x = x;
        }
    }

    private static class Vertex {

        final int y;
        final int x;
        final int second;

        Vertex(int y, int x, int second) {
            this.y = y;
            this.x = x;
            this.second = second;
        }
    }
}
