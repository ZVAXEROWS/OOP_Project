import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Exam exam = new Exam();
        Create_Exam x = new Create_Exam(exam);
        Solve_Exam s = new Solve_Exam(exam.getTheQuistons());


    }
}