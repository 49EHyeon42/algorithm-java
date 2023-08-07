import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;

    private static int[][] matrix;

    private static int count;

    private static void backtracking(int depth) {
        if (depth == N * M) {
            count++;
            return;
        }

        int nextY = depth / M + 1;
        int nextX = depth % M + 1;

        backtracking(depth + 1);

        if (matrix[nextY - 1][nextX - 1] == 0 || matrix[nextY - 1][nextX] == 0 || matrix[nextY][nextX - 1] == 0) {
            matrix[nextY][nextX] = 1;
            backtracking(depth + 1);
            matrix[nextY][nextX] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N + 1][M + 1];

        backtracking(0);

        bw.write(Integer.toString(count));
        bw.flush();

        br.close();
        bw.close();
    }
}
