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
        int godCount = Integer.parseInt(st.nextToken());
        int connectCount = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= godCount; i++) {
            graph.add(new ArrayList<>());
        }

        ArrayList<God> gods = new ArrayList<>();

        gods.add(null);
        for (int i = 1; i <= godCount; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            gods.add(new God(x, y));
        }

        boolean[][] isConnectGod = new boolean[godCount + 1][godCount + 1];

        for (int i = 0; i < connectCount; i++) {
            st = new StringTokenizer(br.readLine());
            int god1 = Integer.parseInt(st.nextToken());
            int god2 = Integer.parseInt(st.nextToken());

            isConnectGod[god1][god2] = true;
            isConnectGod[god2][god1] = true;
        }

        for (int i = 1; i < godCount; i++) {
            for (int j = i + 1; j <= godCount; j++) {
                double sqrt = (isConnectGod[i][j]) ? 0 :
                    Math.sqrt(
                        Math.pow(gods.get(i).getX() - gods.get(j).getX(), 2)
                            + Math.pow(gods.get(i).getY() - gods.get(j).getY(), 2));

                graph.get(i).add(new Node(j, sqrt));
                graph.get(j).add(new Node(i, sqrt));
            }
        }

        bw.write(String.format("%.2f", primAlgorithm(godCount)));

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
        return Double.compare(this.weight, o.weight);
    }
}
