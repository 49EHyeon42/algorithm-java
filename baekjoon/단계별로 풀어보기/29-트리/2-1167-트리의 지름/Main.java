import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

// reference : https://bedamino.tistory.com/15
public class Main {

    private static final ArrayList<ArrayList<Node>> tree = new ArrayList<>();
    private static boolean[] isVisited;

    private static int maxDiameter, endVertex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int V = Integer.parseInt(br.readLine());

        for (int i = 0; i <= V; i++) {
            tree.add(new ArrayList<>());
        }

        isVisited = new boolean[V + 1];

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int vertexNumber = Integer.parseInt(st.nextToken());

            while (true) {
                String temp = st.nextToken();
                if (temp.equals("-1")) {
                    break;
                }

                int number = Integer.parseInt(temp);
                int weight = Integer.parseInt(st.nextToken());

                tree.get(vertexNumber).add(new Node(number, weight));
                tree.get(number).add(new Node(vertexNumber, weight));
            }
        }

        maxDiameter = Integer.MIN_VALUE;
        dfs(1, 0);

        isVisited = new boolean[V + 1];
        maxDiameter = Integer.MIN_VALUE;
        dfs(endVertex, 0);

        bw.write(Integer.toString(maxDiameter));

        bw.flush();
        bw.close();
    }

    private static void dfs(int currentVertex, int diameter) {
        if (isVisited[currentVertex]) {
            return;
        }

        if (maxDiameter < diameter) {
            endVertex = currentVertex;
            maxDiameter = diameter;
        }

        isVisited[currentVertex] = true;
        for (Node nextVertex : tree.get(currentVertex)) {
            if (!isVisited[nextVertex.getNumber()]) {
                dfs(nextVertex.getNumber(), nextVertex.getWeight() + diameter);
            }
        }
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
