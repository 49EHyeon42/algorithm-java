import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertexCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());

        int[] countOfEdge = new int[vertexCount + 1];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= vertexCount; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());

            countOfEdge[vertex2]++;
            graph.get(vertex1).add(vertex2);
        }

        // 위상 정렬(Topological Sort)
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= vertexCount; i++) {
            if (countOfEdge[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            sb.append(currentVertex).append(' ');

            for (int nextVertex : graph.get(currentVertex)) {
                countOfEdge[nextVertex]--;

                if (countOfEdge[nextVertex] == 0) {
                    queue.offer(nextVertex);
                }
            }
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }
}
