public class Create_Exam extends Exam{

    public Create_Exam(Exam exam){
        ++examID;

        //Exam Title
        System.out.println("Set Exam "+getID()+" _ Title");
        String title =input.nextLine();
        setTitle(title);


        //Exam Category
        System.out.println("Set Exam "+getID()+" _ Category");
        String Category = input.nextLine();
        setCategory(Category);


        //Exam Duration
        System.out.println("Set Exam "+getID()+" _ Duration In Minutes");
        int duration = input.nextInt();
        setDuration(duration);
        input.nextLine();


        boolean firstQ = true;
        while (true) {
            if (firstQ == false) {

                System.out.println("do You want to continue - done or no to end");
                String isDone = input.nextLine().toLowerCase();

                if (isDone.equals("done") || isDone.equals("no")) {
                    break;
                }
            }

            AdminMakeQuestions newQuestion = new AdminMakeQuestions();
            exam.getTheQuistons().add(newQuestion);
            firstQ = false;
        }



    }

}
