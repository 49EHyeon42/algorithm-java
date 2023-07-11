import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static final int[] array = {1, 5, 10, 50};

    private static int N;
    private static boolean[] visited;
    private static int count;

    // 중복 조합
    private static void solution(int currentDepth, int index, int sum) {
        if (currentDepth == N) {
            if (!visited[sum]) {
                count++;
                visited[sum] = true;
            }
            return;
        }

        for (int i = index; i < 4; i++) {
            solution(currentDepth + 1, i, sum + array[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N * 50 + 1];

        solution(0, 0, 0);

        bw.write(Integer.toString(count));
        bw.flush();

        br.close();
        bw.close();
    }
}
