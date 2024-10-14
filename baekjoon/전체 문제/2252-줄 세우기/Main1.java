import java.io.*;
import java.util.*;

public class Main1 {

    private static final Map<Integer, Set<Integer>> graph = new HashMap<>();
    private static final Queue<Integer> queue = new LinkedList<>(); // 큐 사용

    private static int[] countOfEdge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            graph.put(i, new HashSet<>());
        }

        // 위상 정렬, 간선 확인용
        countOfEdge = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());

            graph.get(vertex1).add(vertex2);

            countOfEdge[vertex2]++;
        }

        bw.write(topologySort());
        bw.flush();

        br.close();
        bw.close();
    }

    // 위상 정렬, 순서 반환
    private static String topologySort() {
        StringBuilder sb = new StringBuilder();

        // 시작 정점 찾기
        for (int i = 1; i < countOfEdge.length; i++) {
            if (countOfEdge[i] != 0) {
                continue;
            }

            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            sb.append(currentVertex).append(' ');

            for (int nextVertex : graph.get(currentVertex)) {
                // 간선 제거
                countOfEdge[nextVertex]--;

                // 간선이 없다면 큐에 정점 추가
                if (countOfEdge[nextVertex] != 0) {
                    continue;
                }

                queue.offer(nextVertex);
            }
        }

        return sb.toString().trim();
    }
}
