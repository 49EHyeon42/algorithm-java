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

        int N = Integer.parseInt(br.readLine());

        int[] times = new int[N + 1];
        int[] countOfEdge = new int[N + 1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());

            while (true) {
                int vertex = Integer.parseInt(st.nextToken());

                if (vertex == -1) {
                    break;
                }

                countOfEdge[i]++;
                graph.get(vertex).add(i);
            }
        }

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

        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append('\n');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }
}
