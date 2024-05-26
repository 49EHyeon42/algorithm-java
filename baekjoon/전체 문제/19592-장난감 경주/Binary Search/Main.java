import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            int maxSpeed = Integer.MIN_VALUE;

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N - 1; i++) {
                maxSpeed = Math.max(maxSpeed, Integer.parseInt(st.nextToken()));
            }
            int mySpeed = Integer.parseInt(st.nextToken());

            // 부스터를 사용하지 않아도 이기는 경우
            if (maxSpeed < mySpeed) {
                sb.append(0).append('\n');
                continue;
            }

            double minSecond = getSecond(X, maxSpeed);

            // 최고 속도와 같다고 해도 단독 우승 불가
            if (minSecond <= 1) {
                sb.append(-1).append('\n');
                continue;
            }

            int left = mySpeed + 1;
            int right = Y;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (getSecond(X - mid, mySpeed) + 1 < minSecond) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            sb.append(left > Y ? -1 : left).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    // 이 문제 소수점까지 계산해야 예제 출력이랑 같네?
    private static double getSecond(int length, int speed) {
        return (double) length / speed;
    }
}
