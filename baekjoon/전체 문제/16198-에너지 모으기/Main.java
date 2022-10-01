import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    private static final LinkedList<Integer> linkedList = new LinkedList<>();

    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            linkedList.add(Integer.parseInt(st.nextToken()));
        }

        backtracking(linkedList, 0);

        bw.write(Integer.toString(max));
        bw.flush();

        br.close();
        bw.close();
    }

    private static void backtracking(LinkedList<Integer> linkedList, int sum) {
        if (linkedList.size() < 3) {
            if (sum > max) {
                max = sum;
            }
            return;
        }

        for (int i = 1; i < linkedList.size() - 1; i++) {
            int selectedEnergy = linkedList.get(i);
            int getEnergy = linkedList.get(i - 1) * linkedList.get(i + 1);

            linkedList.remove(i);
            backtracking(linkedList, sum + getEnergy);
            linkedList.add(i, selectedEnergy);
        }
    }
}
