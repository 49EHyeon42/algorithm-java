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

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        isVisited = new boolean[N + 1];

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree.get(parent).add(new Node(child, weight));
            tree.get(child).add(new Node(parent, weight));
        }

        maxDiameter = Integer.MIN_VALUE;
        dfs(1, 0);

        isVisited = new boolean[N + 1];
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
