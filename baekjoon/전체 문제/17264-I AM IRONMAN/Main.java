import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());

        HashMap<String, String> hashMap = new HashMap<>();

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            hashMap.put(st.nextToken(), st.nextToken());
        }

        int point = 0;
        boolean flag = false;

        for (int i = 0; i < N; i++) {
            String name = br.readLine();

            if (hashMap.containsKey(name)) {
                if (hashMap.get(name).equals("W")) {
                    point += W;
                } else {
                    if (point - L < 0) {
                        point = 0;
                    } else {
                        point -= L;
                    }
                }
            } else {
                if (point - L < 0) {
                    point = 0;
                } else {
                    point -= L;
                }
            }

            if (point >= G) {
                flag = true;
            }
        }

        bw.write(flag ? "I AM NOT IRONMAN!!" : "I AM IRONMAN!!");
        bw.flush();

        br.close();
        bw.close();
    }
}
