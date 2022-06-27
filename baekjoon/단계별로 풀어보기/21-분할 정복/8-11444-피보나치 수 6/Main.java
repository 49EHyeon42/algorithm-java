import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(br.readLine()) - 1;

        long[][] array = {{1, 1}, {1, 0}};
        long[][] answer = {{1, 0}, {0, 1}};

        while (N > 0) {
            if (N % 2 == 1) {
                answer = multiply(answer, array);
            }
            array = multiply(array, array);
            N /= 2;
        }

        bw.write(Long.toString(answer[0][0]));

        bw.flush();
        bw.close();
    }

    private static long[][] multiply(long[][] array1, long[][] array2) {
        long[][] temp = new long[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    temp[j][k] += array1[j][i] * array2[i][k];
                    temp[j][k] %= MOD;
                }
            }
        }

        return temp;
    }
}
