import java.io.*;
import java.util.*;

public class Main {

    private static final int INF = Integer.MAX_VALUE;

    private static int vertexNumber;

    private static final ArrayList<ArrayList<Vertex>> graph = new ArrayList<>();
    private static final Queue<Integer> queue = new LinkedList<>();

    private static int[] vertexMoveCount;
    private static long[] vertexMinimumDistance;
    private static boolean[] vertexVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        vertexNumber = Integer.parseInt(st.nextToken());
        int edgeNumber = Integer.parseInt(st.nextToken());

        for (int j = 0; j <= vertexNumber; j++) {
            graph.add(new ArrayList<>());
        }

        vertexMoveCount = new int[vertexNumber + 1];

        vertexMinimumDistance = new long[vertexNumber + 1];
        Arrays.fill(vertexMinimumDistance, INF);

        vertexVisited = new boolean[vertexNumber + 1];

        for (int i = 0; i < edgeNumber; i++) {
            st = new StringTokenizer(br.readLine());
            int startCity = Integer.parseInt(st.nextToken());
            int endCity = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph.get(startCity).add(new Vertex(endCity, time));
        }

        StringBuilder sb = new StringBuilder();

        if (SPFA()) {
            for (int currentVertexNumber = 2; currentVertexNumber <= vertexNumber; currentVertexNumber++) {
                sb.append(vertexMinimumDistance[currentVertexNumber] != INF ? vertexMinimumDistance[currentVertexNumber] : -1).append('\n');
            }
        } else {
            sb.append(-1);
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }

    // Shortest Path Faster Algorithm
    private static boolean SPFA() {
        // start 1
        queue.offer(1);
        vertexMoveCount[1]++;
        vertexMinimumDistance[1] = 0;
        vertexVisited[1] = true;

        while (!queue.isEmpty()) {
            int currentVertexNumber = queue.poll();

            vertexVisited[currentVertexNumber] = false;

            for (Vertex nextVertex : graph.get(currentVertexNumber)) {
                if (vertexMinimumDistance[currentVertexNumber] + nextVertex.weight < vertexMinimumDistance[nextVertex.number]) {
                    vertexMinimumDistance[nextVertex.number] = vertexMinimumDistance[currentVertexNumber] + nextVertex.weight;

                    if (!vertexVisited[nextVertex.number]) {
                        vertexMoveCount[nextVertex.number]++;

                        // check infinite loop
                        if (vertexMoveCount[nextVertex.number] >= vertexNumber) {
                            return false;
                        }

                        queue.offer(nextVertex.number);
                        vertexVisited[nextVertex.number] = true;
                    }
                }
            }
        }

        return true;
    }

    private static class Vertex {

        private final int number;
        private final int weight;

        Vertex(int number, int weight) {
            this.number = number;
            this.weight = weight;
        }
    }
}
