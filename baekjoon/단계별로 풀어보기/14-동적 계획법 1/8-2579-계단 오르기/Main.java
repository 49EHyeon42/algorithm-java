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

        int max;
        if (N == 1) {
            max = Integer.parseInt(br.readLine());
        } else if (N == 2) {
            max = Integer.parseInt(br.readLine())
                + Integer.parseInt(br.readLine());
        } else {
            int[] array = new int[N];
            int[] dpArray = new int[N];

            for (int i = 0; i < N; i++) {
                array[i] = Integer.parseInt(br.readLine());
            }

            dpArray[0] = array[0];
            dpArray[1] = array[0] + array[1];
            dpArray[2] = array[2] + Integer.max(array[0], array[1]);

            for (int i = 3; i < N; i++) {
                dpArray[i] = Integer.max(dpArray[i - 2], dpArray[i - 3] + array[i - 1])
                    + array[i];
            }

            max = dpArray[N - 1];
        }

        bw.write(Integer.toString(max));

        bw.flush();
        bw.close();
    }
}
