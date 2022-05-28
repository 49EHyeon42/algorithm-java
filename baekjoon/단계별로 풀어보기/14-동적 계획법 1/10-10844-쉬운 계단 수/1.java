import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static final long MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // int[length][number of stairs]
        long[][] dpArray = new long[N + 1][10];

        for (int i = 1; i < 10; i++) {
            dpArray[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dpArray[i][0] = dpArray[i - 1][1];
                } else if (j == 9) {
                    dpArray[i][9] = dpArray[i - 1][8];
                } else {
                    dpArray[i][j] = dpArray[i - 1][j - 1] + dpArray[i - 1][j + 1];
                }
                dpArray[i][j] %= MOD;
            }
        }

        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += dpArray[N][i];
        }

        bw.write(Long.toString(answer % MOD));

        bw.flush();
        bw.close();
    }
}
