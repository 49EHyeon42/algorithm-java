import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if (N == 0) {
            bw.write(Integer.toString(1));
            bw.flush();

            br.close();
            bw.close();

            return;
        }

        int[] array = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(Integer.toString(findRank(P, score, array)));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int findRank(int P, int score, int[] array) {
        if (array.length == 0) {
            return 1;
        }

        int rank = 1;

        int count = 0;

        for (int i : array) {
            if (score < i) {
                rank++;
            } else if (score > i) {
                break;
            }

            count++;
        }

        return count == P ? -1 : rank;
    }
}
