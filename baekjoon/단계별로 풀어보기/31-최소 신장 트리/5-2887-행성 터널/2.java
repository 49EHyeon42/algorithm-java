import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Kruskal's algorithm 2 : 1번 풀이 개정판, 메모리 초과
public class Main {

    private static final ArrayList<Edge> graph = new ArrayList<>();
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int starCount = Integer.parseInt(br.readLine());

        PriorityQueue<Star> starsX = new PriorityQueue<>(Comparator.comparing(Star::getX));
        PriorityQueue<Star> starsY = new PriorityQueue<>(Comparator.comparing(Star::getY));
        PriorityQueue<Star> starsZ = new PriorityQueue<>(Comparator.comparing(Star::getZ));

        for (int i = 0; i < starCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            Star newStar = new Star(i, x, y, z);

            starsX.add(newStar);
            starsY.add(newStar);
            starsZ.add(newStar);
        }

        Star currentStar = starsX.poll();
        while (!starsX.isEmpty()) {
            Star nextStar = starsX.poll();
            int distance = Math.abs(currentStar.getX() - nextStar.getX());
            graph.add(new Edge(currentStar.getNumber(), nextStar.getNumber(), distance));
            currentStar = nextStar;
        }

        currentStar = starsY.poll();
        while (!starsY.isEmpty()) {
            Star nextStar = starsY.poll();
            int distance = Math.abs(currentStar.getY() - nextStar.getY());
            graph.add(new Edge(currentStar.getNumber(), nextStar.getNumber(), distance));
            currentStar = nextStar;
        }

        currentStar = starsZ.poll();
        while (!starsZ.isEmpty()) {
            Star nextStar = starsZ.poll();
            int distance = Math.abs(currentStar.getZ() - nextStar.getZ());
            graph.add(new Edge(currentStar.getNumber(), nextStar.getNumber(), distance));
            currentStar = nextStar;
        }

        graph.sort(Comparator.comparingInt(Edge::getWeight));

        parent = new int[starCount];
        for (int i = 0; i < starCount; i++) {
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

    private final int number;
    private final int x;
    private final int y;
    private final int z;

    public Star(int number, int x, int y, int z) {
        this.number = number;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getNumber() {
        return number;
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
