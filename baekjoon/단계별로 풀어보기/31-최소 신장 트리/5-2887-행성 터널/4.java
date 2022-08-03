import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Prim's algorithm
public class Main {

    private static final ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int starCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < starCount; i++) {
            graph.add(new ArrayList<>());
        }

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
            graph.get(stars.get(i).getNumber())
                .add(new Node(stars.get(i + 1).getNumber(), distance));
            graph.get(stars.get(i + 1).getNumber())
                .add(new Node(stars.get(i).getNumber(), distance));
        }

        stars.sort(Comparator.comparingInt(Star::getY));
        for (int i = 0; i < starCount - 1; i++) {
            int distance = Math.abs(stars.get(i).getY() - stars.get(i + 1).getY());
            graph.get(stars.get(i).getNumber())
                .add(new Node(stars.get(i + 1).getNumber(), distance));
            graph.get(stars.get(i + 1).getNumber())
                .add(new Node(stars.get(i).getNumber(), distance));
        }

        stars.sort(Comparator.comparingInt(Star::getZ));
        for (int i = 0; i < starCount - 1; i++) {
            int distance = Math.abs(stars.get(i).getZ() - stars.get(i + 1).getZ());
            graph.get(stars.get(i).getNumber())
                .add(new Node(stars.get(i + 1).getNumber(), distance));
            graph.get(stars.get(i + 1).getNumber())
                .add(new Node(stars.get(i).getNumber(), distance));
        }

        bw.write(Integer.toString(primAlgorithm(starCount)));

        bw.flush();
        bw.close();
    }

    private static int primAlgorithm(int vertexCount) {
        int minWeight = 0;

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(
            Comparator.comparing(Node::getWeight));
        boolean[] isVisited = new boolean[vertexCount + 1];

        priorityQueue.add(new Node(0, 0));

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

class Node {

    private final int number;
    private final int weight;

    public Node(int number, int weight) {
        this.number = number;
        this.weight = weight;
    }

    public int getNumber() {
        return number;
    }

    public int getWeight() {
        return weight;
    }
}
