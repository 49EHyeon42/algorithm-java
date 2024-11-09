import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Cow[] cows = new Cow[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            cows[i] = new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(cows, Comparator.comparingInt(cow -> cow.arrivalTime));

        int minimumTime = 0;

        for (Cow cow : cows) {
            if (minimumTime < cow.arrivalTime) {
                minimumTime = cow.arrivalTime;
            }

            minimumTime += cow.checkTime;
        }

        bw.write(Integer.toString(minimumTime));
        bw.flush();

        br.close();
        bw.close();
    }

    private static class Cow {

        final int arrivalTime;
        final int checkTime;

        Cow(int arrivalTime, int checkTime) {
            this.arrivalTime = arrivalTime;
            this.checkTime = checkTime;
        }
    }
}
