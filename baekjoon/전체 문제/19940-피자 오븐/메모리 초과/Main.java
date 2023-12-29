import java.io.*;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Main {

    private static final Queue<Vertex> queue = new ArrayDeque<>();
    private static final Set<Integer> visited = new HashSet<>();

    // 메모리 초과 코드
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            sb.append(bfs(Integer.parseInt(br.readLine()))).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static String bfs(int N) {
        visited.clear();
        queue.clear();

        visited.add(N);

        queue.offer(new Vertex(null, N, null));

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            if (currentVertex.value == 0) {
                int addh = 0;
                int addt = 0;
                int mint = 0;
                int addo = 0;
                int mino = 0;

                while (currentVertex.beforeVertex != null) {
                    switch (currentVertex.operator) {
                        case ADDH:
                            addh++;
                            break;
                        case ADDT:
                            addt++;
                            break;
                        case MINT:
                            mint++;
                            break;
                        case ADDO:
                            addo++;
                            break;
                        default: // MINO
                            mino++;
                            break;
                    }

                    currentVertex = currentVertex.beforeVertex;
                }

                return addh + " " + addt + " " + mint + " " + addo + " " + mino;
            }

            for (Operator operator : Operator.values()) {
                int nextValue = currentVertex.value + operator.value;

                if (nextValue < 0) {
                    continue;
                }

                if (visited.contains(nextValue)) {
                    continue;
                }
                visited.add(nextValue);

                queue.offer(new Vertex(currentVertex, nextValue, operator));
            }
        }

        return "exception";
    }

    private static class Vertex {

        final Vertex beforeVertex;
        final int value;
        final Operator operator;

        Vertex(Vertex beforeVertex, int value, Operator operator) {
            this.beforeVertex = beforeVertex;
            this.value = value;
            this.operator = operator;
        }
    }

    private enum Operator {

        // N에서 0으로 향하기 때문에 반대 연산
        MINO(1), ADDO(-1), MINT(10), ADDT(-10), ADDH(-60);

        final int value;

        Operator(int value) {
            this.value = value;
        }
    }
}
