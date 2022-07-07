import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bw.write(Integer.toString(bfs(N, K)));

        bw.flush();
        bw.close();
    }

    private static int bfs(int n, int k) {
        int MAX_SIZE = 100000;

        Queue<Integer> queue = new LinkedList<>();
        int[] isVisited = new int[MAX_SIZE + 1];

        queue.offer(n);
        isVisited[n] = 1;

        while (!queue.isEmpty()) {
            int currentPoint = queue.poll();

            if (currentPoint == k) {
                return isVisited[currentPoint] - 1;
            }

            if (currentPoint - 1 >= 0 && isVisited[currentPoint - 1] == 0) {
                queue.offer(currentPoint - 1);
                isVisited[currentPoint - 1] = isVisited[currentPoint] + 1;
            }
            if (currentPoint + 1 <= MAX_SIZE && isVisited[currentPoint + 1] == 0) {
                queue.offer(currentPoint + 1);
                isVisited[currentPoint + 1] = isVisited[currentPoint] + 1;
            }
            if (currentPoint * 2 <= MAX_SIZE && isVisited[currentPoint * 2] == 0) {
                queue.offer(currentPoint * 2);
                isVisited[currentPoint * 2] = isVisited[currentPoint] + 1;
            }
        }

        return -1;
    }
}
