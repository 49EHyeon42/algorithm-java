public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{-1, 12, 11, 13, 5, 6, 7};

        System.out.print("before sorting = ");
        printArray(array);

        quickSort(array, 0, array.length - 1);

        System.out.print("after sorting = ");
        printArray(array);
    }

    // 왼쪽 피벗을 활용한 퀵 정렬
    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int i = low + 1, j = high;

            while (i <= j) {
                while (array[i] <= array[low]) {
                    i++;
                }

                while (array[j] > array[low]) {
                    j--;
                }

                if (i < j) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }

            int temp = array[low];
            array[low] = array[j];
            array[j] = temp;

            quickSort(array, low, j - 1);
            quickSort(array, j + 1, high);
        }
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
