import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        TreeMap<String, Integer> treeMap = new TreeMap<>();

        int woodNumber = 0;

        String string;
        while ((string = br.readLine()) != null) {
            treeMap.put(string, treeMap.getOrDefault(string, 0) + 1);
            woodNumber++;
        }

        for (Entry<String, Integer> entry : treeMap.entrySet()) {
            sb.append(entry.getKey()).append(" ")
                .append(String.format("%.4f", (double) entry.getValue() / woodNumber * 100))
                .append("\n");
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }
}
