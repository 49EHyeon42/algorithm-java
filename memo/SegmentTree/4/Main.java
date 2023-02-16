public class Main {

    private static int[] tree;
    private static int firstIndexOfLeafNode;

    public static void main(String[] args) {
        int[] array = {1, 2, 3};

        System.out.println("Max tree level = " + getMaxTreeLevel(array.length));

        System.out.println("Tree size = " + getTreeSize(array.length));

        System.out.println("First index of leaf node = " + getFirstIndexOfLeafNode(array.length));

        tree = new int[getTreeSize(array.length)];
        firstIndexOfLeafNode = getFirstIndexOfLeafNode(array.length);

        // init
        for (int i = 0; i < array.length; i++) {
            update(i, array[i]);
        }

        printTree();
    }

    // Info: +1을 추가하여 1레벨부터 시작함
    private static int getMaxTreeLevel(int size) {
        return (int) Math.ceil(Math.log10(size) / Math.log10(2)) + 1;
    }

    // Info: +1은 요령껏 사용
    private static int getTreeSize(int size) {
        return 1 << (getMaxTreeLevel(size));
    }

    // Info: 트리 배열은 1부터 사용
    private static int getFirstIndexOfLeafNode(int size) {
        return 1 << (getMaxTreeLevel(size) - 1);
    }

    // Info: 재귀와 반복문의 트리 모양이 다름을 발견
    private static void update(int index, int value) {
        index = firstIndexOfLeafNode + index;

        tree[index] = value;

        while (index > 1) {
            tree[index >> 1] = tree[index] + tree[index ^ 1];

            index >>= 1;
        }
    }

    // Info: 부분합
    private static void query(int left, int right) {
    }

    private static void printTree() {
        for (int i : tree) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
