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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertexCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= vertexCount; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int startVertex = Integer.parseInt(st.nextToken());
            int endVertex = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(startVertex).add(new Node(endVertex, weight));
            graph.get(endVertex).add(new Node(startVertex, weight));
        }

        bw.write(Integer.toString(primAlgorithm(vertexCount)));

        bw.flush();
        bw.close();
    }

    private static int primAlgorithm(int VertexCount) {
        int minWeight = 0;

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        boolean[] isVisited = new boolean[VertexCount + 1];

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

                if (++loopCount == VertexCount) {
                    break;
                }
            }
        }

        return minWeight;
    }
}

class Node implements Comparable<Node> {

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


    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}
