public class SegmentTree {

    /*
     * start, end, index 고정
     * 시간 복잡도 = O(logN)
     * */

    private final int[] array;
    private final int[] tree;

    public SegmentTree(int[] array) {
        this.array = array;
        tree = new int[array.length * 4];

        init(0, array.length - 1, 1);
    }

    private int init(int start, int end, int index) {
        if (start == end) {
            tree[index] = array[start];
            return tree[index];
        }

        int mid = (start + end) / 2;

        return tree[index] = init(start, mid, index * 2)
            + init(mid + 1, end, index * 2 + 1);
    }

    public int getSum(int start, int end, int index, int left, int right) {
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

    public void update(int start, int end, int index, int what, int value) {
        if (what < start || what > end) {
            return;
        }

        tree[index] = value;

        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;

        update(start, mid, index * 2, what, value);
        update(mid + 1, end, index * 2 + 1, what, value);
    }
}
