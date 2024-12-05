import java.util.*;

public class Solve_Exam extends Exam{

/**
 * private int studentMarks = 0;

 *  public int getStudentMarks() {
        return studentMarks;
    }
*/

    public Solve_Exam(ArrayList<AdminMakeQuestions> theQuistons){

        // the exam will be started , work in timer

        int totalMarks = 0;
        StudentQuestions studentQuestions = new StudentQuestions();

        System.out.println("Number of questions: " + theQuistons.size());

        for (Questions question : theQuistons) {
            totalMarks += question.getMark();
            studentQuestions.solveQestion(question);
        }

        System.out.println("Your degree is " + studentQuestions.getStudentMarks() + " of " + totalMarks);
    }



}
//last