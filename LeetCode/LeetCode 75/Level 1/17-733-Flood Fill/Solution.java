import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private static final int[] dy = {1, -1, 0, 0};
    private static final int[] dx = {0, 0, 1, -1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }

        int changeColor = image[sr][sc];

        int maxLength = image.length;
        int maxWidth = image[0].length;

        Queue<int[]> queue = new LinkedList<>();

        image[sr][sc] = color;
        queue.offer(new int[]{sr, sc});

        while (!queue.isEmpty()) {
            int[] currentColor = queue.poll();

            for (int i = 0; i < 4; i++) {
                int currentLength = currentColor[0] + dy[i];
                int currentWidth = currentColor[1] + dx[i];

                if (isPossible(maxLength, maxWidth, currentLength, currentWidth)
                    && image[currentLength][currentWidth] == changeColor) {
                    image[currentLength][currentWidth] = color;
                    queue.offer(new int[]{currentLength, currentWidth});
                }
            }
        }

        return image;
    }

    private boolean isPossible(int maxLength, int maxWidth, int currentLength, int currentWidth) {
        return currentLength >= 0 && currentWidth >= 0 && currentLength < maxLength
            && currentWidth < maxWidth;
    }
}
