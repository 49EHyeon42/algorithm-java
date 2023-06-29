import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int bfs(List<List<Integer>> tree, int root, int cut) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(root);

        int count = 0;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            if (tree.get(currentNode).isEmpty()) {
                count++;
                continue;
            }

            for (int nextNode : tree.get(currentNode)) {
                if (nextNode == cut) {
                    if (tree.get(currentNode).size() == 1) {
                        count++;
                    }

                    continue;
                }

                queue.offer(nextNode);
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            tree.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int root = -1;

        for (int i = 0; i < N; i++) {
            int node = Integer.parseInt(st.nextToken());

            if (node == -1) {
                root = i;
                continue;
            }

            tree.get(node).add(i);
        }

        int cut = Integer.parseInt(br.readLine());

        bw.write(Integer.toString(N == 1 || root == cut ? 0 : bfs(tree, root, cut)));
        bw.flush();

        br.close();
        bw.close();
    }
}
