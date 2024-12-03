import java.io.Serializable;


/**
 * Calculate the results of students
 */
public class Result implements Serializable {

    // momo

    private String studentID;
    private String examID;
    private int score;
    private String grade;
    private boolean passStatus = true;
    private String status = "fail";
    public Result() {

    }

    /**
     *
     * @param studentID The id of the student
     * @param examID The exam ID
     * @param score The student score in the exam
     */
    public Result(String studentID, String examID, int score) {
        this.studentID = studentID;
        this.examID = examID;
        this.score = score;
        calculateGrade();
    }

    // getter and setter for all private fields
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getExamID() {
        return examID;
    }

    public void setExamID(String examID) {
        this.examID = examID;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }


    /**
     * Calculate grade of student based on score
     */
    public void calculateGrade() {
        if (score >= 90) {
            grade = "A";
        } else if (score >= 80) {
            grade = "B";
        } else if (score >= 70) {
            grade = "C";
        } else if (score >= 60) {
            grade = "D";
        } else {
            grade = "F";
            passStatus = false;
        }
    }

    /**
     * Display the student results
     */
    public void displayStudentResults() {
// still need student name & exam name

        if(passStatus) {
            status = "pass";
        }

        System.out.println( "Results\n" +
                "{studentId= " + studentID +
                ", examId= " + examID +
                ", score= " + score +
                ", grade= " + grade +
                ", Status= " + status +
                '}');
    }

}
