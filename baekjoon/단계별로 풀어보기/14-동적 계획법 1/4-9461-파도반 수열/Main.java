import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] dpArray = new long[101];
        dpArray[1] = 1;
        dpArray[2] = 1;
        dpArray[3] = 1;
        dpArray[4] = 2;
        dpArray[5] = 2;

        for (int i = 6; i < 101; i++) {
            dpArray[i] = dpArray[i - 1] + dpArray[i - 5];
        }

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            sb.append(dpArray[Integer.parseInt(br.readLine())]).append('\n');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }
}
