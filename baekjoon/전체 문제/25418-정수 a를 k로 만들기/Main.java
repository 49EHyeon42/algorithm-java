import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int bfs(int A, int K) {
        if (A == K) {
            return 0;
        }

        int[] visit = new int[K + 1];

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(A);

        while (!queue.isEmpty()) {
            int currentNumber = queue.poll();

            if (currentNumber == K) {
                return visit[currentNumber];
            }

            int nextNumber = currentNumber + 1;
            if (nextNumber <= K && visit[nextNumber] == 0) {
                visit[nextNumber] = visit[currentNumber] + 1;
                queue.offer(nextNumber);
            }

            nextNumber = currentNumber * 2;
            if (nextNumber <= K && visit[nextNumber] == 0) {
                visit[nextNumber] = visit[currentNumber] + 1;
                queue.offer(nextNumber);
            }
        }

        return -1;
    }

    private static int dp(int A, int K) {
        int count = 0;

        while (A != K) {
            if ((K & 1) == 0 && A <= K / 2) {
                K /= 2;
            } else {
                K--;
            }

            count++;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // bfs(), dp() 선택
        bw.write(Integer.toString(dp(A, K)));
        bw.flush();

        br.close();
        bw.close();
    }
}
