import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Calculate the results of students.
 */
public class Result implements Serializable {

    private final String studentName;
    private final String studentID;
    public List<ExamResult> examResults = new ArrayList<>();


    /**
     * @param studentID   The id of the student.
     * @param studentName The name of the student.
     */
    public Result(String studentID, String studentName) {

        this.studentID = studentID;
        this.studentName = studentName;

    }


    /**
     * To add an exam result.
     * @param examIndex The index of the exam to access some data of it.
     * @param examMark The total mark of the exam.
     * @param result The mark of the student in the exam.
     */
    public void addExamResult(int examIndex, int examMark, int result) {

        ExamResult examResult = new ExamResult(examIndex, examMark, result);

        this.examResults.add(examResult);

    }


    /**
     * Display the student results.
     */
    public void displayStudentResults() {


        System.out.println("Student Results");
        System.out.println("=======================================");
        System.out.println("Student Name: " + studentName);
        System.out.println("Student ID: " + studentID);
        System.out.println("---------------------------------------");

        if (examResults.isEmpty()) {
            System.out.println("|| No Exam Results!! ||");

        } else {
            for (ExamResult result : examResults) {

                System.out.println("Exam Name: " + result.getExamName());
                System.out.println("Score: " + result.getScore() + "%");
                System.out.println("Grade: " + result.getGrade());
                System.out.println("Status: " + result.getStatus());
                System.out.println("---------------------------------------");
            }
        }
        System.out.println("=======================================");
    }

}
