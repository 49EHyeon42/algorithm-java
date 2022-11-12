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

        int N = Integer.parseInt(br.readLine());

        List<Integer> cranes = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cranes.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());

        List<Integer> boxes = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }

        cranes.sort(Comparator.reverseOrder());
        boxes.sort(Comparator.reverseOrder());

        bw.write(Integer.toString(getMinTime(cranes, boxes)));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int getMinTime(List<Integer> cranes, List<Integer> boxes) {
        if (cranes.get(0) < boxes.get(0)) {
            return -1;
        }

        int minTime = 0;

        while (!boxes.isEmpty()) {
            int craneIndex = 0;
            int boxIndex = 0;

            while (craneIndex < cranes.size()) {
                if (boxIndex == boxes.size()) {
                    break;
                }

                if (cranes.get(craneIndex) >= boxes.get(boxIndex)) {
                    boxes.remove(boxIndex);
                    craneIndex++;
                } else {
                    boxIndex++;
                }
            }

            minTime++;
        }

        return minTime;
    }
}
