import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        boolean[][] array = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String string = br.readLine();

            for (int j = 0; j < N; j++) {
                array[i][j] = string.charAt(j) == 'X';
            }
        }

        bw.write(checkWidth(array) + " " + checkHeight(array));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int checkWidth(boolean[][] array) {
        int count = 0;

        for (boolean[] booleans : array) {
            int tempCount = 0;

            for (int j = 0; j < array.length; j++) {
                if (booleans[j]) {
                    tempCount = 0;
                } else {
                    tempCount++;

                    if (tempCount == 2) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private static int checkHeight(boolean[][] array) {
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            int tempCount = 0;

            for (boolean[] booleans : array) {
                if (booleans[i]) {
                    tempCount = 0;
                } else {
                    tempCount++;

                    if (tempCount == 2) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
