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
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Nation> nations = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int nation = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            nations.add(new Nation(nation, gold, silver, bronze));
        }

        nations.sort(Comparator.comparingInt(Nation::getNation));

        bw.write(Integer.toString(getRanking(K, nations)));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int getRanking(int K, List<Nation> nations) {
        int rank = 1;
        Nation kNation = nations.get(K - 1);

        for (Nation nation : nations) {
            if (nation.equals(kNation)) {
                continue;
            }

            if (nation.getGold() > kNation.getGold()) {
                rank++;
            } else if (nation.getGold() == kNation.getGold()
                && nation.getSilver() > kNation.getSilver()) {
                rank++;
            } else if (nation.getGold() == kNation.getGold()
                && nation.getSilver() == kNation.getSilver()
                && nation.getBronze() > kNation.getBronze()) {
                rank++;
            }
        }

        return rank;
    }

    private static class Nation {

        private final int nation;
        private final int gold;
        private final int silver;
        private final int bronze;

        public Nation(int nation, int gold, int silver, int bronze) {
            this.nation = nation;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        public int getNation() {
            return nation;
        }

        public int getGold() {
            return gold;
        }

        public int getSilver() {
            return silver;
        }

        public int getBronze() {
            return bronze;
        }
    }
}
