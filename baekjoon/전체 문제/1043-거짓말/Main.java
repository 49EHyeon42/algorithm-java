import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // Union-Find
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());

        int[] personWhoKnows = new int[Integer.parseInt(st.nextToken())];
        for (int i = 0; i < personWhoKnows.length; i++) {
            personWhoKnows[i] = Integer.parseInt(st.nextToken());
        }

        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            parties.add(new ArrayList<>());
        }

        for (int party = 0; party < M; party++) {
            st = new StringTokenizer(br.readLine());

            int count = Integer.parseInt(st.nextToken());

            // unable to merge at first
            int currentNumber = Integer.parseInt(st.nextToken());
            parties.get(party).add(currentNumber);

            int previousNumber;
            for (int i = 1; i < count; i++) {
                previousNumber = currentNumber;

                currentNumber = Integer.parseInt(st.nextToken());

                merge(previousNumber, currentNumber);

                parties.get(party).add(currentNumber);
            }
        }

        // 과장된 이야기를 할 수 있는 파티 개수의 최대값 얻기
        for (List<Integer> party : parties) {
            if (!canIGoToTheParty(party, personWhoKnows)) {
                M--;
            }
        }

        bw.write(Integer.toString(M));
        bw.flush();

        br.close();
        bw.close();
    }

    private static boolean canIGoToTheParty(List<Integer> party, int[] personWhoKnows) {
        for (Integer person : party) {
            for (int know : personWhoKnows) {
                if (isUnion(person, know)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isUnion(int x, int y) {
        return find(x) == find(y);
    }

    private static void merge(int x, int y) {
        int tempX = find(x);
        int tempY = find(y);
        if (tempX != tempY) {
            parent[tempY] = tempX;
        }
    }

    private static int find(int index) {
        return (parent[index] == index) ? index : (parent[index] = find(parent[index]));
    }
}
