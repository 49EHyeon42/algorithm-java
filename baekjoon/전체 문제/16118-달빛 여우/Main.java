import java.io.*;
import java.util.*;

// [경고]
// `Map<Integer, Set<Vertex>> graph = new HashMap<>()`를 사용하면 시간 초과를 문제를 통과할 수 없다.

public class Main {

    private static final List<List<Vertex>> graph = new ArrayList<>();
    // private static final Map<Integer, Set<Vertex>> graph = new HashMap<>();
    private static final PriorityQueue<Vertex> foxPq = new PriorityQueue<>(Comparator.comparingInt(vertex -> vertex.weight));
    private static final PriorityQueue<WolfVertex> wolfPq = new PriorityQueue<>(Comparator.comparingInt(wolfVertex -> wolfVertex.weight));

    private static int[] foxMinWeights;
    private static int[][] wolfMinWeights; // [i][0] = 회복, [i][1] = 달리기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        foxMinWeights = new int[N + 1];
        wolfMinWeights = new int[N + 1][2];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            // graph.put(i, new HashSet<>());

            foxMinWeights[i] = Integer.MAX_VALUE;
            wolfMinWeights[i][0] = wolfMinWeights[i][1] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(vertex1).add(new Vertex(vertex2, weight * 2));
            graph.get(vertex2).add(new Vertex(vertex1, weight * 2));
        }

        foxDijkstra();
        wolfDijkstra();

        int count = 0;

        for (int i = 2; i <= N; i++) {
            if (foxMinWeights[i] < Math.min(wolfMinWeights[i][0], wolfMinWeights[i][1])) {
                count++;
            }
        }

        bw.write(Integer.toString(count));
        bw.flush();

        br.close();
        bw.close();
    }

    private static void foxDijkstra() {
        foxPq.offer(new Vertex(1, 0));
        foxMinWeights[1] = 0;

        while (!foxPq.isEmpty()) {
            Vertex currentVertex = foxPq.poll();

            if (foxMinWeights[currentVertex.number] < currentVertex.weight) {
                continue;
            }

            for (Vertex nextVertex : graph.get(currentVertex.number)) {
                int nextWeight = currentVertex.weight + nextVertex.weight;

                if (nextWeight >= foxMinWeights[nextVertex.number]) {
                    continue;
                }

                foxPq.offer(new Vertex(nextVertex.number, nextWeight));
                foxMinWeights[nextVertex.number] = nextWeight;
            }
        }
    }

    private static void wolfDijkstra() {
        wolfPq.offer(new WolfVertex(1, 0, true));
        wolfMinWeights[1][1] = 0;

        while (!wolfPq.isEmpty()) {
            WolfVertex currentVertex = wolfPq.poll();

            // 달릴 수 있다면 이전 달린 값과 비교, 걷고 있다면 걸은 값과 비교
            if (wolfMinWeights[currentVertex.number][currentVertex.speed ? 1 : 0] < currentVertex.weight) {
                continue;
            }

            for (Vertex nextVertex : graph.get(currentVertex.number)) {
                int nextWeight = currentVertex.weight +
                        (currentVertex.speed ? nextVertex.weight / 2 : nextVertex.weight * 2);

                // 달렸다면 다음 걸은 것과 비교, 걸었다면 다음 달린 것과 비교
                if (nextWeight >= wolfMinWeights[nextVertex.number][currentVertex.speed ? 0 : 1]) {
                    continue;
                }

                wolfPq.offer(new WolfVertex(nextVertex.number, nextWeight, !currentVertex.speed));
                wolfMinWeights[nextVertex.number][currentVertex.speed ? 0 : 1] = nextWeight;
            }
        }
    }

    private static class Vertex {

        final int number;
        final int weight;

        Vertex(int number, int weight) {
            this.number = number;
            this.weight = weight;
        }
    }

    private static class WolfVertex {

        final int number;
        final int weight;
        final boolean speed;

        WolfVertex(int number, int weight, boolean speed) {
            this.number = number;
            this.weight = weight;
            this.speed = speed;
        }
    }
}
