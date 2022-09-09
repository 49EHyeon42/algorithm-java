import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static final int MAX_WEIGHT = Integer.MAX_VALUE;

    private static final ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static int[] minWeights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 도시의 개수
        int M = Integer.parseInt(st.nextToken()); // 도로의 개수
        int K = Integer.parseInt(st.nextToken()); // 거리 정보
        int X = Integer.parseInt(st.nextToken()); // 출발 도시의 번호

        minWeights = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            minWeights[i] = MAX_WEIGHT;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
        }

//        for (int i = 0; i <= N; i++) {
//            graph.get(i).sort(Comparator.comparingInt(o -> o));
//        }

        dijkstra(X);

        for (int i = 1; i < minWeights.length; i++) {
            if (minWeights[i] == K) {
                sb.append(i).append('\n');
            }
        }

        if (sb.toString().isEmpty()) {
            sb.append(-1);
        }

        bw.write(sb.toString().trim());
        bw.flush();
    }

    private static void dijkstra(int startVertex) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(startVertex);
        minWeights[startVertex] = 0;

        while (!pq.isEmpty()) {
            int currentVertex = pq.poll();

            for (Integer nextVertex : graph.get(currentVertex)) {
                int nextVertexWeight = 1 + minWeights[currentVertex];

                if (minWeights[nextVertex] > nextVertexWeight) {
                    pq.offer(nextVertex);
                    minWeights[nextVertex] = nextVertexWeight;
                }
            }
        }
    }
}
