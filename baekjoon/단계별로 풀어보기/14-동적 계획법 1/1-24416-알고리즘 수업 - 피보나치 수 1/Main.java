import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static int[] dpArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        dpArray = new int[n + 1];

        bw.write(String.valueOf(fibonacci(n)) + ' ' + (n - 2));

        bw.flush();
        bw.close();
    }

    private static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    private static int fibonacci(int n) {
        dpArray[1] = dpArray[2] = 1;
        for (int i = 3; i <= n; i++) {
            dpArray[i] = dpArray[i - 1] + dpArray[i - 2];
        }
        return dpArray[n];
    }
}
