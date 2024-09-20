import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

class Result {

    public static String gridChallenge(List<String> grid) {
        for (int i = 0; i < grid.size(); i++) {
            char[] charArray = grid.get(i).toCharArray();
            Arrays.sort(charArray);
            grid.set(i, new String(charArray));
        }

        for (int i = 0; i < grid.get(0).length(); i++) {
            for (int j = 0; j < grid.size() - 1; j++) {
                if (grid.get(j).charAt(i) > grid.get(j + 1).charAt(i)) {
                    return "NO";
                }
            }
        }

        return "YES";
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }).collect(toList());

                String result = Result.gridChallenge(grid);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
