package exercises.exercises1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Session {
    private List<Student> students;

    public Session() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public double calculateAverageQuizScore() {
        int total = 0;
        int count = 0;
        for (Student student : students) {
            List<Integer> quizScores = student.getQuizScores();
            if (quizScores != null) {
                for (int score : quizScores) {
                    total += score;
                    count++;
                }
            }
        }
        return total / (double) count;
    }

    public void printQuizScoresAscending() {
        List<Integer> allQuizScores = new ArrayList<>();
        for (Student student : students) {
            List<Integer> quizScores = student.getQuizScores();
            if (quizScores != null) {
                allQuizScores.addAll(quizScores);
            }
        }
        Collections.sort(allQuizScores);
        System.out.println("Quiz Scores in Ascending Order:");
        for (int i = 0; i < allQuizScores.size(); i++) {
            System.out.print(allQuizScores.get(i));
            if (i < allQuizScores.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println(); 
    }

    public void printPartTimeNames() {
        System.out.println("Part-Time Students' Names:");
        for (Student student : students) {
            if (student instanceof PartTime) {
                System.out.println(student.getName());
            }
        }
    }

    public void printFullTimeExamScores() {
        System.out.println("Full-Time Students' Exam Scores:");
        for (Student student : students) {
            if (student instanceof FullTime) {
                FullTime fullTime = (FullTime) student;
                System.out.println(fullTime.getName() + ": Exam1 - " + fullTime.getExamScore1() + ", Exam2 - " + fullTime.getExamScore2());
            }
        }
    }
}
