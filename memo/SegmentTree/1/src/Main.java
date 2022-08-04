// reference : https://blog.naver.com/ndb796/221282210534

public class Main {

    private static final int NUMBER = 12;

    private static final int[] array = {1, 9, 3, 8, 4, 5, 5, 9, 10, 3, 4, 5};
    private static final int[] tree = new int[4 * NUMBER]; // 갯수에 대해서 2 제곱

    public static void main(String[] args) {
        init(0, NUMBER - 1, 1);

        System.out.println("0부터 12까지의 구간 합 : "
            + sum(0, NUMBER - 1, 1, 0, 12));

        System.out.println("3부터 8까지의 구간 합 : "
            + sum(0, NUMBER - 1, 1, 0, 12));

        System.out.println("인덱스 5의 원소를 -5만큼 수정");
        update(0, NUMBER - 1, 1, 1, -5);

        System.out.println("3부터 8까지의 구간 합 : "
            + sum(0, NUMBER - 1, 1, 0, 12));
    }

    /*
     * 구간 합 트리 생성
     * start = 시작 인덱스
     * end = 끝 인덱스
     * */
    private static int init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = array[start];
        }

        int mid = (start + end) / 2;

        return tree[node] = init(start, mid, node * 2)
            + init(mid + 1, end, node * 2);
    }

    /*
     * 구간 합을 구하는 함수
     * start = 시작 인덱스
     * end = 끝 인덱스
     * left, right = 구간 합을 구하고자 하는 범위
     * 시간 복잡도 = O(logN)
     * */
    private static int sum(int start, int end, int node, int left, int right) {
        // 범위 밖에 있는 경우
        if (left > end || right < start) {
            return 0;
        }

        // 범위 안에 있는 경우
        if (left <= start && end <= right) {
            return tree[node];
        }

        // 그렇지 안하뎜 두 부분으로 나누어 합을 구하기
        int mid = (start + end) / 2;

        return sum(start, mid, node * 2, left, right)
            + sum(mid + 1, end, node * 2 + 1, left, right);
    }

    /*
     * 특정 원소의 값을 수정하는 함수
     * start = 시작 인덱스
     * end = 끝 인덱스
     * dif = 수정할 값
     * 시간 복잡도 = O(logN)
     * */
    private static void update(int start, int end, int node, int index, int dif) {
        // 범위 밖에 있는 경우
        if (index < start || index > end) {
            return;
        }

        // 범위 안에 있으면 내려가며 다른 원소도 갱신
        tree[node] += dif;

        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;

        update(start, mid, node * 2, index, dif);
        update(mid + 1, end, node * 2 + 1, index, dif);

        /* 댓글 중
         * dif 는 수정할 값이 아니라
         * index 번째 수를 value 를 변경할 때 값의 차이를 diff 라고 하면, diff = value - array[index]
         *
         * int value = -5;
         * int index = 5;
         * int diff = value - array[index];
         * update(0, NUMBER-1, 1, index, diff);
         * array[index] = value // 추가
         * */
    }
}
