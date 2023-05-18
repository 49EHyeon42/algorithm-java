import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static final int[] alphabet = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2,
            2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String hisName = br.readLine();
        String herName = br.readLine();

        int maxLength = hisName.length() * 2;

        int[][] dp = new int[maxLength - 1][maxLength];

//        for (int i = 0; i < maxLength; i++) {
//            dp[0][i] = alphabet[((i & 1) == 0 ?
//                    hisName.charAt(i >> 1) : herName.charAt(i >> 1)) - 'A'];
//        }

        for (int i = 0; i < hisName.length(); i++) {
            dp[0][i << 1] = alphabet[hisName.charAt(i) - 'A'];
            dp[0][i << 1 | 1] = alphabet[herName.charAt(i) - 'A'];
        }

        for (int i = 1; i < maxLength - 1; i++) {
            for (int j = 0; j < maxLength - i; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i - 1][j + 1]) % 10;
            }
        }

        bw.write(String.format("%d%d", dp[maxLength - 2][0], dp[maxLength - 2][1]));
        bw.flush();

        br.close();
        bw.close();
    }
}
