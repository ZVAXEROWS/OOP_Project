public class AdminMakeQuestions extends Questions{

    @Override
    public int getTheCorrectOne() {
        return super.getTheCorrectOne();
    }

    public AdminMakeQuestions() {
        questionID++;

        //Quistion Title
        System.out.println("Enter the question title:");
        theQuestionTitle = input.nextLine();

        //Quistion Mark
        System.out.println("Enter the mark for the question:");
        mark = input.nextInt();


        //Num Of Options
        System.out.println("Enter the number of options (between 2 and 6):");
        numOfOptions=limlits(2,6);

        //Options
        quistionOptions = new String[numOfOptions];

        input.nextLine();
        for (int i =0; i < numOfOptions ; i++){
            System.out.println("Enter option " + (i + 1) + ":");
            quistionOptions[i] = input.nextLine();
        }

        //Correct Choice
        System.out.println("Enter the number of the correct choice:");
        theCorrectOne = limlits(1,numOfOptions);

    }
}
