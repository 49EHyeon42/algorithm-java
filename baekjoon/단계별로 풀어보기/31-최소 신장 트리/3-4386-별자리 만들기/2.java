import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Kruskal's algorithm 2
public class Main {

    private static final PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int starCount = Integer.parseInt(br.readLine());

        ArrayList<Star> stars = new ArrayList<>();

        for (int i = 0; i < starCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            stars.add(new Star(x, y));
        }

        for (int i = 0; i < starCount - 1; i++) {
            for (int j = i + 1; j < starCount; j++) {
                priorityQueue.add(
                    new Edge(i, j,
                        Math.sqrt(
                            Math.pow(stars.get(i).getX() - stars.get(j).getX(), 2)
                                + Math.pow(stars.get(i).getY() - stars.get(j).getY(), 2))));
            }
        }

        parent = new int[starCount + 1];
        for (int i = 0; i <= starCount; i++) {
            parent[i] = i;
        }

        double minWeight = 0;

        while (!priorityQueue.isEmpty()) {
            Edge currentEdge = priorityQueue.poll();

            if (!isUnion(currentEdge.getStartVertex(), currentEdge.getEndVertex())) {
                minWeight += currentEdge.getWeight();

                merge(currentEdge.getStartVertex(), currentEdge.getEndVertex());
            }
        }

        bw.write(String.format("%.2f", minWeight));

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

    private final double x;
    private final double y;

    public Star(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

class Edge implements Comparable<Edge> {

    private final int startVertex;
    private final int endVertex;
    private final double weight;

    public Edge(int startVertex, int endVertex, double weight) {
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

    public double getWeight() {
        return weight;
    }


    @Override
    public int compareTo(Edge o) {
        return (int) (this.weight - o.weight);
    }
}
