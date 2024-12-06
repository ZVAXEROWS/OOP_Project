import java.time.Duration;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Solve_Exam extends Exam{

/*    private int studentMarks = 0;

    public int getStudentMarks() {
        return studentMarks;
    }
*/

    static ArrayList<AdminMakeQuestions> theQuistons;


    public static void SolveExam(){

        // the exam will be started , work in timer
        AtomicBoolean timeUp = new AtomicBoolean(false);
        AtomicBoolean stopExam = new AtomicBoolean(false);


        // Number of seconds for the timer
        int durationInSeconds = Duration*60;

        // Start the timer
        Thread timerThread = new Thread(() -> {
            try {
                Thread.sleep(durationInSeconds * 1000);
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

        System.out.println("Number of questions: " + theQuistons.size());

        for (Questions question : theQuistons) {

            if(timeUp.get() || stopExam.get()){
                break;
            }

            totalMarks += question.getMark();
            studentQuestions.solveQestion(question);
            y++;

            if (y == theQuistons.size()) {
                stopExam.set(true);
            }

        }

        if (!timeUp.get()) {
            timerThread.interrupt();
        }

        System.out.println("Your degree is " + studentQuestions.getStudentMarks() + " of " + totalMarks);
    }



}
