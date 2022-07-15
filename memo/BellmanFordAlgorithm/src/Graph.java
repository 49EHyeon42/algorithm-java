package test;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {

    private final int INF = Integer.MAX_VALUE;

    private final int vertexNumber;

    private final ArrayList<ArrayList<Vertex>> graph = new ArrayList<>();
    private final int[] minWeights;

    public Graph(int vertexNumber) {
        this.vertexNumber = vertexNumber;
        for (int i = 0; i <= vertexNumber; i++) {
            graph.add(new ArrayList<>());
        }
        minWeights = new int[vertexNumber + 1];
        Arrays.fill(minWeights, INF);
    }

    public void add(int startVertex, int endVertex, int weight) {
        graph.get(startVertex).add(new Vertex(endVertex, weight));
    }

    public boolean BellmanFord(int startVertex) {
        minWeights[startVertex] = 0;
        for (int i = 1; i <= vertexNumber; i++) {
            for (int j = 0; j < graph.size(); j++) { // j = startVertex
                for (Vertex currentVertex : graph.get(j)) {
                    int endVertex = currentVertex.getValue();
                    int weight = currentVertex.getWeight();

                    if (minWeights[j] != INF && minWeights[endVertex] > minWeights[j] + weight) {
                        if (vertexNumber == i) {
                            return false;
                        }
                        minWeights[endVertex] = minWeights[j] + weight;
                    }
                }
            }
        }

        return true;
    }

    public int[] getMinWeights() {
        return minWeights;
    }
}
