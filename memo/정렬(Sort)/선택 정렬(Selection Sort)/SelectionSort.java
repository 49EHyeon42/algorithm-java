public class SelectionSort {

    public void naturalSelectionSort(int[] array) {
        int length = array.length;

        for (int i = 0; i < length - 1; i++) {
            int minimumIndex = i;

            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[minimumIndex]) {
                    minimumIndex = j;
                }
            }

            int swap = array[minimumIndex];
            array[minimumIndex] = array[i];
            array[i] = swap;
        }
    }

    public void reverseSelectionSort(int[] array) {
        int length = array.length;

        for (int i = 0; i < length - 1; i++) {
            int maximumIndex = i;

            for (int j = i + 1; j < length; j++) {
                if (array[j] > array[maximumIndex]) {
                    maximumIndex = j;
                }
            }

            int swap = array[maximumIndex];
            array[maximumIndex] = array[i];
            array[i] = swap;
        }
    }
}
