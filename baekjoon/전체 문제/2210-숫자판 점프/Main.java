import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dy = {1, -1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};

    private static int[][] graph;

    private static final Set<String> set = new HashSet<>();

    private static void bfs(int y, int x) {
        Queue<Vertex> queue = new LinkedList<>();

        queue.offer(new Vertex(y, x, ""));

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            if (currentVertex.string.length() > 5) {
                set.add(currentVertex.string);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = currentVertex.y + dy[i];
                int nextX = currentVertex.x + dx[i];

                if (!isPossible(nextY, nextX)) {
                    continue;
                }

                queue.add(new Vertex(nextY, nextX, currentVertex.string + graph[nextY][nextX]));
            }
        }
    }

    private static boolean isPossible(int y, int x) {
        return 0 <= y && y < 5 && 0 <= x && x < 5;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        graph = new int[5][5];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                bfs(i, j);
            }
        }

        bw.write(Integer.toString(set.size()));
        bw.flush();

        br.close();
        bw.close();
    }

    private static class Vertex {

        int y;
        int x;
        String string;

        Vertex(int y, int x, String string) {
            this.y = y;
            this.x = x;
            this.string = string;
        }
    }
}
