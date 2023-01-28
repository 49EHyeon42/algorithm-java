// SWEA 3000 중간값 구하기

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        MaxHeap maxHeap = new MaxHeap();
        MinHeap minHeap = new MinHeap();

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            maxHeap.offer(Integer.parseInt(st.nextToken()));

            int sum = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                minHeap.offer(Integer.parseInt(st.nextToken()));
                maxHeap.offer(Integer.parseInt(st.nextToken()));

                if (maxHeap.peek() > minHeap.peek()) {
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(maxHeap.poll());
                }

                sum = (sum + maxHeap.peek()) % 20171109;
            }

            sb.append('#').append(testCase).append(' ').append(sum).append('\n');

            maxHeap.clear();
            minHeap.clear();
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }
}

// ArrayIndexOutOfBoundsException 생각 X

class MaxHeap {

    private final int[] array = new int[100002];
    private int currentLength;

    public void offer(int node) {
        int currentIndex = currentLength;

        while (currentIndex != 0 && node > array[(currentIndex - 1) / 2]) {
            array[currentIndex] = array[(currentIndex - 1) / 2];
            currentIndex = (currentIndex - 1) / 2;
        }

        array[currentIndex] = node;
        currentLength++;
    }

    public int poll() {
        int node = array[0];

        array[0] = array[--currentLength];

        heapify(0);

        return node;
    }

    private void heapify(int index) {
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

    public int peek() {
        return array[0];
    }

    public void clear() {
        currentLength = 0;
    }
}

class MinHeap {

    private final int[] array = new int[100002];
    private int currentLength;

    public void offer(int node) {
        int currentIndex = currentLength;

        while (currentIndex != 0 && node < array[(currentIndex - 1) / 2]) {
            array[currentIndex] = array[(currentIndex - 1) / 2];
            currentIndex = (currentIndex - 1) / 2;
        }

        array[currentIndex] = node;
        currentLength++;
    }

    public int poll() {
        int node = array[0];

        array[0] = array[--currentLength];

        heapify(0);

        return node;
    }

    private void heapify(int index) {
        int largest = index;
        int leftIndex = index * 2 + 1;
        int rightIndex = index * 2 + 2;

        if (leftIndex < currentLength && array[leftIndex] < array[largest]) {
            largest = leftIndex;
        }

        if (rightIndex < currentLength && array[rightIndex] < array[largest]) {
            largest = rightIndex;
        }

        if (largest != index) {
            int swap = array[index];
            array[index] = array[largest];
            array[largest] = swap;

            heapify(largest);
        }
    }

    public int peek() {
        return array[0];
    }

    public void clear() {
        currentLength = 0;
    }
}
