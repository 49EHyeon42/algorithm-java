import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static long[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        array = new long[N];

        for (int i = 0; i < N; i++) {
            array[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(array);

        long start = 0;
        long end = array[N - 1] - array[0] + 1;

        while (start < end) {
            long mid = (start + end) / 2;

            if (getInstallCount(mid) < C) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        bw.write(Long.toString(start - 1));

        bw.flush();
        bw.close();
    }

    private static int getInstallCount(long distance) {
        int count = 1;

        long lastLocate = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] - lastLocate >= distance) {
                count++;
                lastLocate = array[i];
            }
        }
        return count;
    }
}
