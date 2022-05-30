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

        int answer;
        if (N == 1) {
            answer = Integer.parseInt(br.readLine());
        } else if (N == 2) {
            answer = Integer.parseInt(br.readLine()) + Integer.parseInt(br.readLine());
        } else {
            int[] array = new int[N + 1];
            int[] dpArray = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                array[i] = Integer.parseInt(br.readLine());
            }

            dpArray[1] = array[1];
            dpArray[2] = array[1] + array[2];
            for (int i = 3; i <= N; i++) {
                dpArray[i] = Integer.max(
                    Integer.max(dpArray[i - 3] + array[i - 1], dpArray[i - 2]) + array[i],
                    dpArray[i - 1]);
            }

            answer = dpArray[N];
        }

        bw.write(Integer.toString(answer));

        bw.flush();
        bw.close();
    }
}
