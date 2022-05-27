import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] dpArray = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            dpArray[i] = dpArray[i - 1] + 1;
            if (i % 2 == 0) {
                dpArray[i] = Integer.min(dpArray[i], dpArray[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dpArray[i] = Integer.min(dpArray[i], dpArray[i / 3] + 1);
            }
        }

        bw.write(Integer.toString(dpArray[N]));

        bw.flush();
        bw.close();
    }
}
