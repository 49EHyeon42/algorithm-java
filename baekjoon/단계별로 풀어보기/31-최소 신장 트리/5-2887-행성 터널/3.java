import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Kruskal's algorithm 3
public class Main {

    private static final PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(
        Comparator.comparing(Edge::getWeight));
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

            stars.add(new Star(i, x, y, z));
        }

        stars.sort(Comparator.comparingInt(Star::getX));
        for (int i = 0; i < starCount - 1; i++) {
            int distance = Math.abs(stars.get(i).getX() - stars.get(i + 1).getX());
            priorityQueue.add(
                new Edge(stars.get(i).getNumber(), stars.get(i + 1).getNumber(), distance));
        }

        stars.sort(Comparator.comparingInt(Star::getY));
        for (int i = 0; i < starCount - 1; i++) {
            int distance = Math.abs(stars.get(i).getY() - stars.get(i + 1).getY());
            priorityQueue.add(
                new Edge(stars.get(i).getNumber(), stars.get(i + 1).getNumber(), distance));
        }

        stars.sort(Comparator.comparingInt(Star::getZ));
        for (int i = 0; i < starCount - 1; i++) {
            int distance = Math.abs(stars.get(i).getZ() - stars.get(i + 1).getZ());
            priorityQueue.add(
                new Edge(stars.get(i).getNumber(), stars.get(i + 1).getNumber(), distance));
        }

        parent = new int[starCount];
        for (int i = 0; i < starCount; i++) {
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
