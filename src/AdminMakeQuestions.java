import java.io.*;
import java.util.ArrayList;

public class AdminMakeQuestions extends Questions implements Serializable{

    static ArrayList<AdminMakeQuestions> createdExam = new ArrayList<>();
    public String examTitle;
    public int duration;
    public ArrayList<Questions> questions = new ArrayList<>();

    @Override
    public int getTheCorrectOne() {
        return super.getTheCorrectOne();
    }

    public AdminMakeQuestions(String title, int duration){
        super(0,null, 0, null, 0);
        this.examTitle = title;
        this.duration = duration;
    }

     public Questions newQuestion() {
        //Question Title
        System.out.println("Enter the question title:");
        theQuestionTitle = input.nextLine();


        //Question Mark
        System.out.println("Enter the mark for the question:");
        mark = limits();


        //Num Of Options
        System.out.println("Enter the number of options");
        numOfOptions=limits(2,6);

        //Options
        questionOptions = new String[numOfOptions];

        input.nextLine();
        for (int i =0; i < numOfOptions ; i++){
            System.out.println("Enter option " + (i + 1) + ":");
            questionOptions[i] = input.nextLine();
        }

        //Correct Choice
        System.out.println("Enter the number of the correct choice:");
        theCorrectOne = limits(1,numOfOptions);
        return new Questions(0,null,0,null,0);
    }
}