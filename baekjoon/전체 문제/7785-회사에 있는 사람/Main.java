import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        HashMap<String, String> hashMap = new HashMap<>();

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String state = st.nextToken();

            if (hashMap.containsKey(name) && hashMap.get(name).equals("enter")) {
                hashMap.remove(name);
            } else {
                hashMap.put(name, state);
            }
        }

        ArrayList<String> arrayList = new ArrayList<>(hashMap.keySet());

        arrayList.sort(Collections.reverseOrder());

        for (String name : arrayList) {
            sb.append(name).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }
}
