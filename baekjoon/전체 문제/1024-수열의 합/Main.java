import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int max = 0;
        int temp = 0;

        for (int i = L; i <= 100; i++) {
            temp = N - (i * (i + 1) / 2);

            if (temp % i == 0) {
                temp = temp / i;
                if (temp >= -1) {
                    max = i;
                    break;
                }
            }
        }

        if (max != 0) {
            for (int i = 1; i <= max; i++) {
                sb.append(temp + i).append(' ');
            }
        } else {
            sb.append(-1);
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }
}
