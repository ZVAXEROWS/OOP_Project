//last
/*
Has an ID, Title, Category, Duration, Total Marks, and List of
Questions.
● Must have a time limit, after which it auto-submits.
*/
import java.io.Serializable;

public class Exam implements Serializable {

    static int examID = !AdminMakeQuestions.createdExam.isEmpty() ? AdminMakeQuestions.createdExam.size(): 0 ;
    String Category;
    static int Duration; //in minutes


    //Getter & Setters
    public int getID() {
        return examID;
    }

    public void setCategory(String category) {
        Category = category;
    }


    public int setDuration(int duration) {
        Duration = duration;
        return duration;
    }



}