<<<<<<< Updated upstream
public class Main {
    public static void main(String[] args) {
// mooo
    }
=======
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
//    public static void main(String[] args) {
//
//        Exam exam = new Exam();
//        Create_Exam x = new Create_Exam(exam);
//        Solve_Exam s = new Solve_Exam(exam.getTheQuistons());
//
//
//    }


    static Scanner reader = new Scanner(System.in);
    static List<Student> students = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        FileHandling fileHandling = new FileHandling("users.txt");
        fileHandling.readDataForUsers();
        List<String> LoggedOnUserData = Person.Login(FileHandling.people);

        if(LoggedOnUserData.getLast().equals("admin"))
        {
            System.out.println("\t\t==============================  Welcome to Admin dashboard  ==============================\n\n");
            adminMethods(Integer.parseInt(LoggedOnUserData.getFirst()),LoggedOnUserData.get(1),LoggedOnUserData.get(2),LoggedOnUserData.get(3),LoggedOnUserData.getLast());
        }
        else
        {
            System.out.println("\t\t==============================  Welcome to Student dashboard  ==============================\n\n");
            studentsMethods(Integer.parseInt(LoggedOnUserData.getFirst()),LoggedOnUserData.get(1),LoggedOnUserData.get(2),LoggedOnUserData.get(3),LoggedOnUserData.getLast());
        }

    }

    static void adminMethods(int id, String name, String email, String password, String role)
    {
        Admin admin = new Admin(id, name, email, password, role);
        System.out.println("[1]Create Exam");
        System.out.println("[2]View Students Results");
        System.out.println("[3]Generate top performers Report");
        System.out.println("[99]Exit Program");
        System.out.println("-----------------------------------------");
        System.out.print("Select your desired option: ");
        String option = reader.nextLine();
        switch (option)
        {
            case "1": admin.createExam();break;
            case "2": admin.viewResults(students);break;
            case "3": admin.generateReport(); break;
            case "99": System.exit(0); break;
            default:
                System.out.println("Invalid option");
                adminMethods(id, name, email, password, role);
        }
       adminMethods(id, name, email, password, role);
    }

    static void studentsMethods(int id, String name, String email, String password, String role) throws IOException {
        Student student = new Student(id, name, email, password, role);

        System.out.println("[1]Take Exam");
        System.out.println("[2]View Results history");
        System.out.println("[99]Exit program");
        System.out.println("-----------------------------------------");
        System.out.print("Select your desired option: ");
        String option = reader.nextLine();
        switch (option)
        {
            case "1": student.takeExam(); break;
            case "2": student.viewResults(); break;
            case "99": System.exit(0); break;
            default:
                System.out.println("Invalid option");
                studentsMethods(id, name, email, password, role);
        }
    }
>>>>>>> Stashed changes
}