import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;

    private static boolean[][] graph;

    private static boolean[] visited;

    private static int[] match;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new boolean[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int work = Integer.parseInt(st.nextToken());

            for (int j = 0; j < work; j++) {
                graph[i][Integer.parseInt(st.nextToken())] = true;
            }
        }

        visited = new boolean[N + 1];

        match = new int[M + 1];
        for (int i = 0; i <= M; i++) {
            match[i] = -1;
        }

        bw.write(Integer.toString(bipartiteMatching()));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int bipartiteMatching() {
        int maximumMatchingSize = 0;

        for (int start = 1; start <= N; start++) {

            for (int i = 1; i <= 2; i++) {
                visited = new boolean[N + 1];

                if (dfs(start)) {
                    maximumMatchingSize++;
                }
            }
        }

        return maximumMatchingSize;
    }

    private static boolean dfs(int from) {
        if (visited[from]) {
            return false;
        }

        visited[from] = true;

        for (int to = 1; to <= M; to++) {
            if (graph[from][to]) {
                if (match[to] == -1 || dfs(match[to])) {
                    match[to] = from;

                    return true;
                }
            }
        }

        return false;
    }
}
