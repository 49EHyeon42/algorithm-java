import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final Queue<Integer> queue = new LinkedList<>();

    private static int bfs(int[][] tree, int startNode, int endNode) {
        queue.clear();

        int[] lengths = new int[tree.length];
        Arrays.fill(lengths, -1);

        lengths[startNode] = 0;
        queue.offer(startNode);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            if (currentNode == endNode) {
                return lengths[endNode];
            }

            for (int nextNode = 1; nextNode < tree.length; nextNode++) {
                if (tree[currentNode][nextNode] != 0 && lengths[nextNode] == -1) {
                    lengths[nextNode] = lengths[currentNode] + tree[currentNode][nextNode];
                    queue.offer(nextNode);
                }
            }
        }

        return lengths[endNode];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] tree = new int[N + 1][N + 1];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            tree[node1][node2] = tree[node2][node1] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());

            sb.append(bfs(tree, startNode, endNode)).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }
}
