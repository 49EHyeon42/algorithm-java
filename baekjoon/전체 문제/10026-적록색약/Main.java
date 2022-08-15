import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static int N;

    private static final int[] di = {0, 0, 1, -1};
    private static final int[] dj = {1, -1, 0, 0};

    private static char[][] graph;
    private static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        graph = new char[N][N];
        isVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = line.charAt(j);
            }
        }

        int answer1 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 'R' && !isVisited[i][j]) {
                    answer1++;
                    bfs('R', i, j);
                }
                if (graph[i][j] == 'G' && !isVisited[i][j]) {
                    answer1++;
                    bfs('G', i, j);
                }
                if (graph[i][j] == 'B' && !isVisited[i][j]) {
                    answer1++;
                    bfs('B', i, j);
                }
            }
        }

        for (char[] colors : graph) {
            for (int i = 0; i < colors.length; i++) {
                if (colors[i] == 'G') {
                    colors[i] = 'R';
                }
            }
        }
        for (boolean[] row : isVisited) {
            Arrays.fill(row, false);
        }

        int answer2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 'R' && !isVisited[i][j]) {
                    answer2++;
                    bfs('R', i, j);
                }
                if (graph[i][j] == 'B' && !isVisited[i][j]) {
                    answer2++;
                    bfs('B', i, j);
                }
            }
        }

        sb.append(answer1).append(' ').append(answer2);
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void bfs(char color, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{i, j});
        isVisited[i][j] = true;

        while (!queue.isEmpty()) {
            int currentI = queue.peek()[0];
            int currentJ = queue.peek()[1];
            queue.poll();

            for (int k = 0; k < 4; k++) {
                int tempI = currentI + di[k];
                int tempJ = currentJ + dj[k];

                if (isPossibleLength(tempI, tempJ) &&
                    graph[tempI][tempJ] == color && !isVisited[tempI][tempJ]) {
                    queue.offer(new int[]{tempI, tempJ});
                    isVisited[tempI][tempJ] = true;
                }
            }
        }
    }

    private static boolean isPossibleLength(int i, int j) {
        return i >= 0 && j >= 0 && i < N && j < N;
    }
}
