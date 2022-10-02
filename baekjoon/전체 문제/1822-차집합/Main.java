import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int aCount = Integer.parseInt(st.nextToken());
        int bCount = Integer.parseInt(st.nextToken());

        TreeSet<Integer> treeSet = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        while (aCount-- > 0) {
            treeSet.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        while (bCount-- > 0) {
            treeSet.remove(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();

        if (treeSet.isEmpty()) {
            sb.append(0);
        } else {
            sb.append(treeSet.size()).append('\n');
            for (int i : treeSet) {
                sb.append(i).append(' ');
            }
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }
}
