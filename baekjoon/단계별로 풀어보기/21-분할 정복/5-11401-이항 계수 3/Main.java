import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long numerator = factorial(N);
        long denominator = factorial(K) * factorial(N - K) % MOD;

        bw.write(Long.toString(numerator * pow(denominator, MOD - 2) % MOD));

        bw.flush();
        bw.close();
    }

    private static long factorial(int N) {
        long factorial = 1;
        for (long i = N; i > 1; i--) {
            factorial = (factorial * i) % MOD;
        }
        return factorial;
    }

    private static long pow(long base, long expo) {
        if (expo == 1) {
            return base % MOD;
        }
        long temp = pow(base, expo / 2);
        if (expo % 2 == 1) {
            return temp * temp % MOD * base % MOD;
        }
        return temp * temp % MOD;
    }
}
