package exercises.exercises1;

import java.util.Collection;
import java.util.List;

public class Student {
    private String name;
    private int studentId;
    private List<Integer> quizScores;

    public Student(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public int getStudentId() {
        return studentId;
    }

    public List<Integer> getQuizScores() {
        return quizScores;
    }
}

