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
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] array1 = new int[N];

        for (int i = 0; i < N; i++) {
            array1[i] = Integer.parseInt(br.readLine());
        }

        int[] array2 = new int[N - 1];

        for (int i = 0; i < N - 1; i++) {
            array2[i] = array1[i + 1] - (array1[i] + 1);
        }

        Arrays.sort(array2);

        int min = N;

        for (int i = 0; i < N - K; i++) {
            if (array2[i] == 0) {
                continue;
            }
            min += array2[i];
        }

        bw.write(Integer.toString(min));
        bw.flush();

        br.close();
        bw.close();
    }
}
