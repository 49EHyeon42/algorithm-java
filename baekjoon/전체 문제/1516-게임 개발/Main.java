import java.io.*;
import java.util.*;

public class Main {

    private static final Map<Integer, Set<Integer>> graph = new HashMap<>();
    private static final Queue<Integer> queue = new LinkedList<>();

    private static int N;

    private static int[] times;
    private static int[] countOfEdge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            graph.put(i, new HashSet<>());
        }

        times = new int[N + 1];
        countOfEdge = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            times[i] = Integer.parseInt(st.nextToken());

            while (true) {
                int vertex = Integer.parseInt(st.nextToken());

                if (vertex == -1) {
                    break;
                }

                graph.get(vertex).add(i);

                countOfEdge[i]++;
            }
        }

        bw.write(topologySort());
        bw.flush();

        br.close();
        bw.close();
    }

    // 위상 정렬
    private static String topologySort() {
        StringBuilder sb = new StringBuilder();

        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            if (countOfEdge[i] != 0) {
                continue;
            }

            queue.offer(i);

            dp[i] = times[i];
        }

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            for (int nextVertex : graph.get(currentVertex)) {
                // nextVertex 이전 건물 중 가장 오래 걸리는 시간 + nextVertex 건설 시간
                dp[nextVertex] = Math.max(dp[nextVertex], dp[currentVertex] + times[nextVertex]);

                if (--countOfEdge[nextVertex] != 0) {
                    continue;
                }

                queue.offer(nextVertex);
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(dp[i]).append('\n');
        }

        return sb.toString().trim();
    }
}
