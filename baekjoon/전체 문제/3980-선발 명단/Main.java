import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final int MAX_LENGTH = 11;

    private static int[][] matrix;
    private static boolean[] visited;

    private static int maxAbility;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int C = Integer.parseInt(br.readLine());

        while (C-- > 0) {
            matrix = new int[MAX_LENGTH][MAX_LENGTH];

            for (int i = 0; i < MAX_LENGTH; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j = 0; j < MAX_LENGTH; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            visited = new boolean[MAX_LENGTH];

            maxAbility = 0;

            backtracking(0, 0);

            sb.append(maxAbility).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void backtracking(int y, int currentAbility) {
        if (y == MAX_LENGTH) {
            maxAbility = Math.max(maxAbility, currentAbility);
            return;
        }

        for (int x = 0; x < MAX_LENGTH; x++) {
            if (visited[x] || matrix[y][x] == 0) {
                continue;
            }

            visited[x] = true;
            backtracking(y + 1, currentAbility + matrix[y][x]);
            visited[x] = false;
        }
    }
}
