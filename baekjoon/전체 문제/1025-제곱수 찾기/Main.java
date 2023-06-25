import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] array = new int[N][M];

        for (int i = 0; i < N; i++) {
            String string = br.readLine();

            for (int j = 0; j < M; j++) {
                array[i][j] = string.charAt(j) - '0';
            }
        }

        int max = -1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int y = -N; y < N; y++) {
                    for (int x = -M; x < M; x++) {
                        if (y == 0 && x == 0) {
                            continue;
                        }

                        int currentMax = 0;
                        int tempY = i;
                        int tempX = j;

                        while (0 <= tempY && tempY < N && 0 <= tempX && tempX < M) {
                            currentMax = currentMax * 10 + array[tempY][tempX];

                            if (isSquareRoot(currentMax)) {
                                max = Math.max(max, currentMax);
                            }

                            tempY += y;
                            tempX += x;
                        }
                    }
                }
            }
        }

        bw.write(Integer.toString(max));
        bw.flush();

        br.close();
        bw.close();
    }

    private static boolean isSquareRoot(int i) {
        int root = (int) Math.sqrt(i);
        return root * root == i;
    }
}
