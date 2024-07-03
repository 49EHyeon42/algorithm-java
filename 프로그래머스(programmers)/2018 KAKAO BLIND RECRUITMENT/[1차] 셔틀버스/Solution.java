import java.util.*;

class Solution {

    public String solution(int n, int t, int m, String[] timetable) {
        int[] newTimeTable = new int[timetable.length];

        for (int i = 0; i < timetable.length; i++) {
            newTimeTable[i] = timeToMinute(timetable[i]);
        }

        Arrays.sort(newTimeTable);

        int result = 0;

        int currnetMinute = 540; // 540 == 09:00
        int currentIndex = 0;

        for (int i = 0; i < n; i++) {
            int currentPeople = 0;

            while (currentIndex < newTimeTable.length &&
                    newTimeTable[currentIndex] <= currnetMinute &&
                    currentPeople < m) {
                currentIndex++;
                currentPeople++;
            }

            // currentPeople이 m 보다 큰 경우는 없다.
            result = currentPeople == m ?
                    newTimeTable[currentIndex - 1] - 1 :
                    currnetMinute;

            currnetMinute += t;
        }

        return minuteToTime(result);
    }

    public int timeToMinute(String time) {
        int minute = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < time.length(); i++) {
            if (i == 2) {
                minute = Integer.parseInt(sb.toString()) * 60;
                sb.setLength(0);
                continue;
            }

            sb.append(time.charAt(i));
        }

        minute += Integer.parseInt(sb.toString());

        return minute;
    }

    public String minuteToTime(int minute) {
        return String.format("%02d", minute / 60) + ":" + String.format("%02d", minute % 60);
    }
}
