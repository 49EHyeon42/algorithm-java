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

        /*
         * = x1x2 + x1x3 + ... + xn-1xn
         * = x1(x2 + x3 + ... + xn) + x2(x3 + x4 + ... + xn) + ... + xn-1(xn)
         * */

        long prefixSum = 0;

        long sum = 0;

        for (int i = n - 1; i > 0; i--) {
            prefixSum += array[i];

            sum += array[i - 1] * prefixSum;
        }

        bw.write(Long.toString(sum));
        bw.flush();

        br.close();
        bw.close();
    }
}
