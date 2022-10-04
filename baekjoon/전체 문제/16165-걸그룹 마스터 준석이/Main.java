import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> idols = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String groupName = br.readLine();
            int groupCount = Integer.parseInt(br.readLine());

            for (int j = 0; j < groupCount; j++) {
                idols.put(br.readLine(), groupName);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String line = br.readLine();

            if (Integer.parseInt(br.readLine()) == 0) {
                TreeSet<String> temp = new TreeSet<>();

                for (Entry<String, String> idol : idols.entrySet()) {
                    if (idol.getValue().equals(line)) {
                        temp.add(idol.getKey());
                    }
                }

                for (String name : temp) {
                    sb.append(name).append('\n');
                }
            } else { // command == 1
                sb.append(idols.get(line)).append('\n');
            }
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }
}
