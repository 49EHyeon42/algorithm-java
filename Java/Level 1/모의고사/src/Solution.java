import java.util.ArrayList;

public class Solution {

    public int[] solution(int[] answers) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, new int[]{1, 2, 3, 4, 5}));
        students.add(new Student(2, new int[]{2, 1, 2, 3, 2, 4, 2, 5}));
        students.add(new Student(3, new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}));

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == students.get(0).getAnswers()[i % 5]) {
                students.get(0).addScore();
            }
            if (answers[i] == students.get(1).getAnswers()[i % 8]) {
                students.get(1).addScore();
            }
            if (answers[i] == students.get(2).getAnswers()[i % 10]) {
                students.get(2).addScore();
            }
        }

        int maxScore = 0;
        for (Student student : students) {
            if (maxScore < student.getScore()) {
                maxScore = student.getScore();
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        for (Student student : students) {
            if (maxScore == student.getScore()) {
                answer.add(student.getNumber());
            }
        }

        return answer.stream().mapToInt(value -> value).toArray();
    }

    private static class Student {

        private final int number;
        private final int[] answers;

        private int score = 0;

        public Student(int number, int[] answers) {
            this.number = number;
            this.answers = answers;
        }

        public void addScore() {
            this.score++;
        }

        public int getNumber() {
            return number;
        }

        public int[] getAnswers() {
            return answers;
        }

        public int getScore() {
            return score;
        }
    }
}
