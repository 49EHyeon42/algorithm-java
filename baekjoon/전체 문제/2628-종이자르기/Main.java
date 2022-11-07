import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        List<Integer> colList = new ArrayList<>();
        List<Integer> rowList = new ArrayList<>();

        colList.add(0);
        rowList.add(0);
        colList.add(width);
        rowList.add(length);

        int dottedLineNumber = Integer.parseInt(br.readLine());

        for (int i = 0; i < dottedLineNumber; i++) {
            st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 0) {
                rowList.add(Integer.parseInt(st.nextToken()));
            } else {
                colList.add(Integer.parseInt(st.nextToken()));
            }
        }

        colList.sort(Comparator.comparingInt(o -> o));
        rowList.sort(Comparator.comparingInt(o -> o));

        bw.write(Integer.toString(getMaxLength(colList) * getMaxLength(rowList)));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int getMaxLength(List<Integer> list) {
        int max = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            max = Math.max(max, list.get(i + 1) - list.get(i));
        }
        return max;
    }
}
