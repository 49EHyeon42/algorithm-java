import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] matrixA = new boolean[N][M];
        boolean[][] matrixB = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String string = br.readLine();

            for (int j = 0; j < M; j++) {
                matrixA[i][j] = string.charAt(j) == '1';
            }
        }

        for (int i = 0; i < N; i++) {
            String string = br.readLine();

            for (int j = 0; j < M; j++) {
                matrixB[i][j] = string.charAt(j) == '1';
            }
        }

        int count = 0;

        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 2; j++) {
                if (matrixA[i][j] != matrixB[i][j]) {
                    reverseMatrix(matrixA, i, j);

                    count++;
                }
            }
        }

        bw.write(Integer.toString(checkMatrix(matrixA, matrixB) ? count : -1));
        bw.flush();

        br.close();
        bw.close();
    }

    private static void reverseMatrix(boolean[][] matrix, int i, int j) {
        for (int k = i; k < i + 3; k++) {
            for (int l = j; l < j + 3; l++) {
                matrix[k][l] = !matrix[k][l];
            }
        }
    }

    private static boolean checkMatrix(boolean[][] matrixA, boolean[][] matrixB) {
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[i].length; j++) {
                if (matrixA[i][j] != matrixB[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
