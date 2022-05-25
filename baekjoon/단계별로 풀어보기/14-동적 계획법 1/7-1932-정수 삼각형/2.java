import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            bw.write(br.readLine());
        } else {
            int[][] dpArray = new int[N][N];

            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j <= i; j++) {
                    dpArray[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = N - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    dpArray[i - 1][j] += Integer.max(dpArray[i][j], dpArray[i][j + 1]);
                }
            }

            bw.write(Integer.toString(dpArray[0][0]));
        }

        bw.flush();
        bw.close();
    }

}
