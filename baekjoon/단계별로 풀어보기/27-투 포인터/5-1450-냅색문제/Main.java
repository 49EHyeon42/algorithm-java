import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    private static int C;

    private static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        array = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();

        dfs(arrayList1, 0, N / 2, 0);
        dfs(arrayList2, N / 2, N, 0);

        arrayList2.sort(Comparator.comparingInt(o -> o));

        int count = 0;
        for (Integer value : arrayList1) {
            count += upperBound(arrayList2, C - value) + 1;
        }

        bw.write(Integer.toString(count));

        bw.flush();
        bw.close();
    }

    private static void dfs(ArrayList<Integer> arrayList, int startIndex, int endIndex, int sum) {
        if (sum > C) {
            return;
        }
        if (startIndex == endIndex) {
            arrayList.add(sum);
            return;
        }

        dfs(arrayList, startIndex + 1, endIndex, sum);
        dfs(arrayList, startIndex + 1, endIndex, sum + array[startIndex]);
    }

    private static int upperBound(ArrayList<Integer> arrayList, int target) {
        int startIndex = 0;
        int endIndex = arrayList.size() - 1;

        while (startIndex <= endIndex) {
            int mid = (startIndex + endIndex) / 2;

            if (arrayList.get(mid) <= target) {
                startIndex = mid + 1;
            } else {
                endIndex = mid - 1;
            }
        }

        return endIndex;
    }
}
