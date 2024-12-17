import java.util.Scanner;

public class StudentQuestions extends Questions {

    private int studentMarks = 0;

    public StudentQuestions() {
        super(0, null, 0, null, 0);
    }

    public int getStudentMarks() {
        return studentMarks;
    }
    static int x = 1;


    public void solveQuestion(Questions questions){

        System.out.println("Question: " + x);
        x++;

        System.out.println(questions.getTheQuestionTitle() + "\n");

        String[] options = questions.getQuestionOptions();

        for (int i = 0; i< options.length ; i++){
            System.out.println((i+1)+": "+options[i]);
        }

        System.out.println("Enter your Answer: ");
        Scanner input = new Scanner(System.in);
        int answer = input.nextInt();
        System.out.println("-------------------------------------------------------\n\n\n");

        if (answer == questions.getTheCorrectOne()){ studentMarks += questions.getMark(); }

    }
}