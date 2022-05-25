import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[][] array;
    private static int[][] dpArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        if (N == 1) {
            bw.write(br.readLine());
        } else {
            array = new int[N][N];
            dpArray = new int[N][N];
            for (int[] ints : dpArray) {
                Arrays.fill(ints, -1);
            }

            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j <= i; j++) {
                    array[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if (N >= 0)
                System.arraycopy(array[N - 1], 0, dpArray[N - 1], 0, N);

            bw.write(Integer.toString(recursive(0, 0)));
        }

        bw.flush();
        bw.close();
    }

    public static int recursive(int depth, int index) {
        if (depth == N - 1) {
            return dpArray[depth][index];
        }

        if (dpArray[depth][index] == -1) {
            dpArray[depth][index] = Integer.max(recursive(depth + 1, index),
                recursive(depth + 1, index + 1)) + array[depth][index];
        }

        return dpArray[depth][index];
    }
}
