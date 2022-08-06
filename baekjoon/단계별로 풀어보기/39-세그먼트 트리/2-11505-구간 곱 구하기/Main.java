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
        int K = Integer.parseInt(st.nextToken());

        long[] array = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            array[i] = Long.parseLong(br.readLine());
        }

        SegmentTree segmentTree = new SegmentTree(array);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                segmentTree.update(0, array.length - 1, 1, b, c);
            } else {
                sb.append(segmentTree.getMultiplication(0, array.length - 1, 1, b, c))
                    .append('\n');
            }
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }
}

class SegmentTree {

    private final long MOD = 1000000007;

    private final long[] array;
    private final long[] tree;

    public SegmentTree(long[] array) {
        this.array = array;
        tree = new long[array.length * 4];

        init(0, array.length - 1, 1);
    }

    private long init(int start, int end, int index) {
        if (start == end) {
            tree[index] = array[start];
            return tree[index];
        }

        int mid = (start + end) / 2;

        return tree[index] = init(start, mid, index * 2)
            * init(mid + 1, end, index * 2 + 1) % MOD;
    }

    public long getMultiplication(int start, int end, int index, int left, long right) {
        if (left > end || right < start) {
            return 1;
        }

        if (left <= start && right >= end) {
            return tree[index];
        }

        int mid = (start + end) / 2;

        return getMultiplication(start, mid, index * 2, left, right)
            * getMultiplication(mid + 1, end, index * 2 + 1, left, right) % MOD;
    }

    public long update(int start, int end, int index, int what, long value) {
        if (what < start || what > end) {
            return tree[index];
        } else if (start == what && end == what) {
            return tree[index] = value;
        } else {
            int mid = (start + end) / 2;

            return tree[index] = update(start, mid, index * 2, what, value)
                * update(mid + 1, end, index * 2 + 1, what, value) % MOD;
        }
    }
}
