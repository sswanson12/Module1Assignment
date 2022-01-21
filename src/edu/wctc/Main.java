package edu.wctc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean restartProgram = true;
        int points = 0;
        //Array 1
        String questions[] = new String[]{
                "(0)-Mild (1)-Spicy",
                "(0)-Tea (1)-Coffee",
                "(0)-Breakfast (1)-Brunch",
                "(0)-Summer (1)-Winter",
                "(0)-Paper (1)-Plastic"
        };

        while (restartProgram) {
            System.out.println("You're about to take this little lifestyle quiz!\n" +
                    "Please answer either (0) or (1), and this handy dandy program will keep\n" +
                    "track of your answers and guess how you life your life!");

            for (int i = 0; i < 5; i++){
                //I absolutely love how nicely this loop for the questions turned out. This really made me understand
                //that arrays can be handy in some cases.
                System.out.println(questions[i]);
                if (InputCollector() == 1) {
                    /*
                    This if statement will add points to the score for each answer responded with one.
                    An else statement isn't necessary because I don't need to do anything with the score if the user
                    replies with 0
                    */
                    points++;
                }
            }
            System.out.println(returnStatement(points));

            //I included this in order to incorporate the rubric required boolean!
            System.out.println("\nWould you like to take this again? (0)-No (1)-Yes");
            if (InputCollector() == 0){
                restartProgram = false;
            } else {
                restartProgram = true;
            }
        }
    }

    /*
    I decided to make both of these local methods static, because then I could use them more efficiently for
    the purposes of this assignment. I wasn't entirely sure that it would work, but I tried it out, and it did,
    so I stuck with it.
     */
    public static int InputCollector(){
        Scanner userInput = new Scanner(System.in);
        int input = userInput.nextInt();
        while (input != 0 && input != 1){
            System.out.println("That answer will break my program, please try to be nicer and only enter either '0' or '1'.");
            input = userInput.nextInt();
        }
        return input;
    }

    public static String returnStatement(int score){
        //Array 2
        String responses[] = new String[]{
                "You prefer life to be calm and organized.",
                "You prefer a good balance in life.",
                "You prefer life to be spontaneous and active."
        };

        switch(score) {
            case 0, 1, 2:
                return responses[0];
            case 3:
                return responses[1];
            case 4, 5:
                return responses[2];
            default:
                return "Something went wrong...";
        }
    }
}
