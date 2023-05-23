import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static int sum = 0;

    private static void recursiveSolution(int A) {
        if (A == 1) {
            return;
        }

        int B;
        int C;

        if ((A & 1) == 0) {
            B = C = A / 2;
        } else {
            B = A / 2 + 1;
            C = A / 2;
        }

        sum += B * C;

        recursiveSolution(B);
        recursiveSolution(C);
    }

    private static int repetitiveSolution(int N) {
        int[] dp = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + i - 1;
        }

        return dp[N];
    }

    private static int anotherSolution(int N) {
        return N * (N - 1) / 2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        bw.write(Integer.toString(anotherSolution(N)));
        bw.flush();

        br.close();
        bw.close();
    }
}
