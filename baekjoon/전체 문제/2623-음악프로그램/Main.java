import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] countOfEdge = new int[N + 1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int count = Integer.parseInt(st.nextToken());

            int current = Integer.parseInt(st.nextToken());
            for (int j = 1; j < count; j++) {
                int next = Integer.parseInt(st.nextToken());

                countOfEdge[next]++;
                graph.get(current).add(next);

                current = next;
            }
        }

        List<Integer> result = new ArrayList<>();

        // 위상 정렬(Topological Sort)
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (countOfEdge[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            result.add(currentVertex);

            for (int nextVertex : graph.get(currentVertex)) {
                countOfEdge[nextVertex]--;

                if (countOfEdge[nextVertex] == 0) {
                    queue.offer(nextVertex);
                }
            }
        }

        if (result.size() != N) {
            sb.append('0');
        } else {
            for (int vertex : result) {
                sb.append(vertex).append('\n');
            }
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }
}
