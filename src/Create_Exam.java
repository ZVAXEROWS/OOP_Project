import java.util.Scanner;

public class Create_Exam extends Exam{


    public Create_Exam(){
        ++ID;

        //Exam Title
        System.out.println("Set Exam "+getID()+" _ Title");
        String title =input.nextLine();
        setTitle(title);


        //Exam Category
        System.out.println("Set Exam "+getID()+" _ Category");
        String Category = input.nextLine();
        setCategory(Category);


        //Exam Duration
        System.out.println("Set Exam "+getID()+" _ Duration In Minutes");
        int duration = input.nextInt();
        setDuration(duration);


        //Exam Number Of Questions
        System.out.println("Set Number Of Questions to Exam "+getID());
        int numofquestions = input.nextInt();
        setNumOfQuestions(numofquestions);


        //Exam List Of Questions
        setListOfQuestions(getNumOfQuestions());



    }




}
