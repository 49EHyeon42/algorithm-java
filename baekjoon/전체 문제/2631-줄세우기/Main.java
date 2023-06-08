import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static int binarySearch(int[] array, int target, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;

            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        // LIS(with binary search), O(NlogN)
        int maxLength = 0;

        dp[0] = array[0];

        for (int i = 1; i < N; i++) {
            if (dp[maxLength] < array[i]) {
                dp[maxLength + 1] = array[i];

                maxLength++;
            } else {
                dp[binarySearch(dp, array[i], 0, maxLength)] = array[i];
            }
        }

        bw.write(Integer.toString(N - (maxLength + 1)));
        bw.flush();

        br.close();
        bw.close();
    }
}
