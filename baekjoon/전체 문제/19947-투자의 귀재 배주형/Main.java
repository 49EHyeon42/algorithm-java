import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int[] dp = new int[Y + 1];
        dp[0] = H;

        for (int i = 1; i <= Y; i++) {
            dp[i] = Math.max((int) (dp[i - 1] * 1.05),
                    Math.max(i > 2 ? (int) (dp[i - 3] * 1.2) : 0,
                            i > 4 ? (int) (dp[i - 5] * 1.35) : 0));
        }

        bw.write(Integer.toString(dp[Y]));
        bw.flush();

        br.close();
        bw.close();
    }
}
