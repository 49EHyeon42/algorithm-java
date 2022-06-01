import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int[] array;
    private static int[] dpArrayLIS;
    private static int[] dpArrayLDS;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        array = new int[N + 1];
        dpArrayLIS = new int[N + 1];
        dpArrayLDS = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            LIS(i);
            LDS(i);
        }
        
        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dpArrayLIS[i] + dpArrayLDS[i]);
        }

        bw.write(Integer.toString(max - 1));

        bw.flush();
        bw.close();
    }

    private static int LIS(int N) {
        if (dpArrayLIS[N] == 0) {
            dpArrayLIS[N] = 1;
            for (int i = N; i > 0; i--) {
                if (array[i] < array[N]) {
                    dpArrayLIS[N] = Math.max(dpArrayLIS[N], LIS(i) + 1);
                }
            }
        }
        return dpArrayLIS[N];
    }

    private static int LDS(int N) {
        if (dpArrayLDS[N] == 0) {
            dpArrayLDS[N] = 1;
            for (int i = N; i < dpArrayLDS.length; i++) {
                if (array[i] < array[N]) {
                    dpArrayLDS[N] = Math.max(dpArrayLDS[N], LDS(i) + 1);
                }
            }
        }
        return dpArrayLDS[N];
    }
}
