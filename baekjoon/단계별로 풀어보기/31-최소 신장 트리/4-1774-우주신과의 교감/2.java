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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int godCount = Integer.parseInt(st.nextToken());
        int connectCount = Integer.parseInt(st.nextToken());

        ArrayList<God> gods = new ArrayList<>();

        gods.add(null);
        for (int i = 1; i <= godCount; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            gods.add(new God(x, y));
        }

        parent = new int[godCount + 1];
        for (int i = 0; i <= godCount; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < connectCount; i++) {
            st = new StringTokenizer(br.readLine());
            int god1 = Integer.parseInt(st.nextToken());
            int god2 = Integer.parseInt(st.nextToken());

            merge(god1, god2);
        }

        for (int i = 1; i < godCount; i++) {
            for (int j = i + 1; j <= godCount; j++) {
                priorityQueue.add(
                    new Edge(i, j,
                        Math.sqrt(
                            Math.pow(gods.get(i).getX() - gods.get(j).getX(), 2)
                                + Math.pow(gods.get(i).getY() - gods.get(j).getY(), 2))));
            }
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

class God {

    private final double x;
    private final double y;

    public God(double x, double y) {
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
        return Double.compare(this.weight, o.weight);
    }
}
