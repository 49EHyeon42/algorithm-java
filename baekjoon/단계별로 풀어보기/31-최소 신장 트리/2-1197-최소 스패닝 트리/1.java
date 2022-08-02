import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

// Kruskal's algorithm
public class Main {

    private static final ArrayList<Edge> graph = new ArrayList<>();
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertexCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int startVertex = Integer.parseInt(st.nextToken());
            int endVertex = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.add(new Edge(startVertex, endVertex, weight));
        }

        graph.sort(Comparator.comparingInt(Edge::getWeight));

        parent = new int[vertexCount + 1];
        for (int i = 0; i <= vertexCount; i++) {
            parent[i] = i;
        }

        int minWeight = 0;
        for (int i = 0; i < edgeCount; i++) {
            Edge edge = graph.get(i);
            if (!isUnion(edge.getStartVertex(), edge.getEndVertex())) {
                merge(edge.getStartVertex(), edge.getEndVertex());

                minWeight += edge.getWeight();
            }
        }

        bw.write(Integer.toString(minWeight));

        bw.flush();
        bw.close();
    }

    private static void merge(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
        }
    }

    private static boolean isUnion(int x, int y) {
        return find(x) == find(y);
    }

    private static int find(int index) {
        return (parent[index] == index) ? index : (parent[index] = find(parent[index]));
    }
}

class Edge {

    private final int startVertex;
    private final int endVertex;
    private final int weight;

    public Edge(int startVertex, int endVertex, int weight) {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.weight = weight;
    }

    public int getStartVertex() {
        return startVertex;
    }

    public int getEndVertex() {
        return endVertex;
    }

    public int getWeight() {
        return weight;
    }
}
