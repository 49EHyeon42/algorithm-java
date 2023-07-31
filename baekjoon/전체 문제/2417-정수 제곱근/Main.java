import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    // binary search
    private static long sqrt(long number) {
        long result = 0;

        long start = 0;
        long end = number;

        while (start <= end) {
            long mid = (start + end) / 2;

            if (Math.pow(mid, 2) >= number) {
                end = mid - 1;
                result = mid;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(Long.toString(sqrt(Long.parseLong(br.readLine()))));
        bw.flush();

        br.close();
        bw.close();
    }
}
