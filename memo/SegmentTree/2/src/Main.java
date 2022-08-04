// reference : https://velog.io/@kimdukbae/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-%EC%84%B8%EA%B7%B8%EB%A8%BC%ED%8A%B8-%ED%8A%B8%EB%A6%AC-Segment-Tree

public class Main {

    private static int[] array;
    private static int[] tree;

    public static void main(String[] args) {
        array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        tree = new int[array.length * 4];

        init(0, array.length - 1, 1);

        // 0부터 9까지의 구간 합
        // answer = 55
        System.out.println(intervalSum(0, array.length - 1, 1, 0, 9));

        // 0부터 2까지의 구간 합
        // answer = 6
        System.out.println(intervalSum(0, array.length - 1, 1, 0, 2));

        // 6부터 7까지의 구간 합
        // answer = 15
        System.out.println(intervalSum(0, array.length - 1, 1, 6, 7));

        // array[0] +4만큼 수정
        // answer = 10
        update(0, array.length - 1, 1, 0, 4);
        System.out.println(intervalSum(0, array.length - 1, 1, 0, 2));

        // array[9] -11만큼 수정
        // answer = 8
        update(0, array.length - 1, 1, 9, -11);
        System.out.println(intervalSum(0, array.length - 1, 1, 8, 9));

        // Test
        // array[1] 2에서 3으로 갱신
        // answer = 6
        update2(0, array.length - 1, 1, 1, 3);
        System.out.println(intervalSum(0, array.length - 1, 1, 1, 2));

        // Test
        // answer = 20
        update2(0, array.length - 1, 1, 0, 10);
        update(0, array.length - 1, 1, 1, 10);
        System.out.println(intervalSum(0, array.length - 1, 1, 0, 1));
    }

    // index : 세그먼트 트리의 인덱스 (무조건 1부터 시작)
    // 2를 곱했을 때 왼쪽 자식노드를 가리키고 2를 곱하고 1을 더하면
    // 오른쪽 자식노드를 가리키므로 효과적이기 때문에
    private static int init(int start, int end, int index) {
        if (start == end) {
            tree[index] = array[start];
            return tree[index];
        }

        int mid = (start + end) / 2;

        return tree[index] = init(start, mid, index * 2)
            + init(mid + 1, end, index * 2 + 1);
    }

    private static int intervalSum(int start, int end, int index, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }
        if (left <= start && right >= end) {
            return tree[index];
        }

        int mid = (start + end) / 2;

        return intervalSum(start, mid, index * 2, left, right)
            + intervalSum(mid + 1, end, index * 2 + 1, left, right);
    }

    private static void update(int start, int end, int index, int what, int value) {
        if (what < start || what > end) {
            return;
        }

        tree[index] += value;

        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;

        update(start, mid, index * 2, what, value);
        update(mid + 1, end, index * 2 + 1, what, value);
    }

    // 갱신
    private static void update2(int start, int end, int index, int what, int value) {
        if (what < start || what > end) {
            return;
        }

        tree[index] = value;

        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;

        update2(start, mid, index * 2, what, value);
        update2(mid + 1, end, index * 2 + 1, what, value);
    }
}
