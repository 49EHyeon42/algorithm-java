import java.util.*;

class Solution {

    private final Map<String, Integer> map1 = new HashMap<>();
    private final Map<String, Integer> map2 = new HashMap<>();

    public int[] solution(int[] fees, String[] records) {
        for (String record : records) {
            StringTokenizer st = new StringTokenizer(record);
            int minute = convertTimeToMinute(st.nextToken());
            String number = st.nextToken();
            String inOut = st.nextToken();

            if (inOut.equals("IN")) {
                map1.put(number, minute);
            } else {
                map2.put(number, minute - map1.get(number) + map2.getOrDefault(number, 0));
                map1.remove(number);
            }
        }

        int maxMinute = convertTimeToMinute("23:59");

        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            map2.put(entry.getKey(), maxMinute - entry.getValue() + map2.getOrDefault(entry.getKey(), 0));
        }

        List<Car> cars = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            cars.add(new Car(entry.getKey(), entry.getValue()));
        }

        cars.sort(Comparator.comparing(car -> car.number));

        List<Integer> answer = new ArrayList<>();

        for (Car car : cars) {
            if (car.minute <= fees[0]) {
                answer.add(fees[1]);
            } else {
                int temp = (car.minute - fees[0]) / fees[2];

                if ((car.minute - fees[0]) % fees[2] != 0) {
                    temp++;
                }

                answer.add(fees[1] + temp * fees[3]);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    private int convertTimeToMinute(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    private static class Car {

        final String number;
        int minute;

        Car(String number, int minute) {
            this.number = number;
            this.minute = minute;
        }
    }
}
