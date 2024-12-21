package QuestionsPackage;

import java.io.*;
import java.util.ArrayList;

public class AdminMakeQuestions extends Questions implements Serializable{

    public static ArrayList<AdminMakeQuestions> createdExam = new ArrayList<>();
    public int examID;
    public String examTitle;
    public int duration;
    public String category;
    public ArrayList<Questions> questions = new ArrayList<>();

    @Override
    public int getTheCorrectOne() {
        return super.getTheCorrectOne();
    }

    public AdminMakeQuestions(String title, int duration, int examID, String category){
        super(0,null, 0, null, 0);
        this.examTitle = title;
        this.duration = duration;
        this.examID = examID;
        this.category=category;
    }



     public Questions newQuestion() {
         //Question Title
         System.out.println("\n\n-------------------------------------------------------");
         do{ System.out.println("Enter the question title:-\t");
             theQuestionTitle = input.nextLine();
             if(theQuestionTitle.isBlank()){System.out.println("No title provided \n\n");}
         }while(theQuestionTitle.isBlank());

         //Question Mark
         System.out.print("\n\nEnter the mark for the question  ");
         mark = limits();
         input.nextLine();


         //Num Of Options
         System.out.print("\n\nEnter the number of options ");
         numOfOptions=limits(2,6);

         //Options
         System.out.println("\n");
         questionOptions = new String[numOfOptions];
         input.nextLine();
         for (int i =0; i < numOfOptions ; i++){
             System.out.print("Enter option " + (i + 1) + ":\t");
             do{questionOptions[i] = input.nextLine();}
             while (questionOptions[i].isBlank());

             System.out.println("\n");
         }

         //Correct Choice
         System.out.println("\n\nEnter the number of the correct choice: \n");
         theCorrectOne = limits(1,numOfOptions);
         input.nextLine();
         return new GenericQuestion(0, null, 0, null, 0);
     }
}