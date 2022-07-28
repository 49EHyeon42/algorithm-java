import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static final StringBuilder sb = new StringBuilder();

    private static int[] indexes;
    private static int[] inOrder;
    private static int[] postOrder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        indexes = new int[N + 1];
        inOrder = new int[N + 1];
        postOrder = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            // 왼쪽, 오른쪽 트리 구분
            inOrder[i] = Integer.parseInt(st.nextToken());
            indexes[inOrder[i]] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            // 루트 찾기
            postOrder[i] = Integer.parseInt(st.nextToken());
        }

        recursion(1, N, 1, N);

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }

    private static void recursion(int inOrderStartIndex, int inOrderEndIndex,
        int postOrderStartIndex, int postOrderEndIndex) {
        if (inOrderStartIndex > inOrderEndIndex
            || postOrderStartIndex > postOrderEndIndex) {
            return;
        }

        int rootIndex = indexes[postOrder[postOrderEndIndex]];

        sb.append(inOrder[rootIndex]).append(' ');

        int leftSize = rootIndex - inOrderStartIndex;
        // int rightSize = inOrderEndIndex - rootIndex;

        recursion(inOrderStartIndex, rootIndex - 1,
            postOrderStartIndex, postOrderStartIndex + leftSize - 1);
        recursion(rootIndex + 1, inOrderEndIndex,
            postOrderStartIndex + leftSize, postOrderEndIndex - 1);
    }
}
