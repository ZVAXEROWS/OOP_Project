
/*
Has an ID, Title, Category, Duration, Total Marks, and List of
Questions.
● Must have a time limit, after which it auto-submits.
*/
import java.util.Scanner;


public class Exam {
    private static int ID=0;
    private String Title;
    private String Category;
    private int Duration; //in minutes
    private float Total_Marks=0;
    private int NumOfQuestions; //in minutes
    private Question[]  ListOfQuestions;
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

    public void setListOfQuestions(int numofquestions) {
          ListOfQuestions = new Question[numofquestions];
        for (int i =0; i < numofquestions ; i++){
            System.out.println("Enter Question "+(i+1));
            ListOfQuestions[i]=new Question();
            setTotal_Marks(getTotal_Marks()+ListOfQuestions[i].getMark());
        }
    }


    public float display_totalmarks(){
        float n=getTotal_Marks();
        System.out.println("total mark = "+n);
        return n;
    }

    public Exam(){
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


        display_totalmarks();


    }

}
