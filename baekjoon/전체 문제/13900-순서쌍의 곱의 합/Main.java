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

        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int[] prefixSum = new int[N];
        prefixSum[0] = array[0];

        for (int i = 1; i < N; i++) {
            prefixSum[i] = prefixSum[i - 1] + array[i];
        }

        long sum = 0;

        for (int i = 0; i < N - 1; i++) {
            sum += (long) array[i] * (prefixSum[N - 1] - prefixSum[i]);
        }

        bw.write(Long.toString(sum));
        bw.flush();

        br.close();
        bw.close();
    }
}
