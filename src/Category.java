import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class ExamCategory {
    final String categoryName;
    protected List<AdminMakeQuestions> exams;

    public ExamCategory(String name) {
        this.categoryName = name;
        this.exams = new ArrayList<>();
    }
    public void setExams(AdminMakeQuestions exam) {
        exams.add(exam);
    }

}

public class Category {

    protected List<ExamCategory> availableCategories = new ArrayList<>();

    public void addCategory(ExamCategory subject) {
        availableCategories.add(subject);
    }

    public String getCategory(int choice) {
        try
        {
            return availableCategories.get(choice).categoryName;

        }catch (IndexOutOfBoundsException e)
        {
            System.out.println("\nxxxxxxxxxxxxxx Invalid Option xxxxxxxxxxxxxxxx");
            return null;
        }

    }
    public void getCategoriesList(Set<String> categories) {
        int counter = 0;
        for(String exam : categories) {
            addCategory(new ExamCategory(exam));
            System.out.println("[" + counter++ + "] " +exam);
        }
    }

}


