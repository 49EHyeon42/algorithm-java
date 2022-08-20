public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test 1
        int[] nums1 = {1, 2, 3, 4};
        int result1 = 1;

        System.out.println("test case 1 = " + (solution.solution(nums1) == result1));

        // test 2
        int[] nums2 = {1, 2, 7, 6, 4};
        int result2 = 4;

        System.out.println("test case 2 = " + (solution.solution(nums2) == result2));
    }
}
