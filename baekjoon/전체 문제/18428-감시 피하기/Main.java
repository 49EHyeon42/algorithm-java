import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dy = {1, -1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};

    private static int N;

    private static char[][] matrix;

    private static List<Coordinate> vacant;
    private static List<Coordinate> teachers;

    private static final Coordinate[] buffer = new Coordinate[3];

    private static boolean flag = false;

    // 조합
    private static void backtracking(int depth, int start) {
        if (depth == 3) {
            for (int i = 0; i < 3; i++) {
                matrix[buffer[i].y][buffer[i].x] = 'O';
            }

            if (checkAllTeacher()) {
                flag = true;
                return;
            }

            for (int i = 0; i < 3; i++) {
                matrix[buffer[i].y][buffer[i].x] = 'X';
            }
            return;
        }

        for (int i = start; i < vacant.size(); i++) {
            buffer[depth] = vacant.get(i);

            if (!flag) {
                backtracking(depth + 1, i + 1);
            }
        }
    }

    // 선생님의 이동 경로에서 학생을 찾을 수 없다면 true
    private static boolean checkAllTeacher() {
        for (Coordinate teacher : teachers) {
            if (checkStudent(teacher)) {
                return false;
            }
        }

        return true;
    }

    // 선생님이 학생을 찾는다면 true
    private static boolean checkStudent(Coordinate teacher) {
        for (int i = 0; i < 4; i++) {
            int nextY = teacher.y + dy[i];
            int nextX = teacher.x + dx[i];

            while (0 <= nextY && nextY < N && 0 <= nextX && nextX < N
                    && matrix[nextY][nextX] != 'O') {
                if (matrix[nextY][nextX] == 'S') {
                    return true;
                }

                nextY += dy[i];
                nextX += dx[i];
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        matrix = new char[N][N];

        vacant = new ArrayList<>();
        teachers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                char c = st.nextToken().charAt(0);

                if (c == 'X') {
                    vacant.add(new Coordinate(i, j));
                } else if (c == 'T') {
                    teachers.add(new Coordinate(i, j));
                }

                matrix[i][j] = c;
            }
        }

        backtracking(0, 0);

        bw.write(flag ? "YES" : "NO");
        bw.flush();

        br.close();
        bw.close();
    }

    private static class Coordinate {

        int y;
        int x;

        public Coordinate(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
