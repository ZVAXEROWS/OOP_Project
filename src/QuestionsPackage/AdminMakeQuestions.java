package QuestionsPackage;

import java.io.*;
import java.util.ArrayList;

public class AdminMakeQuestions extends Questions implements Serializable{

    public static ArrayList<AdminMakeQuestions> createdExam = new ArrayList<>();
    protected int examID;
    public String examTitle;
    public int duration;
    public ArrayList<Questions> questions = new ArrayList<>();

    @Override
    public int getTheCorrectOne() {
        return super.getTheCorrectOne();
    }

    public AdminMakeQuestions(String title, int duration, int examID){
        super(0,null, 0, null, 0);
        this.examTitle = title;
        this.duration = duration;
        this.examID = examID;
    }

     public Questions newQuestion() {
        //Question Title
        System.out.println("Enter the question title:");
        input.nextLine();
        theQuestionTitle = input.nextLine();


        //Question Mark
         System.out.println("\n\n\n-------------------------------------------------------");
         System.out.println("Enter the mark for the question:");
         mark = limits();


        //Num Of Options
         System.out.println("\n\n\n-------------------------------------------------------");
        System.out.println("Enter the number of options");
        numOfOptions=limits(2,6);

        //Options
         System.out.println("\n\n\n-------------------------------------------------------");
        questionOptions = new String[numOfOptions];

        input.nextLine();
        for (int i =0; i < numOfOptions ; i++){
            System.out.println("Enter option " + (i + 1) + ":");
            questionOptions[i] = input.nextLine();
            System.out.println("\n");
        }

        //Correct Choice
         System.out.println("\n\n\n-------------------------------------------------------");
        System.out.println("Enter the number of the correct choice: \n");
        theCorrectOne = limits(1,numOfOptions);
         return new GenericQuestion(0, null, 0, null, 0);

     }
}