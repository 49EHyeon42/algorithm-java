import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));

        PriorityQueue<Job> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(Job::getWorkingTime));

        int sum = 0;
        int index = 0;
        int currentTime = 0;

        while (index < jobs.length || !minHeap.isEmpty()) {
            while (index < jobs.length && currentTime == jobs[index][0]) {
                minHeap.offer(new Job(jobs[index][0], jobs[index][1]));
                index++;
            }

            if (!minHeap.isEmpty()) {
                Job currentNode = minHeap.poll();

                sum += (currentTime - currentNode.getRequestTime()) + currentNode.getWorkingTime();
                currentTime += currentNode.getWorkingTime();

                while (index < jobs.length && currentTime >= jobs[index][0]) {
                    minHeap.offer(new Job(jobs[index][0], jobs[index][1]));
                    index++;
                }
            } else {
                currentTime++;
            }
        }

        return sum / jobs.length;
    }

    static class Job {

        private final int requestTime;
        private final int workingTime;

        public Job(int requestTime, int workingTime) {
            this.requestTime = requestTime;
            this.workingTime = workingTime;
        }

        public int getRequestTime() {
            return requestTime;
        }

        public int getWorkingTime() {
            return workingTime;
        }
    }
}
