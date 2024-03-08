import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final Queue<Vertex> queue = new LinkedList<>();
    private static final boolean[] primeNumbers = sieveOfEratosthenes();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int result = bfs(A, B);

            sb.append(result == -1 ? "Impossible" : result).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static boolean[] sieveOfEratosthenes() {
        boolean[] primeNumbers = new boolean[10001];

        Arrays.fill(primeNumbers, true);

        primeNumbers[0] = primeNumbers[1] = false;

        for (int i = 2; i * i <= 10000; i++) {
            if (primeNumbers[i]) {
                for (int j = i * i; j <= 10000; j += i) {
                    primeNumbers[j] = false;
                }
            }
        }

        return primeNumbers;
    }

    private static int bfs(int A, int B) {
        boolean[] visited = new boolean[10001];

        queue.clear();

        visited[A] = true;

        queue.offer(new Vertex(A, 0));

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            if (currentVertex.number == B) {
                return currentVertex.weight;
            }

            StringBuilder sb = new StringBuilder(Integer.toString(currentVertex.number));

            for (int i = 0; i < 4; i++) {
                char temp = sb.charAt(i);

                for (int j = 0; j <= 9; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }

                    sb.setCharAt(i, (char) (j + '0'));

                    int nextNumber = Integer.parseInt(sb.toString());

                    if (primeNumbers[nextNumber] && !visited[nextNumber]) {
                        visited[nextNumber] = true;

                        queue.offer(new Vertex(nextNumber, currentVertex.weight + 1));
                    }

                    sb.setCharAt(i, temp);
                }
            }
        }

        return -1;
    }

    private static class Vertex {

        int number;
        int weight;

        Vertex(int number, int weight) {
            this.number = number;
            this.weight = weight;
        }
    }
}
