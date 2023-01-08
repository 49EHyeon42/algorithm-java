import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<List<Integer>> graph;

    private static boolean[] visited;

    private static int[] match;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }

        match = new int[N + 1];

        // Bipartite Matching
        int maximumMatchingSize = 0;
        for (int start = 1; start <= N; start++) {
            visited = new boolean[N + 1];

            if (dfs(start)) {
                maximumMatchingSize++;
            }
        }

        bw.write(Integer.toString(maximumMatchingSize));
        bw.flush();

        br.close();
        bw.close();
    }

    private static boolean dfs(int from) {
        for (int to : graph.get(from)) {
            if (visited[to]) {
                continue;
            }

            visited[to] = true;

            if (match[to] == 0 || dfs(match[to])) {
                match[to] = from;

                return true;
            }
        }

        return false;
    }
}
