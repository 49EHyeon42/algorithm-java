import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCaseCount = Integer.parseInt(br.readLine());
        while (testCaseCount-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] countOfEdge = new int[N + 1];
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());

            int[] times = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                times[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int vertex1 = Integer.parseInt(st.nextToken());
                int vertex2 = Integer.parseInt(st.nextToken());

                countOfEdge[vertex2]++;
                graph.get(vertex1).add(vertex2);
            }

            int W = Integer.parseInt(br.readLine());

            int[] result = new int[N + 1];

            // 위상 정렬(Topological Sort)
            Queue<Integer> queue = new LinkedList<>();

            for (int i = 1; i <= N; i++) {
                if (countOfEdge[i] == 0) {
                    result[i] = times[i];
                    queue.offer(i);
                }
            }

            while (!queue.isEmpty()) {
                int currentVertex = queue.poll();

                for (int nextVertex : graph.get(currentVertex)) {
                    result[nextVertex] = Math.max(result[nextVertex],
                        result[currentVertex] + times[nextVertex]);

                    countOfEdge[nextVertex]--;

                    if (countOfEdge[nextVertex] == 0) {
                        queue.offer(nextVertex);
                    }
                }
            }

            sb.append(result[W]).append('\n');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }
}
