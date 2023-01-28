// SWEA 2930 힙

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution {

    private static final int MAX_SIZE = 100000;

    private static int[] array;
    private static int currentLength;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());

            array = new int[MAX_SIZE];
            currentLength = 0;

            sb.append('#').append(testCase).append(' ');

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                if (Integer.parseInt(st.nextToken()) == 1) {
                    offer(Integer.parseInt(st.nextToken()));
                } else {
                    sb.append(poll()).append(' ');
                }
            }

            sb.append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void offer(int node) {
        int currentIndex = currentLength;

        while (currentIndex != 0 && node > array[(currentIndex - 1) / 2]) {
            array[currentIndex] = array[(currentIndex - 1) / 2];
            currentIndex = (currentIndex - 1) / 2;
        }

        array[currentIndex] = node;
        currentLength++;
    }

    private static int poll() {
        if (currentLength == 0) {
            return -1;
        }

        int node = array[0];

        array[0] = array[--currentLength];

        heapify(0);

        return node;
    }

    // Top-Down
    private static void heapify(int index) {
        int largest = index;
        int leftIndex = index * 2 + 1;
        int rightIndex = index * 2 + 2;

        if (leftIndex < currentLength && array[leftIndex] > array[largest]) {
            largest = leftIndex;
        }

        if (rightIndex < currentLength && array[rightIndex] > array[largest]) {
            largest = rightIndex;
        }

        if (largest != index) {
            int swap = array[index];
            array[index] = array[largest];
            array[largest] = swap;

            heapify(largest);
        }
    }
}
