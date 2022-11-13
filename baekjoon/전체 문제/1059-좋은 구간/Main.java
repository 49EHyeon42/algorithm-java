import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int L = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < L; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        list.sort(Integer::compareTo);

        int n = Integer.parseInt(br.readLine());

        bw.write(Integer.toString(getNumberOfGoodSection(list, n)));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int getNumberOfGoodSection(List<Integer> list, int n) {
        if (list.contains(n)) {
            return 0;
        }

        int max = 0;
        int min = 0;

        int prevNum = 0;
        for (Integer number : list) {
            if (number > n) {
                min = prevNum + 1;
                max = number - 1;
                break;
            }
            prevNum = number;
        }

        return (n - min) * (max - n + 1) + (max - n);
    }
}
