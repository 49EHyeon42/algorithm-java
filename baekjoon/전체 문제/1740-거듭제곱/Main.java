import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(br.readLine());

        long result = 0;

        for (long temp = 1; N > 0; N /= 2, temp *= 3) {
            if ((N & 1) == 1) {
                result += temp;
            }
        }

        bw.write(Long.toString(result));
        bw.flush();

        br.close();
        bw.close();
    }
}
