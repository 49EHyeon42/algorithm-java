import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Prim {

    private final ArrayList<ArrayList<Vertex>> graph;

    private final PriorityQueue<Vertex> pq = new PriorityQueue<>(
        Comparator.comparingInt(Vertex::getWeight));
    private final boolean[] isVisited;

    public Prim(ArrayList<ArrayList<Vertex>> graph, int vertexCount) {
        this.graph = graph;
        isVisited = new boolean[vertexCount + 1];
    }

    public int prim(int startVertex) {
        int minWeight = 0;

        pq.offer(new Vertex(startVertex, 0));

        while (!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();

            if (!isVisited[currentVertex.getVertex()]) {
                // check vertex
                System.out.println("currentVertex = " + currentVertex.getVertex());

                isVisited[currentVertex.getVertex()] = true;

                minWeight += currentVertex.getWeight();

                for (Vertex nextVertex : graph.get(currentVertex.getVertex())) {
                    if (!isVisited[nextVertex.getVertex()]) {
                        pq.offer(nextVertex);
                    }
                }
            }
        }

        return minWeight;
    }
}
