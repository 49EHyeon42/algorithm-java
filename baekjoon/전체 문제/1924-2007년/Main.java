import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final int[] MONTH = {-1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String[] WEEK = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        bw.write(WEEK[getTotalDay(month, day) % 7]);

        bw.flush();
        bw.close();
    }

    private static int getTotalDay(int month, int day) {
        for (int i = 1; i < month; i++) {
            day += MONTH[i];
        }

        return day;
    }
}
