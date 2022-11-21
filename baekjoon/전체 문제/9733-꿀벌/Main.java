import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> map = new HashMap<>();

        List<String> jobs = Arrays.asList("Re", "Pt", "Cc", "Ea", "Tb", "Cm", "Ex");
        for (String job : jobs) {
            map.put(job, 0);
        }

        String string;
        while ((string = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(string);

            while (st.hasMoreTokens()) {
                String job = st.nextToken();
                map.put(job, map.getOrDefault(job, 0) + 1);
            }
        }

        int total = getTotal(map);

        StringBuilder sb = new StringBuilder();
        for (String job : jobs) {
            sb.append(
                String.format("%s %d %.2f\n", job, map.get(job), ((float) map.get(job)) / total));
        }
        sb.append(String.format("Total %d 1.00", total));

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static int getTotal(Map<String, Integer> map) {
        int total = 0;
        for (Integer value : map.values()) {
            total += value;
        }
        return total;
    }
}
