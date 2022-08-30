public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test 1
        int bridge_length1 = 2;
        int weight1 = 10;
        int[] truck_weights1 = {7, 4, 5, 6};
        int result1 = 8;

        System.out.println(
            "test case 1 = " + (solution.solution(bridge_length1, weight1, truck_weights1)
                == result1));

        // test 2
        int bridge_length2 = 100;
        int weight2 = 100;
        int[] truck_weights2 = {10};
        int result2 = 101;

        System.out.println(
            "test case 2 = " + (solution.solution(bridge_length2, weight2, truck_weights2)
                == result2));

        // test 3
        int bridge_length3 = 100;
        int weight3 = 100;
        int[] truck_weights3 = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        int result3 = 110;

        System.out.println(
            "test case 3 = " + (solution.solution(bridge_length3, weight3, truck_weights3)
                == result3));
    }
}
