import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long K = Long.parseLong(br.readLine());

        long start = 1;
        long end = K;

        while (start < end) {
            long count = 0;
            long mid = (start + end) / 2;

            for (int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }

            if (count >= K) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        bw.write(Long.toString(start));

        bw.flush();
        bw.close();
    }
}
