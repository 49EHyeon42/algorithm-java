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

    private static int count = 0;
    private static boolean[][] graph;
    private static boolean[][] isVisited;
    private static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        graph = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String string = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = string.charAt(j) != '0';
            }
        }
        isVisited = new boolean[N][N];
        array = new int[N * N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] && !isVisited[i][j]) {
                    count++;
                    bfs(i, j);
                }
            }
        }

        Arrays.sort(array);

        StringBuilder sb = new StringBuilder();
        sb.append(count).append('\n');
        for (int i : array) {
            if (i != 0) {
                sb.append(i).append('\n');
            }
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }

    private static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{i, j});
        isVisited[i][j] = true;
        array[count]++;

        while (!queue.isEmpty()) {
            int currentI = queue.peek()[0];
            int currentJ = queue.peek()[1];
            queue.poll();

            for (int k = 0; k < 4; k++) {
                int tempI = currentI + di[k];
                int tempJ = currentJ + dj[k];

                if (isPossibleLength(tempI, tempJ) &&
                    graph[tempI][tempJ] && !isVisited[tempI][tempJ]) {
                    queue.offer(new int[]{tempI, tempJ});
                    isVisited[tempI][tempJ] = true;
                    array[count]++;
                }
            }
        }
    }

    private static boolean isPossibleLength(int i, int j) {
        return i >= 0 && j >= 0 && i < N && j < N;
    }
}
