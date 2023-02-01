// reference : https://st-lab.tistory.com/250
public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{2, -5, 6, 7, 1, 5, 2};

        System.out.print("before sorting = ");
        printArray(array);

        // leftSort(array, 0, array.length - 1);
        // rightSort(array, 0, array.length - 1);
        // middleSort(array, 0, array.length - 1);

        System.out.print("after sorting = ");
        printArray(array);
    }

    // 왼쪽 피벗 퀵 정렬
    private static void leftSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivot = leftPartition(array, low, high);

        leftSort(array, low, pivot - 1);
        leftSort(array, pivot + 1, high);
    }

    private static int leftPartition(int[] array, int left, int right) {
        int low = left;
        int high = right;
        int pivot = array[left];

        while (low < high) {
            while (array[high] > pivot && low < high) {
                high--;
            }

            while (array[low] <= pivot && low < high) {
                low++;
            }

            int swap = array[low];
            array[low] = array[high];
            array[high] = swap;
        }

        int swap = array[left];
        array[left] = array[low];
        array[low] = swap;

        return low;
    }

    // 오른쪽 피벗 퀵 정렬
    private static void rightSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivot = rightPartition(array, low, high);

        rightSort(array, low, pivot - 1);
        rightSort(array, pivot + 1, high);
    }

    private static int rightPartition(int[] array, int left, int right) {
        int low = left;
        int high = right;
        int pivot = array[right];

        while (low < high) {
            while (array[low] < pivot && low < high) {
                low++;
            }

            while (array[high] >= pivot && low < high) {
                high--;
            }

            int swap = array[low];
            array[low] = array[high];
            array[high] = swap;
        }

        int swap = array[right];
        array[right] = array[high];
        array[high] = swap;

        return high;
    }

    // 중간 피벗 퀵 정렬
    private static void middleSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivot = middlePartition(array, low, high);

        middleSort(array, low, pivot - 1);
        middleSort(array, pivot + 1, high);
    }

    private static int middlePartition(int[] array, int left, int right) {
        int low = left - 1;
        int high = right + 1;
        int pivot = array[(left + right) / 2];

        while (true) {
            do {
                low++;
            } while (array[low] < pivot);

            do {
                high--;
            } while (array[high] > pivot && low <= high);

            if (low >= high) {
                return high;
            }

            int swap = array[low];
            array[low] = array[high];
            array[high] = swap;
        }
    }

    // 배열 출력 확인용
    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
