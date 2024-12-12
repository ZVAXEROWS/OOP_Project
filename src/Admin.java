import java.io.IOException;
import java.util.*;

public class Admin extends Person {
    Scanner reader = new Scanner(System.in);

    public Admin(int id, String name, String email, String password, String role)
    {
        super(id, name, email, password, role);
    }


    public void viewResults(List<Student> students, List<Result> results)
    {
        int counter = 0;
        System.out.println("available Students:\n");
        for(Student student : students)
        {
            System.out.println("["+ (counter++) + "] "+student.name);
        }
        System.out.print("\nEnter the number of the student to view his results: ");
        int choice = reader.nextInt();

        try
        {
            students.get(choice).viewResults(results.get(choice));

        }catch (IndexOutOfBoundsException e)
        {
            System.out.println("\nStudent not found");
            viewResults(students, results);
        }
    }

    public void createExam() throws IOException {
        Exam exam = new Exam();
        Create_Exam.CreateExam(exam);
    }

    public void generateReport()
    {
        System.out.println("Admin Generate Report");
    }
}
