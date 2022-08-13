import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// overflow
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        bw.write(Long.toString(combination(N, M)));

        bw.flush();
        bw.close();
    }

    private static long combination(int N, int M) {
        return factorial(N) / (factorial(N - M) * factorial(M));
    }

    private static long factorial(int number) {
        if (number == 0 || number == 1) {
            return 1;
        }

        long result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }

        return result;
    }
}
