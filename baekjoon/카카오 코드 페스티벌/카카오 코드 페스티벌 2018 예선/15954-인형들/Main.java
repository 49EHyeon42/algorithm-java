import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        array = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        double minStandardDeviation = Double.MAX_VALUE;

        for (int i = K; i <= N; i++) { // i = end index
            for (int j = 0; j <= N - i; j++) { // j = start index
                minStandardDeviation = Math.min(minStandardDeviation,
                    getStandardDeviation(getMean(j, i), j, i));
            }
        }

        bw.write(String.format("%.11f", minStandardDeviation));
        bw.flush();
    }

    private static double getMean(int start, int end) {
        double sum = 0;
        for (int i = 0; i < end; i++) {
            sum += array[start + i];
        }
        return sum / end;
    }

    private static double getStandardDeviation(double mean, int start, int end) {
        double sum = 0.0;
        for (int i = 0; i < end; i++) {
            sum += Math.pow(array[start + i] - mean, 2);
        }
        return Math.sqrt(sum / end);
    }
}
