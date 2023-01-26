// reference : https://www.geeksforgeeks.org/heap-sort/
public class Example1 {

    public static void main(String[] args) {
        // 루트 노드의 인덱스가 0으로 시작하는 경우
        //  - 부모의 인덱스 = (자식의 인덱스 - 1) / 2
        //  - 왼쪽 자식 인덱스 = (부모의 인덱스) * 2 + 1
        //  - 오른쪽 자식 인덱스 = (부모의 인덱스) * 2 + 2
        int[] array = new int[]{12, 11, 13, 5, 6, 7};

        System.out.print("before sorting = ");
        printArray(array);

        sort(array);

        System.out.print("after sorting = ");
        printArray(array);
    }

    private static void sort(int[] array) {
        int N = array.length;

        for (int i = N / 2 - 1; i >= 0; i--) {
            heapify(array, N, i);
        }

        System.out.print("make tree = ");
        printArray(array);

        for (int i = N - 1; i > 0; i--) {
            // swap
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int size, int index) {
        int largest = index;
        // 왼쪽 자식 인덱스 = (부모의 인덱스) * 2 + 1
        int leftIndex = 2 * index + 1;
        // 오른쪽 자식 인덱스 = (부모의 인덱스) * 2 + 2
        int rightIndex = 2 * index + 2;

        if (leftIndex < size && array[leftIndex] > array[largest]) {
            largest = leftIndex;
        }

        if (rightIndex < size && array[rightIndex] > array[largest]) {
            largest = rightIndex;
        }

        if (largest != index) {
            int swap = array[index];
            array[index] = array[largest];
            array[largest] = swap;

            heapify(array, size, largest);
        }
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
