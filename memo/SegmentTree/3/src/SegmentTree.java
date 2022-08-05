public class SegmentTree {

    /*
     * start, end, index 고정
     * 시간 복잡도 = O(logN)
     * */

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
            + init(mid + 1, end, index * 2 + 1);
    }

    public long getSum(int start, int end, int index, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }
        if (left <= start && right >= end) {
            return tree[index];
        }

        int mid = (start + end) / 2;

        return getSum(start, mid, index * 2, left, right)
            + getSum(mid + 1, end, index * 2 + 1, left, right);
    }

    public void update1(int start, int end, int index, int what, int value) {
        if (what < start || what > end) {
            return;
        }

        tree[index] += value;

        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;

        update1(start, mid, index * 2, what, value);
        update1(mid + 1, end, index * 2 + 1, what, value);
    }

    public long update2(int start, int end, int index, int what, int value) {
        if (what < start || what > end) {
            return tree[index];
        } else if (start == what && end == what) {
            return tree[index] = value;
        } else {
            int mid = (start + end) / 2;

            return tree[index] = update2(start, mid, index * 2, what, value)
                + update2(mid + 1, end, index * 2 + 1, what, value);
        }
    }
}
