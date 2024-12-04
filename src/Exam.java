
/*
Has an ID, Title, Category, Duration, Total Marks, and List of
Questions.
● Must have a time limit, after which it auto-submits.
*/
import java.util.Scanner;


public class Exam {
    static int ID=0;
    String Title;
    String Category;
    int Duration; //in minutes
    float Total_Marks;
    int NumOfQuestions; //in minutes
    Question[]  ListOfQuestions;
    Scanner input = new Scanner(System.in);

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public int getDuration() {
        return Duration;
    }

    public void setDuration(int duration) {
        Duration = duration;
    }

    public float getTotal_Marks() {
        return Total_Marks;
    }

    public void setTotal_Marks(float total_Marks) {
        Total_Marks = total_Marks;
    }

    public int getNumOfQuestions() {
        return NumOfQuestions;
    }

    public void setNumOfQuestions(int numOfQuestions) {
        NumOfQuestions = numOfQuestions;
    }

    public Question[] getListOfQuestions() {
        return ListOfQuestions;
    }

    public void setListOfQuestions(int numofquestions) {
        ListOfQuestions = new Question[numofquestions];
        for (int i =0; i < numofquestions ; i++){
            System.out.println("Enter Question "+(i+1));
            ListOfQuestions[i]=new Question();
            setTotal_Marks(getTotal_Marks()+ListOfQuestions[i].getMark());
        }
    }



}
