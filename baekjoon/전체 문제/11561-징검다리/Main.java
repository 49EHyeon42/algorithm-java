import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            sb.append(binarySearch(Long.parseLong(br.readLine()))).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static long binarySearch(long N) {
        long left = 1;
        long right = (long) Math.sqrt(2 * N - 1);

        while (left <= right) {
            long mid = (left + right) / 2;

            // sum = 1 + 2 + 3 + ... + N
            long sum = mid * (mid + 1) / 2;

            if (sum > N) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }
}
