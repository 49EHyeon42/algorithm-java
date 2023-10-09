import java.io.*;
import java.util.*;

public class Main {


    private static final PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(vertex -> vertex.weight));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertexNumber = Integer.parseInt(st.nextToken());
        int edgeNumber = Integer.parseInt(st.nextToken());
        int powerPlantNumber = Integer.parseInt(st.nextToken());

        List<List<Vertex>> graph = new ArrayList<>();
        for (int i = 0; i <= vertexNumber; i++) {
            graph.add(new ArrayList<>());
        }

        boolean[] visited = new boolean[vertexNumber + 1];

        boolean[] isPowerPlant = new boolean[vertexNumber + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < powerPlantNumber; i++) {
            isPowerPlant[Integer.parseInt(st.nextToken())] = true;
        }

        for (int i = 0; i < edgeNumber; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            Vertex newVertex1 = new Vertex(vertex2, weight);

            graph.get(vertex1).add(newVertex1);

            if (isPowerPlant[vertex1] && !isPowerPlant[vertex2]) {
                visited[vertex1] = true;

                pq.add(newVertex1);
            }

            Vertex newVertex2 = new Vertex(vertex1, weight);

            graph.get(vertex2).add(newVertex2);

            if (!isPowerPlant[vertex1] && isPowerPlant[vertex2]) {
                visited[vertex2] = true;

                pq.add(newVertex2);
            }
        }

        int totalWeight = 0;

        while (!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();

            if (visited[currentVertex.number]) {
                continue;
            }

            visited[currentVertex.number] = true;

            totalWeight += currentVertex.weight;

            for (Vertex nextVertex : graph.get(currentVertex.number)) {
                if (visited[nextVertex.number]) {
                    continue;
                }

                pq.offer(nextVertex);
            }
        }

        bw.write(Integer.toString(totalWeight));

        bw.flush();
        bw.close();
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
