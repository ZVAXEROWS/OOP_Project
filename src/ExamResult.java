import QuestionsPackage.AdminMakeQuestions;

import java.io.Serializable;

public class ExamResult implements Serializable {


    private int examID;
    private String examName;

    private static int examMark;
    private static int result;

    private int score;
    private String grade;
    private String status;
    private boolean passStatus = true;

    public ExamResult(int examIndex, int examMark, int result) {

        setExamID(examIndex);
        setExamName(examIndex);
        this.examMark = examMark;
        this.result = result;

        calculateGrade();
    }



    public String getExamName() {
        return examName;
    }

    public int getScore() {
        return score;
    }

    public String getGrade() {
        return grade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setExamName(int index) {
        examName = AdminMakeQuestions.createdExam.get(index).examTitle;
    }

    public void setExamID(int index) {

        examID = AdminMakeQuestions.createdExam.get(index).examID;  // this is wrong
    }

    public void calculateGrade() {

        score = (int) (((double) result / examMark) * 100);

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

        status = passStatus ? "Pass" : "Fail";
    }

}
