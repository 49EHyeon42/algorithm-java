import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    // Greedy 풀이 = 틀린 풀이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dp = new int[32769];
        dp[1] = 1;
        dp[2] = 6;

        for (int i = 3; i < dp.length; i++) {
            dp[i] = 6 * (i - 1) + dp[i - 1] - (3 + 2 * (i - 3));
        }

        int N = Integer.parseInt(br.readLine());

        int count = 0;

        int i = 32768;

        while (N != 0) {
            if (N - dp[i] >= 0) {
                System.out.println("dp[i] = " + dp[i]);

                N -= dp[i];
                count++;
            } else {
                i--;
            }
        }

        bw.write(Integer.toString(count));
        bw.flush();

        br.close();
        bw.close();
    }
}
