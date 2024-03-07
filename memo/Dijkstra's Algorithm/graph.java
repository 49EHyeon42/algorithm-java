import java.util.*;

public class Graph {

    private final Map<Integer, Set<Vertex>> graph = new HashMap<>();
    private final int[] minWeights;

    public Graph(int vertexNumber) {
        minWeights = new int[vertexNumber + 1];

        for (int i = 1; i <= vertexNumber; i++) {
            graph.put(i, new HashSet<>());

            minWeights[i] = Integer.MAX_VALUE;
        }
    }

    public void add(int startVertex, int endVertex, int weight) {
        graph.get(startVertex).add(new Vertex(endVertex, weight));
    }

    public int[] dijkstra(int startVertex) {
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();

        priorityQueue.offer(new Vertex(startVertex, 0));
        minWeights[startVertex] = 0;

        while (!priorityQueue.isEmpty()) {
            Vertex currentVertex = priorityQueue.poll();

            for (Vertex nextVertex : graph.get(currentVertex.getNumber())) {
                int nextVertexWeight = nextVertex.getWeight() + currentVertex.getWeight();

                if (minWeights[nextVertex.getNumber()] > nextVertexWeight) {
                    minWeights[nextVertex.getNumber()] = nextVertexWeight;

                    priorityQueue.offer(new Vertex(nextVertex.getNumber(), nextVertexWeight));
                }
            }
        }

        return minWeights;
    }
}
