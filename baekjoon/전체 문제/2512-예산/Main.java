import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] budgets = new int[N];

        // right를 받기 위해 위에서 선언
        int left = 1;
        int right = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());

            right = Math.max(right, budgets[i]);
        }

        int totalBudget = Integer.parseInt(br.readLine());

        while (left <= right) {
            int mid = (left + right) / 2;

            if (payBudget(budgets, mid) > totalBudget) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        bw.write(Integer.toString(right));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int payBudget(int[] budgets, int limitBudget) {
        int payBudget = 0;

        for (int budget : budgets) {
            payBudget += Math.min(budget, limitBudget);
        }

        return payBudget;
    }
}
