import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private final static int INF = 25000001; // 10,000 * 2,500 + 1

    private static int N;

    private static Map<Integer, List<Vertex>> graph;

    private static boolean bellmanFord() {
        int[] distance = new int[N + 1];

        Arrays.fill(distance, INF);
        distance[1] = 0;

        for (int i = 1; i < N; i++) { // N - 1 번 최단 거리 계산
            for (int currentVertex : graph.keySet()) {
                for (Vertex vertex : graph.get(currentVertex)) {
                    // 최단 거리를 구하는 것이 아닌 음의 사이클 판별이 목적이므로
                    // `distance[currentVertex] != INF` 삭제
                    if (distance[vertex.number] > distance[currentVertex] + vertex.weight) {
                        distance[vertex.number] = distance[currentVertex] + vertex.weight;
                    }
                }
            }
        }

        for (int currentVertex = 1; currentVertex <= N; currentVertex++) { // N 번 최단 거리 계산
            for (Vertex vertex : graph.get(currentVertex)) {
                // true -> 값 갱신 -> 음수 사이클이 존재
                if (distance[vertex.number] > distance[currentVertex] + vertex.weight) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        while (TC-- > 0) {
            graph = new HashMap<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            for (int i = 0; i <= N; i++) {
                graph.put(i, new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                graph.get(S).add(new Vertex(E, T));
                graph.get(E).add(new Vertex(S, T));
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                graph.get(S).add(new Vertex(E, -T));
            }

            sb.append(bellmanFord() ? "YES" : "NO").append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static class Vertex {

        int number;
        int weight;

        Vertex(int number, int weight) {
            this.number = number;
            this.weight = weight;
        }
    }
}
