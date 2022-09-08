import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static final int MAX_WEIGHT = Integer.MAX_VALUE;
    private static final int[] dy = new int[]{1, -1, 0, 0};
    private static final int[] dx = new int[]{0, 0, 1, -1};

    private static int N;
    private static int[][] weights;
    private static int[][] minWeights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int count = 1;

        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            weights = new int[N][N];
            minWeights = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {
                    weights[i][j] = Integer.parseInt(st.nextToken());
                    minWeights[i][j] = MAX_WEIGHT;
                }
            }

            dijkstra();

            int minWeight = minWeights[N - 1][N - 1];

            sb.append("Problem ").append(count++).append(": ").append(minWeight).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void dijkstra() {
        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(Vertex::getWeight));

        pq.offer(new Vertex(0, 0, weights[0][0]));
        minWeights[0][0] = weights[0][0];

        while (!pq.isEmpty()) {
            int currentVertexY = pq.peek().getY();
            int currentVertexX = pq.peek().getX();
            int currentVertexWeight = pq.peek().getWeight();

            pq.poll();

            for (int i = 0; i < 4; i++) {
                int nextVertexY = currentVertexY + dy[i];
                int nextVertexX = currentVertexX + dx[i];

                if (isPossibleLength(nextVertexY, nextVertexX)) {
                    int nextVertexWeight = weights[nextVertexY][nextVertexX] + currentVertexWeight;

                    if (minWeights[nextVertexY][nextVertexX] > nextVertexWeight) {
                        pq.offer(new Vertex(nextVertexY, nextVertexX, nextVertexWeight));
                        minWeights[nextVertexY][nextVertexX] = nextVertexWeight;
                    }
                }
            }
        }
    }

    private static boolean isPossibleLength(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < N;
    }

    private static class Vertex {

        private final int y;
        private final int x;
        private final int weight;

        public Vertex(int y, int x, int weight) {
            this.y = y;
            this.x = x;
            this.weight = weight;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }

        public int getWeight() {
            return weight;
        }
    }
}
