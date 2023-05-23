import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    // reference : https://moz1e.tistory.com/499

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[31];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < 31; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int A = 1; // A를 1부터 탐색
        int B;

        while (true) {
            int i = K - dp[D - 3] * A;

            if (i % dp[D - 2] == 0) {
                B = i / dp[D - 2];
                break;
            }
            A++;
        }

        bw.write(String.format("%d\n%d", A, B));
        bw.flush();

        br.close();
        bw.close();
    }
}
