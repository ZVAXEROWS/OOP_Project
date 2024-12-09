import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner reader = new Scanner(System.in);
    static FileHandling usersFileHandler = new FileHandling("users.txt");
    static FileHandling fileHandling = new FileHandling("The_Exam.txt");

    public static void main(String[] args) throws IOException, ClassNotFoundException {

       AdminMakeQuestions.createdExam = fileHandling.readObjectList();

        usersFileHandler.readDataForUsers();

        System.out.println("\t\t==============================  Welcome to Login Page  ==============================\n\n");
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

    static void adminMethods(int id, String name, String email, String password, String role) throws IOException {
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
            case "2": admin.viewResults(FileHandling.students);break;
            case "3": admin.generateReport(); break;
            case "99":
                fileHandling.writeObjectList(AdminMakeQuestions.createdExam);
                usersFileHandler.saveRegisteredUsers(Student.newerCredentials);
                System.exit(0); break;
            default:
                System.out.println("Invalid option");
                adminMethods(id, name, email, password, role);
        }
        System.out.println("\n\n");
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
        System.out.println("\n\n");
        studentsMethods(id, name, email, password, role);
    }
}