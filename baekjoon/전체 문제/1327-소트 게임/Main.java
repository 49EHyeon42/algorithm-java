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

        StringBuilder sb = new StringBuilder();

        int[] temp = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            String string = st.nextToken();

            sb.append(string);

            temp[i] = Integer.parseInt(string);
        }

        String startString = sb.toString();

        Arrays.sort(temp);

        // StringBuilder clear
        sb.setLength(0);

        for (int i : temp) {
            sb.append(i);
        }

        bw.write(Integer.toString(bfs(startString, sb.toString())));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int bfs(String startString, String endString) {
        Set<String> visited = new HashSet<>();

        Queue<Vertex> queue = new ArrayDeque<>();

        visited.add(startString);

        queue.offer(new Vertex(startString, 0));

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            if (currentVertex.string.equals(endString)) {
                return currentVertex.weight;
            }

            for (int i = 0; i <= N - K; i++) {
                String nextString = getNextString(currentVertex.string, i, i + K);

                if (visited.contains(nextString)) {
                    continue;
                }

                visited.add(nextString);

                queue.offer(new Vertex(nextString, currentVertex.weight + 1));
            }
        }

        return -1;
    }

    private static String getNextString(String string, int i, int j) {
        StringBuilder sb = new StringBuilder();

        sb.append(string, 0, i);

        String reverseString = string.substring(i, j);

        for (int k = K - 1; k >= 0; k--) {
            sb.append(reverseString.charAt(k));
        }

        sb.append(string, j, N);

        return sb.toString();
    }

    private static class Vertex {

        final String string;
        final int weight;

        Vertex(String string, int weight) {
            this.string = string;
            this.weight = weight;
        }
    }
}
