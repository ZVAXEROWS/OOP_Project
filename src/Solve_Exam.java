import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Solve_Exam extends Exam{

    static ArrayList<AdminMakeQuestions> theQuestions;
   // ArrayList<AdminMakeQuestions> currenExam = theQuestions;

    public static void SolveExam(int examIndex){

        // the exam will be started , work in timer
        AtomicBoolean timeUp = new AtomicBoolean(false);
        AtomicBoolean stopExam = new AtomicBoolean(false);


        // Number of seconds for the timer
        int durationInSeconds = theQuestions.get(examIndex).duration*60;

        // Start the timer
        Thread timerThread = new Thread(() -> {
            try {
                Thread.sleep(durationInSeconds * 1000L);
                timeUp.set(true);
                System.out.println("\nTime's up!");
                stopExam.set(true);


            } catch (InterruptedException e) {
                System.out.println("Timer interrupted!");
            }
        });

        timerThread.start();


        int totalMarks = 0, y=0;
        StudentQuestions studentQuestions = new StudentQuestions();

        System.out.println("Number of questions: " + theQuestions.get(examIndex).questions.size());

        for (int i = 0; i < theQuestions.get(examIndex).questions.size(); i++) {

            if(timeUp.get() || stopExam.get()){
                break;
            }

            totalMarks += theQuestions.get(examIndex).questions.get(i).getMark();
            studentQuestions.solveQuestion(theQuestions.get(examIndex).questions.get(i));
            y++;

            if (y == theQuestions.get(examIndex).questions.size()) {
                stopExam.set(true);
            }

        }

        if (!timeUp.get()) {
            timerThread.interrupt();
        }

        System.out.println("Your degree is " + studentQuestions.getStudentMarks() + " of " + totalMarks);
    }



}