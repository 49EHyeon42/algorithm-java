import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Node[] dp = new Node[41];
        dp[0] = new Node(1, 0);
        dp[1] = new Node(0, 1);

        for (int i = 2; i < 41; i++) {
            int numberOfZero = dp[i - 1].numberOfZero + dp[i - 2].numberOfZero;
            int numberOfOne = dp[i - 1].numberOfOne + dp[i - 2].numberOfOne;

            dp[i] = new Node(numberOfZero, numberOfOne);
        }

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            sb.append(dp[N].numberOfZero).append(' ').append(dp[N].numberOfOne).append('\n');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }

    private static class Node {

        final int numberOfZero;
        final int numberOfOne;

        Node(int numberOfZero, int numberOfOne) {
            this.numberOfZero = numberOfZero;
            this.numberOfOne = numberOfOne;
        }
    }
}
