import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution {

    public long solution(int N) {
        if (N == 1) {
            return 1;
        }

        long[] dp = new long[N + 1];

        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[N];
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Solution solution = new Solution();

        bw.write(Long.toString(solution.solution(Integer.parseInt(br.readLine()))));
        bw.flush();

        br.close();
        bw.close();
    }
}
