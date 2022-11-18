import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> negativeList = new ArrayList<>();
        List<Integer> positiveList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        int maxAbsMovement = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int movement = Integer.parseInt(st.nextToken());
            int absMovement = Math.abs(movement);

            if (movement < 0) {
                negativeList.add(absMovement);
            } else {
                positiveList.add(movement);
            }

            if (maxAbsMovement < absMovement) {
                maxAbsMovement = absMovement;
            }
        }

        negativeList.sort(Comparator.reverseOrder());
        positiveList.sort(Comparator.reverseOrder());

        bw.write(Integer.toString(
            getMinMovement(M, negativeList) + getMinMovement(M, positiveList) - maxAbsMovement));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int getMinMovement(int M, List<Integer> list) {
        int minMovement = 0;

        for (int i = 0; i < list.size(); i += M) {
            minMovement += list.get(i) * 2;
        }

        return minMovement;
    }
}
