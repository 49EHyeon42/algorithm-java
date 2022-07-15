import java.util.ArrayList;
import java.util.PriorityQueue;

public class Graph {

    private final ArrayList<ArrayList<Vertex>> graph = new ArrayList<>();
    private final int[] minWeights;

    public Graph(int vertexNumber) {
        for (int i = 0; i <= vertexNumber; i++) {
            graph.add(new ArrayList<>());
        }
        minWeights = new int[vertexNumber + 1];
    }

    public void add(int startVertex, int endVertex, int weight) {
        graph.get(startVertex).add(new Vertex(endVertex, weight));
    }

    public int[] dijkstra(int startVertex) {
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();

        priorityQueue.offer(new Vertex(startVertex, 0));
        minWeights[startVertex] = 0;

        while (!priorityQueue.isEmpty()) {
            int currentVertexValue = priorityQueue.peek().getValue();
            int currentVertexWeight = priorityQueue.peek().getWeight();
            priorityQueue.poll();

            for (Vertex nextVertex : graph.get(currentVertexValue)) {
                int nextVertexValue = nextVertex.getValue();
                int nextVertexWeight = nextVertex.getWeight() + currentVertexWeight;

                if (minWeights[nextVertexValue] > nextVertexWeight) {
                    priorityQueue.offer(new Vertex(nextVertexValue, nextVertexWeight));
                    minWeights[nextVertexValue] = nextVertexWeight;
                }
            }
        }

        return minWeights;
    }
}
