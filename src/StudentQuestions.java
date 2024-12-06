import java.util.Scanner;

public class StudentQuestions extends Questions {

    private int studentMarks = 0;

    public int getStudentMarks() {
        return studentMarks;
    }
    static int x = 1;


    public void solveQestion(Questions quistion){

        System.out.println("Quistion: " + x);
        x++;

        System.out.println(quistion.getTheQuestionTitle() + "\n");

        String[] options = quistion.getQuistionOptions();

        for (int i = 0; i<options.length ; i++){
            System.out.println((i+1)+": "+options[i]);
        }

        System.out.println("Enter your Answer: ");
        Scanner input = new Scanner(System.in);
        int answer = input.nextInt();

        if (answer == quistion.getTheCorrectOne()){ studentMarks += quistion.getMark(); }

    }
}
