import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int sum1 = 0;

        Integer[] burger = new Integer[B];
        Integer[] sideMenu = new Integer[C];
        Integer[] drink = new Integer[D];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < B; i++) {
            int value = Integer.parseInt(st.nextToken());

            sum1 += value;

            burger[i] = value;
        }

        Arrays.sort(burger, Comparator.reverseOrder());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) {
            int value = Integer.parseInt(st.nextToken());

            sum1 += value;

            sideMenu[i] = value;
        }

        Arrays.sort(sideMenu, Comparator.reverseOrder());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < D; i++) {
            int value = Integer.parseInt(st.nextToken());

            sum1 += value;

            drink[i] = value;
        }

        Arrays.sort(drink, Comparator.reverseOrder());

        int min = Math.min(B, Math.min(C, D));

        int sum2 = 0;

        for (int i = 0; i < min; i++) {
            sum2 += (burger[i] + sideMenu[i] + drink[i]) * 0.9;
        }

        for (int i = min; i < B; i++) {
            sum2 += burger[i];
        }

        for (int i = min; i < C; i++) {
            sum2 += sideMenu[i];
        }

        for (int i = min; i < D; i++) {
            sum2 += drink[i];
        }

        bw.write(sum1 + "\n" + sum2);
        bw.flush();

        br.close();
        bw.close();
    }
}
