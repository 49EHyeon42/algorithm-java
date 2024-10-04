import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bw.write(Integer.toString(solution(N, K)));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int solution(int N, int K) {
        boolean[] visited = new boolean[N + 1];

        for (int i = 2, count = 0; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int index = i * j;

                if (index > N) {
                    break;
                }

                if (visited[index]) {
                    continue;
                }

                visited[index] = true;

                count++;

                if (count == K) {
                    return index;
                }
            }
        }

        return -1;
    }
}
