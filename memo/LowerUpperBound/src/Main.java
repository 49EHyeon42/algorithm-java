/*
LowerBound 그리고 UpperBound 는 이분탐색에서 파생 알고리즘이다.

LowerBound : 정렬된 배열에서 target 보다 같거나 큰 값이 처음 나오는 index를 찾는 알고리즘
UpperBound : 정렬된 배열에서 target 보다 처음으로 큰 값이 나오는 index를 찾는 알고리즘
*/
public class Main {

    // example array
    private static int[] array = {10, 20, 30, 30, 30, 40, 50, 60, 70};

    public static void main(String[] args) {
        System.out.println("LowerBound");
        System.out.println("predict : " + 2 + " result : " + lowerBound(30));

        System.out.println("UpperBound");
        System.out.println("predict : " + 5 + " result : " + upperBound(30));
    }

    private static int lowerBound(int target) {
        int low = 0;
        int high = array.length - 1;
        int mid = 0;

        while (low <= high) {
            mid = (low + high) / 2;
            if (array[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private static int upperBound(int target) {
        int low = 0;
        int high = array.length - 1;
        int mid = 0;

        while (low <= high) {
            mid = (low + high) / 2;
            if (array[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
