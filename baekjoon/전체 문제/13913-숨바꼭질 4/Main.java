import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bw.write(bfs());
        bw.flush();

        br.close();
        bw.close();
    }

    private static String bfs() {
        // -2 = 마지막, -1 = 방문 X, etc = 이전 방문 vertex
        int[] visited = new int[100001];

        Arrays.fill(visited, -1);

        visited[N] = -2;

        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(N);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            if (currentVertex == K) {
                int count = 0;

                Stack<Integer> stack = new Stack<>();

                while (currentVertex != -2) {
                    count++;

                    stack.push(currentVertex);

                    currentVertex = visited[currentVertex];
                }

                StringBuilder sb = new StringBuilder(count - 1 + "\n");

                while (!stack.isEmpty()) {
                    sb.append(stack.pop()).append(' ');
                }

                return sb.toString().trim();
            }

            int nextVertex = currentVertex - 1;

            if (nextVertex > -1 && visited[nextVertex] == -1) {
                visited[nextVertex] = currentVertex;

                queue.offer(nextVertex);
            }

            nextVertex = currentVertex + 1;

            if (nextVertex < 100001 && visited[nextVertex] == -1) {
                visited[nextVertex] = currentVertex;

                queue.offer(nextVertex);
            }

            nextVertex = currentVertex * 2;

            if (nextVertex < 100001 && visited[nextVertex] == -1) {
                visited[nextVertex] = currentVertex;

                queue.offer(nextVertex);
            }
        }

        throw new RuntimeException();
    }
}
