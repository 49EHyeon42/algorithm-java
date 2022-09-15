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

        char[] N = br.readLine().toCharArray();

        long sum = 0;
        boolean flag = false;

        for (char c : N) {
            if (c - '0' == 0) {
                flag = true;
            }

            sum += c - '0';
        }

        String answer;
        if (sum % 3 != 0 || !flag) {
            answer = "-1";
        } else {
            Arrays.sort(N);

            StringBuilder sb = new StringBuilder(String.valueOf(N));
            answer = sb.reverse().toString();
        }

        bw.write(answer);
        bw.flush();
    }
}
