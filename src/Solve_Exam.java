public class Solve_Exam extends Exam{



    public Solve_Exam(){
// the exam will be started , work in timer


        System.out.println(getTitle());
        for(int i=0;i<getNumOfQuestions();i++)
        {
            System.out.println("Question "+(i+1)+" :"+ListOfQuestions[i].getTheQuestionText());

            for(int j=0;j<ListOfQuestions[i].getNumOfOptions();j++)
            {
                System.out.println((j+1)+" :"+ListOfQuestions[i].getQuestionOptions()[j]);

            }
            System.out.println("Enter Number between 1 and "+ListOfQuestions[i].getNumOfOptions());


            for(int k=0;k<ListOfQuestions[i].getNumOfOptions();k++)
            {


            }





        }





    }



}
