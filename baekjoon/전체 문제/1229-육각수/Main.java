import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static int solution(int N) {
        int[] dp = N < 13 ? new int[13] : new int[N + 1];

        initDp(dp);

        if (N < 13) {
            return dp[N];
        }

        List<Integer> hexagonalNumbers = getHexagonalNumbers(N);

        for (int i = 13; i <= N; i++) {
            int min = Integer.MAX_VALUE;

            for (int hexagonalNumber : hexagonalNumbers) {
                if (hexagonalNumber > i) {
                    break;
                }

                min = Math.min(min, dp[i - hexagonalNumber]);
            }

            dp[i] = min + 1;
        }

        return dp[N];
    }

    private static void initDp(int[] dp) {
        dp[0] = 0;
        dp[1] = dp[6] = 1;
        dp[2] = dp[7] = dp[12] = 2;
        dp[3] = dp[8] = 3;
        dp[4] = dp[9] = 4;
        dp[5] = dp[10] = 5;
        dp[11] = 6;
    }

    private static List<Integer> getHexagonalNumbers(int maxNumber) {
        List<Integer> list = new ArrayList<>();

        list.add(1);

        while (list.get(list.size() - 1) <= maxNumber) {
            list.add((list.size() + 1) * (2 * list.size() + 1)); // 육각수 공식 응용
        }

        return list;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        bw.write(Integer.toString(solution(N)));
        bw.flush();

        br.close();
        bw.close();
    }

    // Another Solution : https://www.acmicpc.net/source/54580096
}
