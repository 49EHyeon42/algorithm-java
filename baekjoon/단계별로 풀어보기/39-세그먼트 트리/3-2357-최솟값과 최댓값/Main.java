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
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] array = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            array[i] = Long.parseLong(br.readLine());
        }

        SegmentTree segmentTree = new SegmentTree(array);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(segmentTree.getMin(1, 0, array.length - 1, a, b))
                .append(' ')
                .append(segmentTree.getMax(1, 0, array.length - 1, a, b))
                .append('\n');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }
}

class SegmentTree {

    private final long[] array;
    private final long[] maxTree;
    private final long[] minTree;

    public SegmentTree(long[] array) {
        this.array = array;
        maxTree = new long[array.length * 4];
        minTree = new long[array.length * 4];

        maxInit(1, 0, array.length - 1);
        minInit(1, 0, array.length - 1);
    }

    private long maxInit(int node, int start, int end) {
        if (start == end) {
            return maxTree[node] = array[start];
        }

        int mid = (start + end) / 2;

        return maxTree[node] = Math.max(maxInit(node * 2, start, mid),
            maxInit(node * 2 + 1, mid + 1, end));
    }

    private long minInit(int node, int start, int end) {
        if (start == end) {
            return minTree[node] = array[start];
        }

        int mid = (start + end) / 2;

        return minTree[node] = Math.min(minInit(node * 2, start, mid),
            minInit(node * 2 + 1, mid + 1, end));
    }

    public long getMax(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return Long.MIN_VALUE;
        }

        if (left <= start && right >= end) {
            return maxTree[node];
        }

        int mid = (start + end) / 2;

        return Math.max(getMax(node * 2, start, mid, left, right),
            getMax(node * 2 + 1, mid + 1, end, left, right));
    }

    public long getMin(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return Long.MAX_VALUE;
        }

        if (left <= start && right >= end) {
            return minTree[node];
        }

        int mid = (start + end) / 2;

        return Math.min(getMin(node * 2, start, mid, left, right),
            getMin(node * 2 + 1, mid + 1, end, left, right));
    }
}
