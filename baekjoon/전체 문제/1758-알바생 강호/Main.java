import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);

        long totalTip = 0;

        for (int i = N, j = 1; i > 0; i--, j++) {
            int tip = array[i - 1] - (j - 1);

            if (tip <= 0) {
                break;
            }

            totalTip += tip;
        }

        bw.write(Long.toString(totalTip));

        bw.flush();
        bw.close();
    }
}
