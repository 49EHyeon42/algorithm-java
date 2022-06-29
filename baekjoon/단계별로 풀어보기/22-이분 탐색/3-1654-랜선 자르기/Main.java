import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] array = new long[K];
        for (int i = 0; i < K; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        long start = 0;
        long end = Arrays.stream(array).max().getAsLong() + 1;

        while (start < end) {
            long count = 0;
            long mid = (start + end) / 2;

            for (int i = 0; i < K; i++) {
                count += array[i] / mid;
            }

            if (count < N) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        bw.write(Long.toString(start - 1));

        bw.flush();
        bw.close();
    }
}
