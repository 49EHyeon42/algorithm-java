import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    private static int[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        isVisited = new int[N + 1];

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        for (int i = 1; i < tree.size(); i++) {
            tree.get(i).sort(Comparator.naturalOrder());
        }

        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < isVisited.length; i++) {
            sb.append(isVisited[i]).append('\n');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        isVisited[1] = 1;

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            for (int nextVertex : tree.get(currentVertex)) {
                if (isVisited[nextVertex] == 0) {
                    isVisited[nextVertex] = currentVertex;
                    queue.offer(nextVertex);
                }
            }
        }
    }
}
