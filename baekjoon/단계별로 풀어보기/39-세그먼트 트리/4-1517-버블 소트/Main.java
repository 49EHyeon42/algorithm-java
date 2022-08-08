import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

// reference : https://loosie.tistory.com/328
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        long[] array = new long[N];
        HashMap<Long, Integer> indexHashMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            array[i] = Long.parseLong(st.nextToken());
            indexHashMap.put(array[i], i);
        }

        Arrays.sort(array);

        SegmentTree segmentTree = new SegmentTree(array.length);

        long answer = 0;
        for (int i = 0; i < N; i++) {
            int index = indexHashMap.get(array[i]);

            answer += segmentTree.getSwapCount(1, 0, N - 1, index + 1, N - 1);

            segmentTree.update(1, 0, N - 1, index, 1);
        }

        bw.write(Long.toString(answer));

        bw.flush();
        bw.close();
    }
}

class SegmentTree {

    private final long[] tree;

    public SegmentTree(int length) {
        tree = new long[length * 4];
    }

    public long getSwapCount(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }

        if (left <= start && right >= end) {
            return tree[node];
        }

        int mid = (start + end) / 2;

        return getSwapCount(node * 2, start, mid, left, right) +
            getSwapCount(node * 2 + 1, mid + 1, end, left, right);
    }

    public long update(int node, int start, int end, int index, long value) {
        if (index < start || index > end) {
            return tree[node];
        } else if (start == index && end == index) {
            return tree[node] = value;
        } else {
            int mid = (start + end) / 2;

            return tree[node] = update(node * 2, start, mid, index, value) +
                update(node * 2 + 1, mid + 1, end, index, value);
        }
    }
}
