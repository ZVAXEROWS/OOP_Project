import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student extends Person {

    Scanner reader = new Scanner(System.in);
    public static List<Person> newerCredentials = new ArrayList<Person>();

    Solve_Exam exam;
    public Student(int id,String name, String email, String password, String role) throws IOException {
      super(id,name,email,password, role);
    }


    public void viewResults(List<String> student, Result upComingResult) {
        Result result = upComingResult;
        result.displayStudentResults();
    }

    public void takeExam(List<String> student, Result result) {

        if(!AdminMakeQuestions.createdExam.isEmpty())
        {

            for (int i = 0; i < AdminMakeQuestions.createdExam.size(); i++)
            {
                System.out.println("[" + (i) +"]" + AdminMakeQuestions.createdExam.get(i).examTitle);
            }

            System.out.print("Enter the number of Exam to take: ");
            int examNumber = reader.nextInt();
            if(examNumber >= 0 && examNumber < AdminMakeQuestions.createdExam.size() )
            {
                exam = new Solve_Exam();
                Solve_Exam.SolveExam(examNumber, result);
            }
            else
            {
                takeExam(student, result);
            }
        }
        else
        {
            System.out.println("\n\nThere is no exams Available Right Now!!\n\n");
        }
    }

    static public void register(int LastIdIndex) throws IOException {
        Scanner reader = new Scanner(System.in);
        int currentIndex = LastIdIndex;
        System.out.println("\t\t==========================================  Welcome to Register Page ==========================================\n\n");
        System.out.print("Name: ");
        String name = reader.nextLine();
        System.out.print("Email: ");
        String email = reader.nextLine();
        System.out.print("Password: ");
        String password = reader.nextLine();
        newerCredentials.add(new Student(++currentIndex,name,email,password,"student"));
    }


}
