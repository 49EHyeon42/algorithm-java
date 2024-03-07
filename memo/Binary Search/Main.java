public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{10, 11, 12, 13, 14, 15, 16, 17, 18, 20};

        System.out.println("반복: " + iterationBinarySearch(array, 11));
        System.out.println("재귀: " + recursionBinarySearch(array, 0, array.length, 13));
    }

    // 반복 (권장)
    private static int iterationBinarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return high;
    }

    // 재귀
    private static int recursionBinarySearch(int[] array, int low, int high, int target) {
        if (low >= high) {
            return high;
        }

        int mid = (low + high) / 2;

        if (array[mid] < target) {
            return recursionBinarySearch(array, mid + 1, high, target);
        } else {
            return recursionBinarySearch(array, low, mid, target);
        }
    }
}
