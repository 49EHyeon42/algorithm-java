import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int kim = Integer.parseInt(st.nextToken());
        int im = Integer.parseInt(st.nextToken());

        int count = 0;
        while (kim != im) {
            kim = kim - kim / 2;
            im = im - im / 2;
            count++;
        }

        bw.write(Integer.toString(count));
        bw.flush();

        br.close();
        bw.close();
    }
}
