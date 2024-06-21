import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int J = Integer.parseInt(br.readLine());

        int move = 0;

        int startBasketIndex = 1;
        int endBasketIndex = M;

        while (J-- > 0) {
            int appleIndex = Integer.parseInt(br.readLine());

            if (appleIndex > endBasketIndex) {
                move += appleIndex - endBasketIndex;

                startBasketIndex = appleIndex - M + 1;
                endBasketIndex = appleIndex;
            } else if (appleIndex < startBasketIndex) {
                move += startBasketIndex - appleIndex;

                startBasketIndex = appleIndex;
                endBasketIndex = appleIndex + M - 1;
            }
        }

        bw.write(Integer.toString(move));
        bw.flush();

        br.close();
        bw.close();
    }
}
