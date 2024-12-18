import java.io.*;
import java.util.ArrayList;

public class AdminMakeQuestions extends Questions implements Serializable{

    static ArrayList<AdminMakeQuestions> createdExam = new ArrayList<>();
    protected int examID;
    public String examTitle;
    public int duration;
    public String category;
    public ArrayList<Questions> questions = new ArrayList<>();

    @Override
    public int getTheCorrectOne() {
        return super.getTheCorrectOne();
    }

    public AdminMakeQuestions(String title, int duration, int examID, String category) {
        super(0,null, 0, null, 0);
        this.category = category;
        this.examTitle = title;
        this.duration = duration;
        this.examID = examID;
    }

     public Questions newQuestion() {
         //Question Title
         System.out.println("\n\n-------------------------------------------------------");
         System.out.println("Enter the question title:");
         theQuestionTitle = input.nextLine();


         //Question Mark
         System.out.println("\n\nEnter the mark for the question:");
         mark = limits();
         input.nextLine();


         //Num Of Options
         System.out.println("\n\nEnter the number of options");
         numOfOptions=limits(2,6);
         input.nextLine();

         //Options
         System.out.println("\n");
         questionOptions = new String[numOfOptions];

         input.nextLine();
         for (int i =0; i < numOfOptions ; i++){
             System.out.println("Enter option " + (i + 1) + ":");
             questionOptions[i] = input.nextLine();
             System.out.println("\n");
         }

         //Correct Choice
         System.out.println("\n\nEnter the number of the correct choice: \n");
         theCorrectOne = limits(1,numOfOptions);
         input.nextLine();
         return new GenericQuestion(0, null, 0, null, 0);
    }
}