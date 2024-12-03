import java.util.*;

public class Questions {

    // Attributes
    protected static int questionID =0 ;
    protected int mark;
    protected String theQuestionTitle;
    protected int numOfOptions;
    protected String [] quistionOptions;
    protected int theCorrectOne;
    Scanner input = new Scanner(System.in);

    //Getters
    public static int getID() {
        return questionID;
    }

    public int getMark() {
        return mark;
    }

    public String getTheQuestionTitle() {
        return theQuestionTitle;
    }

    public int getNumOfOptions() {
        return numOfOptions;
    }

    public String[] getQuistionOptions() {
        return quistionOptions;
    }

    public int getTheCorrectOne() {
        return theCorrectOne;
    }


    //limits
    int limlits (int firstlim, int lastlim){

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

}
