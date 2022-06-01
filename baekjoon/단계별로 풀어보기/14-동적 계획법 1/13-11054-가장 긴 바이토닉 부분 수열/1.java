import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[] array;
    private static int[] dpArrayLIS;
    private static int[] dpArrayLDS;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        array = new int[N + 1];
        dpArrayLIS = new int[N + 1];
        dpArrayLDS = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        LIS();
        LDS();

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dpArrayLIS[i] + dpArrayLDS[i]);
        }

        bw.write(Integer.toString(max - 1));

        bw.flush();
        bw.close();
    }

    private static void LIS() {
        for (int i = 1; i <= N; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    temp = Math.max(temp, dpArrayLIS[j]);
                }
            }
            dpArrayLIS[i] = temp + 1;
        }
    }

    private static void LDS() {
        for (int i = N; i > 0; i--) {
            int temp = 0;
            for (int j = N; j > i; j--) {
                if (array[i] > array[j]) {
                    temp = Math.max(temp, dpArrayLDS[j]);
                }
            }
            dpArrayLDS[i] = temp + 1;
        }
    }
}
