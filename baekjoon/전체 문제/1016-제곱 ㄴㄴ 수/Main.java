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

        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] isNoNoNum = new boolean[1000001];

        for (long i = 2; i * i <= max; i++) {
            long temp = min / (i * i);

            if (min % (i * i) != 0) {
                temp++;
            }

            while (temp * i * i <= max) {
                isNoNoNum[(int) (temp * i * i - min)] = true;
                temp++;
            }
        }

        int count = 0;
        for (int i = 0; i <= max - min; i++) {
            if (!isNoNoNum[i]) {
                count++;
            }
        }

        bw.write(Long.toString(count));
        bw.flush();
    }
}
