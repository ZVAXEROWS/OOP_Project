public class AdminMakeQuestions extends Questions{

    @Override
    public int getTheCorrectOne() {
        return super.getTheCorrectOne();
    }
//last

    public AdminMakeQuestions() {
        questionID++;

        //Quistion Title
        System.out.println("Enter the question title:");
        theQuestionTitle = input.nextLine();

        //Question Assets
        System.out.println("Enter 1 to Add Image, 2 For Audio, 3 for both, 4 for skip");

        int caseChoose = limlits(1,4);
        switch (caseChoose){
            case 1 : setImagePath();
            break;
            case 2 : setAudioPath();
            break;
            case 3 : setImagePath();
                     setAudioPath();
            break;
            case 4 : break;
        }

        //Quistion Mark
        System.out.println("Enter the mark for the question:");
        mark = input.nextInt();


        //Num Of Options
        System.out.println("Enter the number of options");
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
