import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileHandling fileHandling = new FileHandling("The_Exam.txt");


        Exam exam = new Exam();
        Create_Exam.CreateExam(exam);


        Solve_Exam.theQuistons=fileHandling.readObject();
        Solve_Exam.SolveExam();

    }
}

