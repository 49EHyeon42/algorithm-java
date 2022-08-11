import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// reference : https://blog.itcode.dev/posts/2021/05/22/a1004
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int TestCaseCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < TestCaseCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            int planetCount = Integer.parseInt(br.readLine());

            int entryAndDeviationCount = 0;
            for (int j = 0; j < planetCount; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int radius = Integer.parseInt(st.nextToken());

                boolean hasStartContain = hasContain(startX, startY, x, y, radius);
                boolean hasEndContain = hasContain(endX, endY, x, y, radius);

                if (!(hasStartContain && hasEndContain) && (hasStartContain || hasEndContain)) {
                    entryAndDeviationCount++;
                }
            }

            sb.append(entryAndDeviationCount).append('\n');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }

    private static boolean hasContain(int xo, int yo, int x, int y, int r) {
        return Math.sqrt(Math.pow(xo - x, 2) + Math.pow(yo - y, 2)) < r;
    }
}
