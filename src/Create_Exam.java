import QuestionsPackage.*;

import java.io.IOException;
import java.util.Scanner;

public class Create_Exam extends Exam {


    static Questions helper = new GenericQuestion(0, null, 0, null, 0);

    public static void CreateExam(Exam exam) throws IOException {
        AdminMakeQuestions adminQuestions;
        ++examID;
        Scanner input = new Scanner(System.in);

        //Exam Title
        System.out.println("\n\n=================================================");
        System.out.print("Set Exam " + exam.getID() + "  Title: \t");
        String title;
        do{title = input.nextLine();}while (title.isBlank());

        //Exam Category
        System.out.print("\nSet Exam " + exam.getID() + "  Category: \t");
        String Category;
        do{Category = input.nextLine();}while (Category.isBlank());
        exam.setCategory(Category);


        //Exam Duration
        System.out.print("\nSet Exam " + exam.getID() + " _ Duration In Minutes\t");
        int duration = helper.limits();
        exam.setDuration(duration);

        adminQuestions = new AdminMakeQuestions(title, duration, examID, Category);

        boolean firstQ = true;
        while (true) {
            if (firstQ == false) {

                System.out.print("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\ndo You want to continue - (done or no to end): ");
                String isDone = input.nextLine().toLowerCase();

                if (isDone.equals("done") || isDone.equals("no")) {
                    AdminMakeQuestions.createdExam.add(adminQuestions);
                    break;
                }
            }

            adminQuestions.newQuestion();
            adminQuestions.questions.add(new GenericQuestion(adminQuestions.mark, adminQuestions.theQuestionTitle, adminQuestions.numOfOptions, adminQuestions.questionOptions, adminQuestions.theCorrectOne));
            firstQ = false;
        }

    }
}