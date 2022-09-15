import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long S = Long.parseLong(br.readLine());

        long count = 0;
        long temp = 1;
        long sum = 0;

        while (true) {
            sum += temp;
            count++;
            if (sum > S) {
                count--;
                break;
            }
            temp++;
        }

        bw.write(Long.toString(count));
        bw.flush();
    }
}
