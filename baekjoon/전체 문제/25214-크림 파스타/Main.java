import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int min = array[0];

        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            if (min > array[i]) {
                min = array[i];
            }

            dp[i] = Math.max(array[i] - min, dp[i - 1]);
        }

        StringBuilder sb = new StringBuilder();

        for (int i : dp) {
            sb.append(i).append(' ');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }
}
