import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int weightNumber;

    private static int[] weights;
    private static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        weightNumber = Integer.parseInt(br.readLine());

        weights = new int[weightNumber + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < weightNumber; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        dp = new boolean[weightNumber + 1][40001];

        recursion(0, 0);

        int beadNumber = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < beadNumber; i++) {
            int beadWeight = Integer.parseInt(st.nextToken());

            if (beadWeight > 15000) { // max weight 500g * max number 30
                sb.append("N ");
            } else if (dp[weightNumber][beadWeight]) {
                sb.append("Y ");
            } else {
                sb.append("N ");
            }
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }

    private static void recursion(int index, int weight) {
        if (index > weightNumber || dp[index][weight]) {
            return;
        }
        dp[index][weight] = true;
        recursion(index + 1, weight);
        recursion(index + 1, weight + weights[index]);
        recursion(index + 1, Math.abs(weight - weights[index]));
    }
}
