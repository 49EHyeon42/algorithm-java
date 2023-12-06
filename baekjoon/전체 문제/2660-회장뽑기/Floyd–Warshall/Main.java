import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int vertexNumber = Integer.parseInt(br.readLine());

        int[][] array = new int[vertexNumber + 1][vertexNumber + 1];
        for (int i = 1; i <= vertexNumber; i++) {
            for (int j = 1; j <= vertexNumber; j++) {
                array[i][j] = i == j ? 0 : INF;
            }
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());

            if (vertex1 == -1 && vertex2 == -1) {
                break;
            }

            array[vertex1][vertex2] = 1;
            array[vertex2][vertex1] = 1;
        }

        // Floyd–Warshall
        for (int k = 1; k <= vertexNumber; k++) {
            for (int i = 1; i <= vertexNumber; i++) {
                for (int j = 1; j <= vertexNumber; j++) {
                    if (array[i][j] > array[i][k] + array[k][j]) {
                        array[i][j] = array[i][k] + array[k][j];
                    }
                }
            }
        }

        int[] maxs = new int[vertexNumber + 1];

        int min = INF;

        for (int i = 1; i <= vertexNumber; i++) {
            int max = 0;

            for (int j = 1; j <= vertexNumber; j++) {
                if (i == j) {
                    continue;
                }

                if (max < array[i][j]) {
                    max = array[i][j];
                }

                maxs[i] = max;
            }

            if (min > max) {
                min = max;
            }
        }

        int count = 0;

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < maxs.length; i++) {
            if (min == maxs[i]) {
                count++;
                list.add(i);
            }
        }

        sb.append(min).append(' ').append(count).append('\n');

        for (int i : list) {
            sb.append(i).append(' ');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }
}
