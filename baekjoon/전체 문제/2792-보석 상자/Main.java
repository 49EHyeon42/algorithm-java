import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int left = 1;
        int right = -1;

        int[] jewels = new int[M];

        for (int i = 0; i < M; i++) {
            jewels[i] = Integer.parseInt(br.readLine());

            right = Math.max(right, jewels[i]);
        }

        while (left <= right) {
            int mid = (left + right) / 2;

            if (getJewel(jewels, mid) <= N) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        bw.write(Integer.toString(left));
        bw.flush();

        br.close();
        bw.close();
    }

    // 분배할 수 있는 보석 수 반환
    private static int getJewel(int[] jewels, int mid) {
        int sum = 0;

        for (int jewel : jewels) {
            sum += jewel / mid;

            if (jewel % mid != 0) {
                sum++;
            }
        }

        return sum;
    }
}
