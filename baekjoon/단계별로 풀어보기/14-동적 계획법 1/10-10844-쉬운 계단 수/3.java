import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static long[][] dpArray;
    private static final long MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        dpArray = new long[N + 1][10];

        for (int i = 0; i < 10; i++) {
            dpArray[1][i] = 1;
        }

        long answer = 0;
        for (int i = 1; i < 10; i++) {
            answer += recursive(N, i);
        }

        bw.write(Long.toString(answer % MOD));

        bw.flush();
        bw.close();
    }

    private static long recursive(int digit, int value) {
        if (digit == 1) {
            return dpArray[digit][value];
        }

        if (dpArray[digit][value] == 0) {
            if (value == 0) {
                dpArray[digit][value] = recursive(digit - 1, 1);
            } else if (value == 9) {
                dpArray[digit][value] = recursive(digit - 1, 8);
            } else {
                dpArray[digit][value] = recursive(digit - 1, value - 1) +
                    recursive(digit - 1, value + 1);
            }
        }

        return dpArray[digit][value] % MOD;
    }
}
