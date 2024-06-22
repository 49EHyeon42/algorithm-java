import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        boolean[][] sky = new boolean[H][W];
        int[][] result = new int[H][W];

        for (int i = 0; i < H; i++) {
            String string = br.readLine();

            for (int j = 0; j < W; j++) {
                if (string.charAt(j) == 'c') {
                    sky[i][j] = true;
                } else {
                    result[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < H; i++) {
            int count = 0;

            for (int j = 0; j < W; j++) {
                if (sky[i][j]) {
                    count = 0;
                    continue;
                }

                if (j == 0 || result[i][j - 1] == -1) {
                    continue;
                }

                result[i][j] = ++count;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int[] ints : result) {
            for (int i : ints) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }
}
