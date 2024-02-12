package exercises.exercises1;

public class Main {
    public static void main(String[] args) {
        Session session = new Session();

        for (int i = 1; i <= 20; i++) {
            if (i % 3 == 0) {
                PartTime partTime = new PartTime("Part-Time Student " + i, i);
                for (int j = 1; j <= 15; j++) {
                    partTime.addQuizScore((int) (Math.random() * 100)); 
                }
                session.addStudent(partTime);
            } else {
                FullTime fullTime = new FullTime("Full-Time Student " + i, i);
                fullTime.setExamScore1((int) (Math.random() * 100)); 
                fullTime.setExamScore2((int) (Math.random() * 100));
                session.addStudent(fullTime);
            }
        }

        System.out.println("Average Quiz Score: " + session.calculateAverageQuizScore());
        session.printQuizScoresAscending();
        session.printPartTimeNames();
        session.printFullTimeExamScores();
    }
}
