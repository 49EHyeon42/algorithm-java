import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int[] array = new int[1001];
        int[] prefixSum = new int[1001];

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            int max = Integer.MIN_VALUE;

            for (int i = 1; i <= N; i++) {
                array[i] = Integer.parseInt(st.nextToken());

                prefixSum[i] = Math.max(prefixSum[i - 1] + array[i], array[i]);

                max = Math.max(max, prefixSum[i]);
            }

            sb.append(max).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }
}
