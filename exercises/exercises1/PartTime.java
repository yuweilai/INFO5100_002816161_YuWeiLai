package exercises.exercises1;

import java.util.List;
import java.util.ArrayList;

public class PartTime extends Student {
    private List<Integer> quizScores;

    public PartTime(String name, int studentId) {
        super(name, studentId);
        quizScores = new ArrayList<>();
    }

    public List<Integer> getQuizScores() {
        return quizScores;
    }

    public void addQuizScore(int score) {
        quizScores.add(score);
    }
}
