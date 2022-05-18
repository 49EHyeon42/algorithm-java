import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static final int[] dpArray = new int[41];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        int N, count0, count1;
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());

            if (N == 0) {
                count0 = 1;
                count1 = 0;
            } else if (N == 1) {
                count0 = 0;
                count1 = 1;
            } else {
                fibonacci(N);
                count0 = dpArray[N - 1];
                count1 = dpArray[N];
            }

            sb.append(count0).append(' ').append(count1).append('\n');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }

    public static int fibonacci(int N) {
        if (N <= 0) {
            dpArray[0] = 0;
            return 0;
        } else if (N == 1) {
            dpArray[1] = 1;
            return 1;
        }
        if (dpArray[N] == 0) {
            dpArray[N] = fibonacci(N - 1) + fibonacci(N - 2);
        }
        return dpArray[N];
    }
}
