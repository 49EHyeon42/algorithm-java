import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            List<String> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                list.add(br.readLine());
            }

            list.sort(Comparator.naturalOrder());

            if (isConsistentList(list)) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static boolean isConsistentList(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            String current = list.get(i);
            String next = list.get(i + 1);

            if (current.length() < next.length() && current.equals(
                next.substring(0, current.length()))) {
                return false;
            }
        }
        return true;
    }
}
