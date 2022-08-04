public class Main {

    public static void main(String[] args) {
        // 0번째 인덱스 사용하지 않기
        int[] testArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // start, end, index 고정
        SegmentTree segmentTree = new SegmentTree(testArray);

        // 1부터 2까지의 구간 합
        System.out.println("array[1] + array[2] = "
            + segmentTree.getSum(0, testArray.length - 1, 1,
            1, 2));

        // 1부터 3까지의 구간 합
        System.out.println("array[1] ~ array[3] = "
            + segmentTree.getSum(0, testArray.length - 1, 1,
            1, 3));

        // 1부터 4까지의 구간 합
        System.out.println("array[1] ~ array[4] = "
            + segmentTree.getSum(0, testArray.length - 1, 1,
            1, 4));

        // 1부터 5까지의 구간 합
        System.out.println("array[1] ~ array[5] = "
            + segmentTree.getSum(0, testArray.length - 1, 1,
            1, 5));

        // 1번째 인덱스 값을 100으로 수정
        segmentTree.update(0, testArray.length - 1, 1, 1, 100);

        // 1부터 2까지의 구간 합
        System.out.println("100 + 2 = "
            + segmentTree.getSum(0, testArray.length - 1, 1,
            1, 2));

        // 2번째 인덱스 값을 100으로 수정
        segmentTree.update(0, testArray.length - 1, 1, 2, 100);

        // 1부터 2까지의 구간 합
        System.out.println("100 + 100 = "
            + segmentTree.getSum(0, testArray.length - 1, 1,
            1, 2));
    }
}
