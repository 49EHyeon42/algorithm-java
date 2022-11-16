import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 이진 탐색
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            List<Integer> A = getSortedList(N, br.readLine());
            List<Integer> B = getSortedList(M, br.readLine());

            int count = 0;
            for (Integer i : A) {
                count += getBinarySearchResult(i, B);
            }

            sb.append(count).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static List<Integer> getSortedList(int size, String string) {
        List<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(string);
        for (int i = 0; i < size; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        list.sort(Integer::compareTo);

        return list;
    }

    private static int getBinarySearchResult(int i, List<Integer> list) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (i > list.get(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
