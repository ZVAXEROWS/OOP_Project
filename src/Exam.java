//last
/*
Has an ID, Title, Category, Duration, Total Marks, and List of
Questions.
● Must have a time limit, after which it auto-submits.
*/
import java.io.Serializable;
import java.util.*;

public class Exam implements Serializable {

    static int examID=0;
    String examTitle;
    String Category;
    static int Duration; //in minutes
    float Total_Marks;

    protected ArrayList<AdminMakeQuestions> theQuistons = new ArrayList<>();

    Scanner input = new Scanner(System.in);


    public ArrayList<AdminMakeQuestions> getTheQuistons() {
        return theQuistons;
    }


    //Getter & Setters
    public int getID() {
        return examID;
    }

    public String getTitle() {
        return examTitle;
    }

    public void setTitle(String title) {
        examTitle = title;
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

    public int setDuration(int duration) {
        Duration = duration;
        return duration;
    }

    public float getTotal_Marks() {
        return Total_Marks;
    }

    public void setTotal_Marks(float total_Marks) {
        Total_Marks = total_Marks;
    }


}
