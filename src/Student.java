import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student extends Person {

    Scanner reader = new Scanner(System.in);
    public static List<Person> newerCredentials = new ArrayList<Person>();

    Solve_Exam exam = new Solve_Exam();
    public Student(int id,String name, String email, String password, String role) throws IOException {
      super(id,name,email,password, role);
    }

    @Override
    public void viewResults() {
        Result result = new Result();
        result.displayStudentResults();
    }

    public void takeExam() {

        if(Solve_Exam.theQuestions.size() > 0)
        {

            for (int i = 0; i < Solve_Exam.theQuestions.size(); i++)
            {
                System.out.println("[" + (i) +"]" + Solve_Exam.theQuestions.get(i).examTitle);
            }

            System.out.print("Enter the number of Exam to take: ");
            int examNumber = reader.nextInt();
            if(examNumber >= 0 && examNumber < Solve_Exam.theQuestions.size() )
            {
                Solve_Exam.SolveExam(examNumber);
            }
            else
            {
                takeExam();
            }
        }
        else
        {
            System.out.println("There is no exams Available Right Now!!");
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
