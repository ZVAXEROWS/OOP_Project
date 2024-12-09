import java.util.*;
import java.io.*;

public class Questions implements Serializable{

    // Attributes
    protected static int questionID = 0 ;
    protected int mark;
    protected String theQuestionTitle;
    protected int numOfOptions;
    protected String [] questionOptions;
    protected int theCorrectOne;

    transient Scanner input = new Scanner(System.in);

    public Questions(int mark, String theQuestionTitle, int numOfOptions, String [] questionOptions, int theCorrectOne){
        this.mark = mark;
        this.theQuestionTitle = theQuestionTitle;
        this.numOfOptions = numOfOptions;
        this.questionOptions = questionOptions;
        this.theCorrectOne = theCorrectOne;

    }

    //Getters
    public int getMark() {
        return mark;
    }

    public String getTheQuestionTitle() {
        return theQuestionTitle;
    }

    public int getNumOfOptions() {
        return numOfOptions;
    }

    public String[] getQuestionOptions() {
        return questionOptions;
    }

    public int getTheCorrectOne() {
        return theCorrectOne;
    }



    //limits methods
    //main lim method with limits parameters
    public int limits (int firstlim, int lastlim){

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

    //overloaded limits method without parameters
    public int limits (){

        int theInputnum = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Please enter an integer between greater than 0 \n");
            if (input.hasNextInt()) { // Check if input is an integer

                theInputnum = input.nextInt();

                if (theInputnum > 0) {
                    isValid = true; // Valid input within the range
                } else {
                    System.out.println("The number must be greater than 0. Try again!");
                }

            } else {
                System.out.println("That's not a valid integer. Try again!");
                input.next(); // Consume invalid input
            }
        }
        return theInputnum;
    }

}