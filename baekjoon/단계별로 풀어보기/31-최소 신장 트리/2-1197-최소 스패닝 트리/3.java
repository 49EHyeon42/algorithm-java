import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Kruskal's algorithm 2
public class Main {

    private static final PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
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

            priorityQueue.add(new Edge(startVertex, endVertex, weight));
        }

        parent = new int[vertexCount + 1];

        for (int i = 0; i <= vertexCount; i++) {
            parent[i] = i;
        }

        int minWeight = 0;

        while (!priorityQueue.isEmpty()) {
            Edge currentEdge = priorityQueue.poll();

            if (!isUnion(currentEdge.getStartVertex(), currentEdge.getEndVertex())) {
                minWeight += currentEdge.getWeight();

                merge(currentEdge.getStartVertex(), currentEdge.getEndVertex());
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

class Edge implements Comparable<Edge> {

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

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}
