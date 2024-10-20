import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static boolean[] isBroken;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        isBroken = new boolean[10];

        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < M; i++) {
                isBroken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        bw.write(Integer.toString(solution()));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int solution() {
        int min = Math.abs(100 - N);

        if (M == 10) {
            return min;
        }

        for (int i = 0; i < 1000000; i++) {
            if (isPossibleChannel(i)) {
                min = Math.min(min, Math.abs(N - i) + Integer.toString(i).length());
            }
        }

        return min;
    }

    private static boolean isPossibleChannel(int channel) {
        String copyChannel = Integer.toString(channel);

        for (int i = 0; i < copyChannel.length(); i++) {
            if (isBroken[copyChannel.charAt(i) - '0']) {
                return false;
            }
        }

        return true;
    }
}
