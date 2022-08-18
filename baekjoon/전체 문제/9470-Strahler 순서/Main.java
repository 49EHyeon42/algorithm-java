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
            int K = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            int[] count = new int[M + 1];
            int[] order = new int[M + 1];
            int[] countOfEdge = new int[M + 1];
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= M; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < P; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                countOfEdge[B]++;
                graph.get(A).add(B);
            }

            // 위상 정렬(Topological Sort)
            Queue<Integer> queue = new LinkedList<>();

            for (int i = 1; i <= M; i++) {
                if (countOfEdge[i] == 0) {
                    queue.offer(i);

                    count[i]++;
                    order[i]++;
                }
            }

            int result = 0;
            while (!queue.isEmpty()) {
                int currentVertex = queue.poll();

                if (count[currentVertex] >= 2) {
                    order[currentVertex]++;
                }

                result = Math.max(result, order[currentVertex]);

                for (int nextVertex : graph.get(currentVertex)) {
                    countOfEdge[nextVertex]--;

                    if (countOfEdge[nextVertex] == 0) {
                        queue.offer(nextVertex);
                    }

                    if (order[nextVertex] == order[currentVertex]) {
                        count[nextVertex]++;
                    } else if (order[nextVertex] < order[currentVertex]) {
                        order[nextVertex] = order[currentVertex];
                        count[nextVertex] = 1;
                    }
                }
            }

            sb.append(K).append(' ').append(result).append('\n');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }
}
