import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            char[] before = br.readLine().toCharArray();
            char[] after = br.readLine().toCharArray();

            // 1. 초기 상태가 B, 목표 상태가 W인 경우
            // 2. 초기 상태가 W, 목표 상태가 B인 경우

            // 1번 케이스와 2번 케이스가 있는 경우, 서로 변경하여 해결할 수 있다.
            // 나머지는 뒤집어서 해결한다.

            // 1)
            // 1번 케이스 1번, 2번 케이스 1번
            // 변경 한 번으로 해결할 수 있다.

            // 2)
            // 1번 케이스 3번, 2번 케이스 0번
            // 3번 뒤집어서 해결할 수 있다.

            // 3)
            // 1번 케이스 2번, 2번 케이스 2번
            // 변경 두 번으로 해결할 수 있다.

            // 4) BBWWB, WWBBW
            // 1번 케이스 3번, 2번 케이스 2번
            // 변경 두 번과 한 번 뒤집어서 해결할 수 있다.
            // 즉, 케이스 중 큰 값을 출력하면 된다.

            int blackCount = 0;
            int whiteCount = 0;

            for (int i = 0; i < N; i++) {
                if (before[i] == after[i]) {
                    continue;
                }

                if (before[i] == 'B') {
                    blackCount++;
                } else {
                    whiteCount++;
                }
            }

            sb.append(Math.max(blackCount, whiteCount)).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }
}
