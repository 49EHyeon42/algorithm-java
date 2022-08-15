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
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            countOfEdge[B]++;
            graph.get(A).add(B);
        }

        int[] answer = new int[N + 1];

        // 위상 정렬(Topological Sort)
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (countOfEdge[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            for (int nextVertex : graph.get(currentVertex)) {
                countOfEdge[nextVertex]--;

                if (countOfEdge[nextVertex] == 0) {
                    queue.offer(nextVertex);
                    answer[nextVertex] = Math.max(answer[nextVertex], answer[currentVertex] + 1);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(answer[i] + 1).append(' ');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }
}
