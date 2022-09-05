import java.util.ArrayList;

public class Graph {

    private final ArrayList<Edge> edges = new ArrayList<>();

    public void addEdge(int vertex1, int vertex2, int weight) {
        edges.add(new Edge(vertex1, vertex2, weight));
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }
}
