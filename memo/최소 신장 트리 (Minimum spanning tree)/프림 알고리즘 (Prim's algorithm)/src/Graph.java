import java.util.ArrayList;

public class Graph {

    private final ArrayList<ArrayList<Vertex>> graph = new ArrayList<>();

    public Graph(int vertexCount) {
        for (int i = 0; i <= vertexCount; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void addEdge(int vertex1, int vertex2, int weight) {
        graph.get(vertex1).add(new Vertex(vertex2, weight));
        graph.get(vertex2).add(new Vertex(vertex1, weight));

    }

    public ArrayList<ArrayList<Vertex>> getGraph() {
        return graph;
    }
}
