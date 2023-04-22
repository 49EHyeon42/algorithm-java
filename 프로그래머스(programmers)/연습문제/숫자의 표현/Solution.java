public class Solution {

    public int solution(int n) {
        int[] array = new int[n + 1];
        
        for(int i = 1; i <= n; i++) {
            array[i] = i;
        }
        
        int count = 0;
        int sum = 0;
        int front = 1;
        int rear = 1;
        
        while (front <= n) {
            if (sum >= n) {
                sum -= array[front];
                front++;
            } else {
                sum += array[rear];
                rear++;
            }
            
            if (sum == n) {
                count++;
            }
        }

        return count;
    }
}
