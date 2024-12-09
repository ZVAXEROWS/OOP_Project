import java.util.Scanner;

public class StudentQuestion extends Questions {

    private int studentMarks = 0;

    public int getStudentMarks() {
        return studentMarks;
    }

    public void solveQuestion(Questions question){

        System.out.println("Question: " + Questions.getID());
        System.out.println(question.getTheQuestionTitle());

        String[] options = question.getQuistionOptions();

        for (int i = 0; i<options.length ; i++){
            System.out.println((i+1)+": "+options[i]);
        }

        System.out.println("Enter your Answer: ");
        Scanner input = new Scanner(System.in);
        int answer = input.nextInt();

        if (answer == question.getTheCorrectOne()){ studentMarks += question.getMark(); }

    }
}
