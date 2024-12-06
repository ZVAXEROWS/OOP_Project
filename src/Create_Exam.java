import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Create_Exam extends Exam{

    static FileHandling fileHandling = new FileHandling("The_Exam.txt");

    static Questions helper = new Questions();


    public static void CreateExam(Exam exam) throws IOException {
        ++examID;
        Scanner input = new Scanner(System.in);

        //Exam Title
        System.out.println("Set Exam "+exam.getID()+" _ Title");
        String title =input.nextLine();
        exam.setTitle(title);


        //Exam Category
        System.out.println("Set Exam "+exam.getID()+" _ Category");
        String Category = input.nextLine();
        exam.setCategory(Category);


        //Exam Duration
        System.out.println("Set Exam "+exam.getID()+" _ Duration In Minutes");
        int duration = helper.limits();
        exam.setDuration(duration);


        boolean firstQ = true;
        while (true) {
            if (firstQ == false) {

                System.out.println("do You want to continue - done or no to end");
                String isDone = input.nextLine().toLowerCase();

                if (isDone.equals("done") || isDone.equals("no")) {
                    break;
                }
            }

            AdminMakeQuestions newQuestion = new AdminMakeQuestions();
            exam.getTheQuistons().add(newQuestion);
            firstQ = false;
        }



        fileHandling.writeObject(exam.getTheQuistons());


    }


}
