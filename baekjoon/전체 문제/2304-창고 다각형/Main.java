import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Pillar> arrayList = new ArrayList<>();

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            arrayList.add(new Pillar(L, H));
        }

        arrayList.sort(Comparator.comparingInt(Pillar::getIndex));

        int sum = 0;
        int maxPillarHeight = 0;

        // left
        Pillar currentPillar = arrayList.get(0);
        for (int i = 1; i < arrayList.size(); i++) {
            Pillar nextPillar = arrayList.get(i);

            if (currentPillar.getHeight() <= nextPillar.getHeight()) {
                sum +=
                    (nextPillar.getIndex() - currentPillar.getIndex()) * currentPillar.getHeight();
                currentPillar = nextPillar;
                maxPillarHeight = i;
            }
        }

        // right
        currentPillar = arrayList.get(arrayList.size() - 1);
        for (int i = 1; i < arrayList.size() - maxPillarHeight; i++) {
            Pillar nextPillar = arrayList.get(arrayList.size() - 1 - i);

            if (currentPillar.getHeight() <= nextPillar.getHeight()) {
                sum +=
                    (currentPillar.getIndex() - nextPillar.getIndex()) * currentPillar.getHeight();
                currentPillar = nextPillar;
            }
        }

        sum += arrayList.get(maxPillarHeight).getHeight();

        bw.write(Integer.toString(sum));
        bw.flush();

        br.close();
        bw.close();
    }

    private static class Pillar {

        private final int index; // index = L
        private final int height; // height = H

        public Pillar(int index, int height) {
            this.index = index;
            this.height = height;
        }

        public int getIndex() {
            return index;
        }

        public int getHeight() {
            return height;
        }
    }
}
