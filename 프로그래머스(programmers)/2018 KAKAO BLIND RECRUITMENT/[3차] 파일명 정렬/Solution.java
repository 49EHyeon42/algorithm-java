import java.util.*;

class Solution {

    public String[] solution(String[] files) {
        List<File> fileList = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for (String file : files) {
            int index = 0;

            while (!('0' <= file.charAt(index) && file.charAt(index) <= '9')) {
                sb.append(file.charAt(index++));
            }

            String head = sb.toString();

            sb.setLength(0);

            // TAIL이 없는 경우도 있다.
            while (index < file.length() && '0' <= file.charAt(index) && file.charAt(index) <= '9') {
                sb.append(file.charAt(index++));
            }

            String number = sb.toString();

            sb.setLength(0);

            while (index < file.length()) {
                sb.append(file.charAt(index++));
            }

            String tail = sb.toString();

            sb.setLength(0);

            fileList.add(new File(head, number, tail));
        }

        fileList.sort((file1, file2) -> {
            int result = file1.head.toLowerCase().compareTo(file2.head.toLowerCase());

            if (result != 0) {
                return result;
            }

            int number1 = Integer.parseInt(file1.number);
            int number2 = Integer.parseInt(file2.number);

            if (number1 != number2) {
                return number1 - number2;
            }

            return 0;
        });

        return fileList.stream().map(File::getOriginalFileName).toArray(String[]::new);
    }

    private static class File {

        final String head;
        final String number;
        final String tail;

        File(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        String getOriginalFileName() {
            return head + number + tail;
        }
    }
}
