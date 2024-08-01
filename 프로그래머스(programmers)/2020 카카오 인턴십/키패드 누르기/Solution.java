class Solution {

    private final int[][] coordinate = {{3, 1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}};

    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();

        int[] leftThumbCoordinate = {3, 0};
        int[] rightThumbCoordinate = {3, 2};

        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                sb.append('L');
                leftThumbCoordinate = coordinate[number];
            } else if (number == 3 || number == 6 || number == 9) {
                sb.append('R');
                rightThumbCoordinate = coordinate[number];
            } else { // number == 2 || number == 5 || number == 8 || number == 0
                int leftLength = getManhattanDistance(coordinate[number], leftThumbCoordinate);
                int rightLength = getManhattanDistance(coordinate[number], rightThumbCoordinate);

                if (leftLength < rightLength) {
                    sb.append('L');
                    leftThumbCoordinate = coordinate[number];
                } else if (leftLength > rightLength) {
                    sb.append('R');
                    rightThumbCoordinate = coordinate[number];
                } else { // leftThumb == rightLength
                    if (hand.equals("left")) {
                        sb.append('L');
                        leftThumbCoordinate = coordinate[number];
                    } else { // hand.equals("right")
                        sb.append('R');
                        rightThumbCoordinate = coordinate[number];
                    }
                }
            }
        }

        return sb.toString();
    }

    private int getManhattanDistance(int[] coordinate1, int[] coordinate2) {
        return Math.abs(coordinate1[0] - coordinate2[0]) + Math.abs(coordinate1[1] - coordinate2[1]);
    }
}
