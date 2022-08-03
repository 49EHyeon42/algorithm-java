import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

// Kruskal's algorithm 1 : 메모리 초과
public class Main {

    private static final ArrayList<Edge> graph = new ArrayList<>();
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int starCount = Integer.parseInt(br.readLine());

        ArrayList<Star> stars = new ArrayList<>();

        for (int i = 0; i < starCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            stars.add(new Star(x, y, z));
        }

        stars.sort(Comparator.comparingInt(Star::getX));
        for (int i = 0; i < starCount - 1; i++) {
            for (int j = i + 1; j < starCount; j++) {
                int distance = Math.abs(stars.get(i).getX() - stars.get(j).getX());
                graph.add(new Edge(i, j, distance));
            }
        }

        stars.sort(Comparator.comparingInt(Star::getY));
        for (int i = 0; i < starCount - 1; i++) {
            for (int j = i + 1; j < starCount; j++) {
                int distance = Math.abs(stars.get(i).getY() - stars.get(j).getY());
                graph.add(new Edge(i, j, distance));
            }
        }

        stars.sort(Comparator.comparingInt(Star::getZ));
        for (int i = 0; i < starCount - 1; i++) {
            for (int j = i + 1; j < starCount; j++) {
                int distance = Math.abs(stars.get(i).getZ() - stars.get(j).getZ());
                graph.add(new Edge(i, j, distance));
            }
        }

        graph.sort(Comparator.comparingInt(Edge::getWeight));

        parent = new int[starCount + 1];
        for (int i = 0; i <= starCount; i++) {
            parent[i] = i;
        }

        int minWeight = 0;
        for (Edge edge : graph) {
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

class Star {

    private final int x;
    private final int y;
    private final int z;

    public Star(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
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
