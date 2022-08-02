import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Prim's algorithm
public class Main {

    private static final ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int starCount = Integer.parseInt(br.readLine());

        for (int i = 0; i <= starCount; i++) {
            graph.add(new ArrayList<>());
        }

        ArrayList<Star> stars = new ArrayList<>();

        for (int i = 0; i < starCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            stars.add(new Star(x, y));
        }

        for (int i = 0; i < starCount - 1; i++) {
            for (int j = i + 1; j < starCount; j++) {
                double sqrt = Math.sqrt(
                    Math.pow(stars.get(i).getX() - stars.get(j).getX(), 2)
                        + Math.pow(stars.get(i).getY() - stars.get(j).getY(), 2));

                graph.get(i).add(new Node(j, sqrt));
                graph.get(j).add(new Node(i, sqrt));
            }
        }

        bw.write(String.format("%.2f", primAlgorithm(starCount)));

        bw.flush();
        bw.close();
    }

    private static double primAlgorithm(int vertexCount) {
        double minWeight = 0;

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        boolean[] isVisited = new boolean[vertexCount + 1];

        priorityQueue.add(new Node(1, 0));

        int loopCount = 0;
        while (!priorityQueue.isEmpty()) {
            Node currentNode = priorityQueue.poll();

            if (!isVisited[currentNode.getNumber()]) {
                minWeight += currentNode.getWeight();

                isVisited[currentNode.getNumber()] = true;

                for (Node nextNode : graph.get(currentNode.getNumber())) {
                    if (!isVisited[nextNode.getNumber()]) {
                        priorityQueue.add(nextNode);
                    }
                }

                if (++loopCount == vertexCount) {
                    break;
                }
            }
        }

        return minWeight;
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

class Node implements Comparable<Node> {

    private final int number;
    private final double weight;

    public Node(int number, double weight) {
        this.number = number;
        this.weight = weight;
    }

    public int getNumber() {
        return number;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Node o) {
        return (int) (this.weight - o.weight);
    }
}
