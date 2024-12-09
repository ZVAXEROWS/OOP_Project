import java.util.Scanner;

public class Question {
    private static int ID = 0;
    private int Mark;
    private String TheQuestionText;
    private int NumOfOptions;
    private String[] QuestionOptions;
    private int TheCorrectOne;
    Scanner input = new Scanner(System.in);


    //Getters

    public static int getID() {
        return ID;
    }

    public int getMark() {
        return Mark;
    }

    public String getTheQuestionText() {
        return TheQuestionText;
    }

    public int getNumOfOptions() {
        return NumOfOptions;
    }

    public String[] getQuestionOptions() {
        return QuestionOptions;
    }

    public int getTheCorrectOne() {
        return TheCorrectOne;
    }


    public void setMark(int mark) {
        Mark = mark;
    }

    public void setTheQuestionText(String theQuestionText) {
        TheQuestionText = theQuestionText;
    }

    public void setNumOfOptions(int numOfOptions) {
        NumOfOptions = numOfOptions;
    }


    public void setQuestionOptions(int numofoptions) {
        QuestionOptions = new String[numofoptions];
        input.nextLine();
        for (int i =0; i < numofoptions ; i++){
            QuestionOptions[i]=new String();
            System.out.println("Enter option " + (i + 1) + ":");
            QuestionOptions[i] = input.nextLine();
        }
    }

    public void setTheCorrectOne(int theCorrectOne) {
        TheCorrectOne = theCorrectOne;
    }

    //limits
    public int limlits(int firstlim, int lastlim) {

        int theInputnum = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Please enter an integer between " + firstlim + " and " + lastlim + "\n");
            if (input.hasNextInt()) { // Check if input is an integer

                theInputnum = input.nextInt();

                if (theInputnum >= firstlim && theInputnum <= lastlim) {
                    isValid = true; // Valid input within the range
                } else {
                    System.out.println("The number is out of range. Try again!");
                }

            } else {
                System.out.println("That's not a valid integer. Try again!");
                input.next(); // Consume invalid input
            }
        }

        return theInputnum;
    }



    public Question() {
        ++ID;

        //Question Mark
        System.out.println("Set Question "+getID()+" _ Mark");
        int mark = input.nextInt();
         setMark(mark);


        //Question Text
        System.out.println("Set Question "+getID()+" _ Text");
         input.nextLine();
        String text =input.nextLine();
        setTheQuestionText(text);


        //Num Of Options
        System.out.println("Enter the number of options");
        setNumOfOptions(limlits(2,6));


        //Options
        setQuestionOptions(getNumOfOptions());


        //Correct Choice
        System.out.println("Enter the number of the correct choice:");
        setTheCorrectOne( limlits(1,NumOfOptions));

    }


}

