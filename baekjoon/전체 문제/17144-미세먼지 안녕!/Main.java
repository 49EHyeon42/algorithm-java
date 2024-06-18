import java.io.*;
import java.util.StringTokenizer;

public class Main {

    // 상하좌우
    private static final int[][] dyx1 = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // 우 -> 상 -> 좌 -> 하
    private static final int[][] dyx2 = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

    // 우 -> 하 -> 좌 -> 상
    private static final int[][] dyx3 = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private static int R;
    private static int C;

    private static int[][] array;

    private static int airCleaner;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        array = new int[R][C];

        boolean flag = true;

        airCleaner = 0;

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < C; j++) {
                int fineDust = Integer.parseInt(st.nextToken());

                if (fineDust == -1 && flag) {
                    airCleaner = i;
                    flag = false;
                }

                array[i][j] = fineDust;
            }
        }

        while (T-- > 0) {
            spreadFineDust();
            operateAirCleaner(airCleaner, dyx2);
            operateAirCleaner(airCleaner + 1, dyx3);
        }

        bw.write(Integer.toString(getFineDust()));
        bw.flush();

        br.close();
        bw.close();
    }

    private static void spreadFineDust() {
        int[][] newArray = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (array[i][j] <= 0) {
                    continue;
                }

                int sum = 0;

                int quotient = array[i][j] / 5;

                for (int k = 0; k < 4; k++) {
                    int nextY = i + dyx1[k][0];
                    int nextX = j + dyx1[k][1];

                    if (nextY < 0 || nextY >= R || nextX < 0 || nextX >= C) {
                        continue;
                    }

                    // 공기청정기가 있다면 확산이 일어나지 않는다.
                    if ((nextY == airCleaner && nextX == 0) || (nextY == airCleaner + 1 && nextX == 0)) {
                        continue;
                    }

                    newArray[nextY][nextX] += quotient;
                    sum += quotient;
                }

                newArray[i][j] += array[i][j] - sum;
            }
        }

        array = newArray;
    }

    private static void operateAirCleaner(int airCleaner, int[][] dyx) {
        int way = 0;

        int endY = airCleaner;
        int endX = 0;

        int currentY = airCleaner;
        int currentX = 1;

        int previousValue = array[currentY][currentX];

        array[currentY][currentX] = 0;

        while (true) {
            int nextY = currentY + dyx[way][0];
            int nextX = currentX + dyx[way][1];

            if (nextY == endY && nextX == endX) {
                break;
            }

            if (nextY < 0 || nextY >= R || nextX < 0 || nextX >= C) {
                way++;
                continue;
            }

            int temp = array[nextY][nextX];

            array[nextY][nextX] = previousValue;

            previousValue = temp;

            currentY = nextY;
            currentX = nextX;
        }
    }

    private static int getFineDust() {
        int sum = 0;

        for (int[] ints : array) {
            for (int i : ints) {
                sum += i;
            }
        }

        return sum;
    }
}
