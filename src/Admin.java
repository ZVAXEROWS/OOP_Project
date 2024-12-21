import QuestionsPackage.AdminMakeQuestions;

import java.io.IOException;
import java.util.*;
public class Admin extends Person {

    Scanner reader = new Scanner(System.in);
    public Admin(int id, String name, String email, String password, String role)
    {
        super(id, name, email, password, role);
    }


    /**
     * This method makes you choose the student to start preview his result
     * @param students list of students registered in the system
     * @param results holds the stored results for stored students
     * @exception IndexOutOfBoundsException throws error in case you choose enter invalid value or index while choosing student
     */
    public void viewResults(List<Student> students, List<Result> results)
    {
        if(!students.isEmpty())
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
        else
        {
            System.out.println("\nxxxxxxxxxxxxxx No students to view xxxxxxxxxxxxxxx");
        }
    }

    public void editExam()
    {

        Category category = new Category();
        Set<String> categoriesSet = new HashSet<>();

        if(!AdminMakeQuestions.createdExam.isEmpty()) {

            for (AdminMakeQuestions admin : AdminMakeQuestions.createdExam) {
                categoriesSet.add(admin.category);
            }

            System.out.println("\nAvailable categories:\n");
            category.getCategoriesList(categoriesSet);

            int choice = 0;
            try {
                choice = reader.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nxxxxxxxxxxxxx Invalid Option xxxxxxxxxxxxx \n\n");
                editExam();
            }

            int counter = 0;

            System.out.println("\nAvailable exams:\n");

            for (int i = 0; i < AdminMakeQuestions.createdExam.size(); i++) {
                if (AdminMakeQuestions.createdExam.get(i).category.equals(category.getCategory(choice))) {
                    category.availableCategories.get(choice).setExams(AdminMakeQuestions.createdExam.get(i));
                    System.out.println("[" + counter++ + "] " + AdminMakeQuestions.createdExam.get(i).examTitle);
                }
            }

            int ExamChoice = 0;
            try {
                ExamChoice = reader.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("\nxxxxxxxxxxxxx Invalid Option xxxxxxxxxxxxx \n\n");
                editExam();
            }

            boolean exit = false;
            try {
                String complete = null;
                do {
                    var currentExam = category.availableCategories.get(choice).exams.get(ExamChoice);
                    System.out.println("\n\n========= Exam ID: " + currentExam.examID + " ================");
                    System.out.println("[0] Exam Title: " + currentExam.examTitle);
                    System.out.println("[1] Exam category: " + currentExam.category);
                    System.out.println("[2] Exam duration: " + currentExam.duration + "(in minutes)");
                    System.out.println("[3] Exam Questions");
                    System.out.println("[99] Exit Editing");
                    System.out.print("\nSelect an option to Edit: ");
                    int option = reader.nextInt();

                    if (option >= 0 && option <= 3 || option == 99) {
                        switch (option) {
                            case 0:
                                reader.nextLine();
                                System.out.print("\nSet the new Exam Title: ");
                                String title = reader.nextLine();
                                if(!title.isBlank())
                                {
                                    currentExam.examTitle = title;
                                }
                                else {
                                    System.out.println("\nxxxxxxxxxxxxx No Title provided xxxxxxxxxxxxx \n\n");
                                }
                                break;

                            case 1:
                                reader.nextLine();
                                System.out.print("\nSet the new Exam Category: ");
                                String newCategory = reader.nextLine();
                                if(!newCategory.isBlank())
                                {
                                    currentExam.category = newCategory;
                                }
                                else {
                                    System.out.println("\nxxxxxxxxxxxxx No Category provided xxxxxxxxxxxxx \n\n");
                                }

                                break;
                            case 2:
                                reader.nextLine();
                                System.out.print("\nSet the new Exam duration: ");
                                try {
                                    int duration = reader.nextInt();
                                    if (duration > 0) {
                                        currentExam.duration = duration;
                                    } else {
                                        System.out.println("\nxxxxxxxxxxxxx Invalid Duration xxxxxxxxxxxxx \n\n");
                                    }
                                    reader.nextLine();
                                }catch (InputMismatchException e)
                                {
                                    System.out.println("\nxxxxxxxxxxxxx Invalid Duration xxxxxxxxxxxxx \n\n");
                                }
                                break;
                            case 3:
                                int questionsCounter = 0;
                                for(int i = 0; i < currentExam.questions.size(); i++) {
                                    System.out.println("["+questionsCounter+++"] "+currentExam.questions.get(i).theQuestionTitle);
                                }
                                System.out.print("\n\n---------------------------\nChoose question to edit: ");
                                int questionChoice = reader.nextInt();
                                if(questionChoice >= 0 && questionChoice <= currentExam.questions.size()) {
                                    System.out.println("[0] Question Title: " + currentExam.questions.get(questionChoice).theQuestionTitle);
                                    System.out.println("[1] Question Mark: " + currentExam.questions.get(questionChoice).mark);
                                    System.out.println("[2] Question Correct Answer: " + currentExam.questions.get(questionChoice).theCorrectOne);
                                    System.out.println("[3] Question Options ");
                                    System.out.print("\nChoose property to edit: ");
                                    int property = reader.nextInt();
                                    switch (property) {
                                        case 0:
                                            reader.nextLine();
                                            System.out.print("\nSet the new Question Title: ");
                                            String newQuestionTitle = reader.nextLine();
                                            if(!newQuestionTitle.isBlank())
                                            {
                                                currentExam.questions.get(questionChoice).theQuestionTitle = newQuestionTitle;
                                            }
                                            else {
                                                System.out.println("\nxxxxxxxxxxxxx No Title provided xxxxxxxxxxxxx \n\n");
                                            }
                                            break;
                                        case 1:
                                            reader.nextLine();
                                            System.out.print("\nSet the new Question Mark: ");
                                            try {
                                                int mark = reader.nextInt();
                                                if (mark > 0) {
                                                    currentExam.questions.get(questionChoice).mark = mark;
                                                } else {
                                                    System.out.println("\nxxxxxxxxxxxxx Invalid Mark xxxxxxxxxxxxx \n\n");
                                                }
                                                reader.nextLine();
                                            }catch (InputMismatchException e)
                                            {
                                                System.out.println("\nxxxxxxxxxxxxx Invalid Mark xxxxxxxxxxxxx \n\n");
                                            }
                                            break;
                                        case 2:
                                            reader.nextLine();
                                            System.out.print("\nSet the new Question Correct Option between 1 and " + currentExam.questions.get(questionChoice).numOfOptions + ": ");
                                            int input = reader.nextInt();
                                            reader.nextLine();
                                            if (input >= 1 && input <= currentExam.questions.get(questionChoice).numOfOptions) {
                                                try
                                                {
                                                    currentExam.questions.get(questionChoice).theCorrectOne = input;
                                                }
                                                catch (InputMismatchException e)
                                                {
                                                    System.out.println("\nxxxxxxxxxxxxxx Invalid Option xxxxxxxxxxxxxxxx");
                                                }
                                            } else {
                                                System.out.println("\nxxxxxxxxxxxxxx Invalid Option xxxxxxxxxxxxxxxx");
                                                continue;
                                            }
                                            break;
                                        case 3:
                                            for (int j = 0; j < currentExam.questions.get(questionChoice).numOfOptions; j++) {
                                                System.out.println("[" + j + "] " + currentExam.questions.get(questionChoice).questionOptions[j]);
                                            }
                                            System.out.print("\nchoose option to edit: ");
                                            int optionNum = reader.nextInt();
                                            if (optionNum >= 0 && optionNum < currentExam.questions.get(questionChoice).numOfOptions) {
                                                reader.nextLine();
                                                System.out.print("\nSet the new Option Title: ");
                                                String newTitle = reader.nextLine();
                                                if(!newTitle.isBlank())
                                                {
                                                    currentExam.questions.get(questionChoice).questionOptions[optionNum] = newTitle;
                                                }
                                                else {
                                                    System.out.println("\nxxxxxxxxxxxxx No Title provided xxxxxxxxxxxxx \n\n");
                                                }
                                            } else {
                                                System.out.println("\nxxxxxxxxxxxxxx Invalid Option xxxxxxxxxxxxxxxx");
                                                continue;
                                            }
                                            break;
                                        default:
                                            System.out.println("\nxxxxxxxxxxxxxx Invalid Option xxxxxxxxxxxxxxxx");
                                            continue;
                                    }
                                }
                                else
                                {
                                    System.out.println("\nxxxxxxxxxxxxxx Invalid Option xxxxxxxxxxxxxxxx");
                                    continue;
                                }
                                break;
                            case 99:
                                exit = true;
                                break;
                            default:
                                System.out.println("\nxxxxxxxxxxxxxx Invalid Option xxxxxxxxxxxxxxxx");
                                break;
                        }
                    } else {
                        System.out.println("\nxxxxxxxxxxxxxx Invalid Option xxxxxxxxxxxxxxxx");
                        continue;
                    }
                    if(!exit)
                    {
                        System.out.print("\n\n---------------------------------\ndo you want to make another process?(yes/no): ");
                        complete = reader.nextLine().toLowerCase();
                    }
                    else
                    {
                        break;
                    }

                    if(complete.equals("no"))
                    {
                        break;
                    }

                }while(Objects.equals(complete, "yes"));

            } catch (IndexOutOfBoundsException e) {
                System.out.println("\nxxxxxxxxxxxxxx Invalid Option xxxxxxxxxxxxxxxx");
            }

        }
    }

    /**
     * This method allows you to create new exam
     * @throws IOException in case there is any exceptions with file read or write, error will be thrown
     */
    public void createExam() throws IOException {
        Exam exam = new Exam();
        Create_Exam.CreateExam(exam);
    }

    /**
     * This method allows you to generate reports for students.
     * By Either overwriting the PreWritten report, or add content on it.
     * @param students list of students registered in the system
     * @exception IndexOutOfBoundsException throws error in case you choose enter invalid value or index while choosing student
     */
    public void generateReport(List<Student> students)
    {
        int counter = 0;
        System.out.println("available Students:\n");
        for(Student student : students)
        {
            System.out.println("["+ (counter++) + "] "+student.name);
        }
        System.out.print("\nEnter the number of the student to view his results: ");
        int choice = reader.nextInt();
        try {
            if(students.get(choice).report != null || !students.get(choice).report.isEmpty())
            {
                System.out.println("Previous Report: ");
                System.out.println(students.get(choice).report);
            }
            else {
                System.out.println("No previous Report");
            }

            System.out.println("Write Your Report For [" + students.get(choice).name + "]:");
            reader.nextLine();
            String report = reader.nextLine();
            if(!report.isBlank()) {

                int select;
                do {
                    System.out.println("[0] Delete Previous Report and make a New Report from the written one\n[1] Add to Previous Report");
                    select = reader.nextInt();
                    switch (select) {
                        case 0:
                            students.get(choice).report = report;
                            break;
                        case 1:
                            students.get(choice).report += "\n" + report;
                            break;
                        default:
                            System.out.println("\nxxxxxxxxxxxxxx Invalid Option xxxxxxxxxxxxxxxx");
                    }

                } while (select != 0 && select != 1);
            }
            else {
                System.out.println("\nxxxxxxxxxxxxxx Invalid Entry xxxxxxxxxxxxxxxx");
            }

        }catch (IndexOutOfBoundsException e) {
            System.out.println("\nxxxxxxxxxxx Student not found xxxxxxxxxxx");
            generateReport(students);
        }

    }

}

