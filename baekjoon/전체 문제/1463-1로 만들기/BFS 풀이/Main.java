import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        bw.write(Integer.toString(bfs(N)));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int bfs(int N) {
        Queue<Integer> queue = new LinkedList<>();

        int[] visited = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            visited[i] = -1;
        }

        queue.offer(N);
        visited[N] = 0;

        while (!queue.isEmpty()) {
            int currentNumber = queue.poll();

            if (currentNumber == 1) {
                return visited[currentNumber];
            }

            if (currentNumber % 3 == 0) {
                int nextNumber = currentNumber / 3;

                if (nextNumber != 0 && visited[nextNumber] == -1) {
                    queue.offer(nextNumber);
                    visited[nextNumber] = visited[currentNumber] + 1;
                }
            }

            if (currentNumber % 2 == 0) {
                int nextNumber = currentNumber / 2;

                if (nextNumber != 0 && visited[nextNumber] == -1) {
                    queue.offer(nextNumber);
                    visited[nextNumber] = visited[currentNumber] + 1;
                }
            }

            int nextNumber = currentNumber - 1;

            if (visited[nextNumber] == -1) {
                queue.offer(nextNumber);
                visited[nextNumber] = visited[currentNumber] + 1;
            }
        }

        return -1;
    }
}
