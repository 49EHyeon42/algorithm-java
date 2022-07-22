import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        ArrayList<Integer> primeArray = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                primeArray.add(i);
            }
        }

        int answer = 0;
        int sum = 0;
        int start = 0;
        int end = 0;
        while (true) {
            if (sum >= N) {
                sum -= primeArray.get(start++);
            } else if (end != primeArray.size()) {
                sum += primeArray.get(end++);
            } else { // sum < N && end >= primeArray.size()
                break;
            }

            if (N == sum) {
                answer++;
            }
        }

        bw.write(Integer.toString(answer));

        bw.flush();
        bw.close();
    }
}
