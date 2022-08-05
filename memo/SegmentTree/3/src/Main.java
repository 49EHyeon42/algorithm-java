public class Main {

    public static void main(String[] args) {
        // 0번째 인덱스 사용하지 않기
        long[] testArray = new long[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        SegmentTree segmentTree = new SegmentTree(testArray);

        segmentTree.update2(0, testArray.length - 1, 1, 1, 5);

        // 5 + 2
        System.out.println(segmentTree.getSum(0, testArray.length - 1, 1, 1, 2));

        segmentTree.update2(0, testArray.length - 1, 1, 9, 20);
        segmentTree.update2(0, testArray.length - 1, 1, 10, 100);

        // 20 + 100
        System.out.println(segmentTree.getSum(0, testArray.length - 1, 1, 9, 10));
    }
}
