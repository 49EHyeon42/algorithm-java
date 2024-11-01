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

        int M = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());

            array[i] = value;

            M = Math.max(M, value);
        }

        float result = 0;

        for (int i = 0; i < N; i++) {
            result += (float) array[i] / M * 100;
        }

        bw.write(Float.toString(result / N));

        bw.flush();
        bw.close();
    }
}
