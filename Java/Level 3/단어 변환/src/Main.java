public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test 1
        String begin1 = "hit";
        String target1 = "cog";
        String[] words1 = {"hot", "dot", "dog", "lot", "log", "cog"};
        int result1 = 4;

        System.out.println(
            "test case 1 = " + (solution.solution(begin1, target1, words1) == result1));

        // test 2
        String begin2 = "hit";
        String target2 = "cog";
        String[] words2 = {"hot", "dot", "dog", "lot", "log"};
        int result2 = 0;

        System.out.println(
            "test case 2 = " + (solution.solution(begin2, target2, words2) == result2));

        // Add  test 3
        String begin3 = "hit";
        String target3 = "hhh";
        String[] words3 = {"hhh", "hht"};
        int result3 = 2;

        System.out.println(
            "test case 3 = " + (solution.solution(begin3, target3, words3) == result3));
    }
}
