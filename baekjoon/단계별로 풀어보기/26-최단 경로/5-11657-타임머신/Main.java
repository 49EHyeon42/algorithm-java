import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// Bellman–Ford algorithm
public class Main {

    private static final int INF = Integer.MAX_VALUE;

    private static int vertexNumber;

    private static final ArrayList<ArrayList<Vertex>> graph = new ArrayList<>();
    private static long[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        vertexNumber = Integer.parseInt(st.nextToken());
        int edgeNumber = Integer.parseInt(st.nextToken());

        for (int j = 0; j <= vertexNumber; j++) {
            graph.add(new ArrayList<>());
        }
        distance = new long[vertexNumber + 1];
        Arrays.fill(distance, INF);

        for (int i = 0; i < edgeNumber; i++) {
            st = new StringTokenizer(br.readLine());
            int startCity = Integer.parseInt(st.nextToken());
            int endCity = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph.get(startCity).add(new Vertex(endCity, time));
        }

        StringBuilder sb = new StringBuilder();
        if (bellmanFord()) {
            for (int i = 2; i <= vertexNumber; i++) {
                if (distance[i] != INF) {
                    sb.append(distance[i]).append('\n');
                } else {
                    sb.append("-1\n");
                }
            }
        } else {
            sb.append("-1\n");
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }

    private static boolean bellmanFord() {
        distance[1] = 0;
        for (int i = 1; i < vertexNumber; i++) {
            for (int j = 0; j < graph.size(); j++) {
                for (Vertex currentVertex : graph.get(j)) {
                    int endCity = currentVertex.getValue();
                    int time = currentVertex.getWeight();

                    // j = startCity
                    if (distance[j] != INF && distance[endCity] > distance[j] + time) {
                        distance[endCity] = distance[j] + time;
                    }
                }
            }
        }

        for (int j = 0; j < graph.size(); j++) {
            for (Vertex currentVertex : graph.get(j)) {
                int endCity = currentVertex.getValue();
                int time = currentVertex.getWeight();

                // j = startCity
                if (distance[j] != INF && distance[endCity] > distance[j] + time) {
                    return false;
                }
            }
        }

        return true;
    }

    private static class Vertex {

        private final int value;
        private final int weight;

        public Vertex(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }

        public int getValue() {
            return value;
        }

        public int getWeight() {
            return weight;
        }
    }
}
