import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 배열 겸 DP
        int[][] array = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                if (i == 0) {
                    array[i][j] += array[i][j - 1];
                } else if (j == 0) {
                    array[i][j] += array[i - 1][j];
                } else {
                    array[i][j] += Math.max(array[i - 1][j], array[i][j - 1]);
                }
            }
        }

        bw.write(Integer.toString(array[N - 1][M - 1]));
        bw.flush();

        br.close();
        bw.close();
    }
}
