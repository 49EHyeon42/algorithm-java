import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        double left = 0;
        double right = Math.max(L, Math.max(W, H));

        // dobule 때문에 이렇게 사용
        for (int i = 0; i < 75; i++) {
            double mid = (left + right) / 2;

            if (getBoxCount(L, W, H, mid) < N) {
                right = mid;
            } else {
                left = mid;
            }
        }

        bw.write(Double.toString(left));
        bw.flush();

        br.close();
        bw.close();
    }

    private static long getBoxCount(int L, int W, int H, double A) {
        return (long) (L / A) * (long) (W / A) * (long) (H / A);
    }
}
