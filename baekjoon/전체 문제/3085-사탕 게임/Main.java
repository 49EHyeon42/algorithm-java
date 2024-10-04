import java.io.*;

public class Main {

    private static final int[][] dyx = {{1, 0}, {0, 1}};

    private static int N;
    private static char[][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        array = new char[N][N];

        for (int i = 0; i < N; i++) {
            array[i] = br.readLine().toCharArray();
        }

        int max = 1;

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                for (int i = 0; i < 2; i++) {
                    int swapY = y + dyx[i][0];
                    int swapX = x + dyx[i][1];

                    if (swapY >= N || swapX >= N) {
                        continue;
                    }

                    if (array[y][x] == array[swapY][swapX]) {
                        continue;
                    }

                    swap(y, x, swapY, swapX);

                    max = Math.max(max, getCurrentMax());

                    swap(y, x, swapY, swapX);
                }
            }
        }

        bw.write(Integer.toString(max));
        bw.flush();

        br.close();
        bw.close();
    }

    private static void swap(int y1, int x1, int y2, int x2) {
        char temp = array[y1][x1];
        array[y1][x1] = array[y2][x2];
        array[y2][x2] = temp;
    }

    private static int getCurrentMax() {
        return Math.max(getMaxRowCount(), getMaxColumnCount());
    }

    // 행
    private static int getMaxRowCount() {
        int maxLength = 1;

        for (int i = 0; i < N; i++) {
            int currentLength = 1;

            for (int j = 0; j < N - 1; j++) {
                if (array[i][j] == array[i][j + 1]) {
                    maxLength = Math.max(maxLength, ++currentLength);
                } else {
                    currentLength = 1;
                }
            }
        }

        return maxLength;
    }

    // 열
    private static int getMaxColumnCount() {
        int maxLength = 1;

        for (int i = 0; i < N; i++) {
            int currentLength = 1;

            for (int j = 0; j < N - 1; j++) {
                if (array[j][i] == array[j + 1][i]) {
                    maxLength = Math.max(maxLength, ++currentLength);
                } else {
                    currentLength = 1;
                }
            }
        }

        return maxLength;
    }
}
