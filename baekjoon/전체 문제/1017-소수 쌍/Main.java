import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<List<Integer>> graph;

    private static boolean[] visited;

    private static int[] match;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Integer> oddNumbers = new ArrayList<>();
        List<Integer> evenNumbers = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int firstNumber = Integer.parseInt(st.nextToken());

        boolean isFirstNumberOdd = firstNumber % 2 != 0;

        if (isFirstNumberOdd) {
            oddNumbers.add(firstNumber);
        } else {
            evenNumbers.add(firstNumber);
        }

        for (int i = 1; i < N; i++) {
            int currentNumber = Integer.parseInt(st.nextToken());

            if (currentNumber % 2 != 0) {
                oddNumbers.add(currentNumber);
            } else {
                evenNumbers.add(currentNumber);
            }
        }

        if (oddNumbers.size() != evenNumbers.size()) {
            bw.write("-1");
            bw.flush();

            br.close();
            bw.close();
            return;
        }

        bw.write(isFirstNumberOdd ? getResult(oddNumbers, evenNumbers)
                : getResult(evenNumbers, oddNumbers));
        bw.flush();

        br.close();
        bw.close();
    }

    private static String getResult(List<Integer> startNumbers, List<Integer> endNumbers) {
        int length = startNumbers.size(); // startNumbers.size() == endNumbers.size()

        graph = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            graph.add(new ArrayList<>());

            for (int j = 0; j < length; j++) {
                if (isPrimeNumber(startNumbers.get(i) + endNumbers.get(j))) {
                    graph.get(i).add(j);
                }
            }
        }

        List<Integer> resultNumbers = new ArrayList<>();

        // startNumbers 0번째 와 연결된 endNumbers 탐색
        // endNumbers == graph.get(0)
        for (Integer endIndex : graph.get(0)) {
            // 1개가 연결된 채로 시작하기 때문에 maximumMatchingSize 는 1로 시작
            int maximumMatchingSize = 1;

            match = new int[length];
            for (int i = 0; i < length; i++) {
                match[i] = -1;
            }

            match[endIndex] = 0;

            for (int start = 1; start < length; start++) {
                visited = new boolean[length];

                if (dfs(start)) {
                    maximumMatchingSize++;
                }
            }

            if (maximumMatchingSize == length) {
                resultNumbers.add(endNumbers.get(endIndex));
            }
        }

        if (resultNumbers.size() == 0) {
            return "-1";
        }

        resultNumbers.sort(Integer::compareTo);

        StringBuilder sb = new StringBuilder();
        for (Integer resultNumber : resultNumbers) {
            sb.append(resultNumber).append(' ');
        }

        return sb.toString().trim();
    }

    private static boolean isPrimeNumber(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(int from) {
        // from == 0 : 이미 선택해서 false
        if (from == 0 || visited[from]) {
            return false;
        }

        visited[from] = true;

        for (int to : graph.get(from)) {
            if (match[to] == -1 || dfs(match[to])) {
                match[to] = from;

                return true;
            }
        }

        return false;
    }
}
