import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간초과
public class Main {

    private static int[] array;
    private static int[] dpArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        array = new int[N + 1];
        dpArray = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            recursive(i);
        }

        bw.write(Integer.toString(Arrays.stream(dpArray).max().getAsInt()));

        bw.flush();
        bw.close();
    }

    private static int recursive(int N) {
        if (dpArray[N] == 0) {
            dpArray[N] = 1;
        }

        for (int i = N; i > 0; i--) {
            if (array[i] < array[N]) {
                dpArray[N] = Math.max(dpArray[N], recursive(i) + 1);
            }
        }

        return dpArray[N];
    }
}
