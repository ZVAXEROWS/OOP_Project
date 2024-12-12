import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner reader = new Scanner(System.in);
    static FileHandling usersFileHandler = new FileHandling("users.txt");
    static FileHandling fileHandling = new FileHandling("The_Exam.txt");
    static List<String> LoggedOnUserData = new ArrayList<>();
    static FileHandling <Result> studentResultHandler;
    static FileHandling <Result> adminExamResultHandler;
    public static void main(String[] args) throws IOException, ClassNotFoundException {

       AdminMakeQuestions.createdExam = fileHandling.readObjectList();

        usersFileHandler.readDataForUsers();

        System.out.println("\t\t==============================  Welcome to Login Page  ==============================\n\n");
        loginOrRegister();
        if(LoggedOnUserData.getLast().equals("admin"))
        {
            System.out.println("\t\t==============================  Welcome to Admin dashboard  ==============================\n\n");
            for(int i = 0; i < FileHandling.students.size(); i++)
            {
                adminExamResultHandler = new FileHandling("users\\"+FileHandling.students.get(i).ID+".txt");
                if(adminExamResultHandler.file.exists() && adminExamResultHandler.file.length() != 0)
                {
                    FileHandling.studentsResultsForAdmin.add(adminExamResultHandler.readObject());
                }
                else if(!adminExamResultHandler.file.exists() || adminExamResultHandler.file.length() == 0)
                {
                    FileHandling.studentsResultsForAdmin.add(new Result(String.valueOf(FileHandling.students.get(i).ID), FileHandling.students.get(i).name));
                }
            }

            adminMethods(Integer.parseInt(LoggedOnUserData.getFirst()),LoggedOnUserData.get(1),LoggedOnUserData.get(2),LoggedOnUserData.get(3),LoggedOnUserData.getLast(), FileHandling.studentsResultsForAdmin);
        }
        else
        {
            System.out.println("\t\t==============================  Welcome to Student dashboard  ==============================\n\n");
            studentResultHandler = new FileHandling("users\\"+LoggedOnUserData.getFirst()+".txt");
            Result result;
            if((result = studentResultHandler.readObject()) == null)
            {
                result = new Result(LoggedOnUserData.getFirst(), LoggedOnUserData.get(1));
            }

            studentsMethods(Integer.parseInt(LoggedOnUserData.getFirst()),LoggedOnUserData.get(1),LoggedOnUserData.get(2),LoggedOnUserData.get(3),LoggedOnUserData.getLast(), result);
        }

    }

    static public void loginOrRegister() throws IOException, ClassNotFoundException {
        System.out.println("[1] Login\n[2]Register");
        String choice = reader.nextLine();
        switch (choice)
        {
            case "1": LoggedOnUserData = Person.Login(FileHandling.people); break;
            case "2":
                Student.register(FileHandling.people.size());
                FileHandling.people.add(Student.newerCredentials.getLast());
                LoggedOnUserData.add(String.valueOf(Student.newerCredentials.getLast().ID));
                LoggedOnUserData.add(Student.newerCredentials.getLast().name);
                LoggedOnUserData.add(Student.newerCredentials.getLast().Email);
                LoggedOnUserData.add(Student.newerCredentials.getLast().getPassword());
                LoggedOnUserData.add(Student.newerCredentials.getLast().role);
                studentResultHandler = new FileHandling("users\\"+LoggedOnUserData.getFirst()+".txt");
                Result result;
                if((result = studentResultHandler.readObject()) == null)
                {
                    result = new Result(LoggedOnUserData.getFirst(), LoggedOnUserData.get(1));
                }
                System.out.println("\n\n");
                studentsMethods(Integer.parseInt(LoggedOnUserData.getFirst()),LoggedOnUserData.get(1),LoggedOnUserData.get(2),LoggedOnUserData.get(3),LoggedOnUserData.getLast(), result);
                break;
            default:
                System.out.println("\t\txxxxxxxxxxxx Invalid option  xxxxxxxxxxxx\n\n");
                loginOrRegister();
        }
    }

    static void adminMethods(int id, String name, String email, String password, String role, List<Result> results) throws IOException {
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
            case "2": admin.viewResults(FileHandling.students, results);break;
            case "3": admin.generateReport(); break;
            case "99":
                fileHandling.writeObjectList(AdminMakeQuestions.createdExam);
                System.exit(0); break;
            default:
                System.out.println("\t\txxxxxxxxxxxx Invalid option  xxxxxxxxxxxx\n\n");
                adminMethods(id, name, email, password, role, results);
        }
        System.out.println("\n\n");
        adminMethods(id, name, email, password, role, results);
    }

    static void studentsMethods(int id, String name, String email, String password, String role, Result result) throws IOException {
        Student student = new Student(id, name, email, password, role);

        System.out.println("[1]Take Exam");
        System.out.println("[2]View Results history");
        System.out.println("[99]Exit program");
        System.out.println("-----------------------------------------");
        System.out.print("Select your desired option: ");
        String option = reader.nextLine();
        switch (option)
        {
            case "1": student.takeExam(LoggedOnUserData, result); break;
            case "2": student.viewResults(result); break;
            case "99":
                usersFileHandler.saveRegisteredUsers(Student.newerCredentials);
                studentResultHandler.writeObject(result);
                System.exit(0);
                break;
            default:
                System.out.println("\t\txxxxxxxxxxxx Invalid option  xxxxxxxxxxxx\n\n");
                studentsMethods(id, name, email, password, role, result);
        }
        System.out.println("\n\n");
        studentsMethods(id, name, email, password, role, result);
    }
}