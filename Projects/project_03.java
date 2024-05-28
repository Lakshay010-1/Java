import java.util.*;

// guess the number with computer game
class GuessTheNum{ 
    int playerInput,comInput;
    private int noOfGuesses;

    public void setNoOfGuesses(){
        noOfGuesses++;
    }
    public int getNoOfGuesses(){
        return noOfGuesses;
    }
    
    public void ComputerInput(){
        Random rd=new Random();
        comInput= 1+rd.nextInt(100);
        System.out.println("computer has chosen its number. ");
        //return computerInput;
    }
    public void UserInput(){
        System.out.println("enter your guess number between 1 to 100 : ");
        Scanner sc=new Scanner(System.in);
        playerInput=sc.nextInt();
        //return userInput;

    }
    public void isCorrectNum(){
        while (true) { // Loop until the correct number is guessed
            UserInput();
            setNoOfGuesses();
            if (playerInput == comInput) {
                System.out.println("You guessed the number right: " + playerInput);
                System.out.println("You took " + getNoOfGuesses() + " guesses.");
                break;
            } else if (playerInput > comInput) {
                System.out.println("Choose a smaller number than " + playerInput);
            } else {
                System.out.println("Choose a larger number than " + playerInput);
            }
        }
    }
}

public class project_03{
    public static void main(String[] args) {
        GuessTheNum game=new GuessTheNum();
        game.ComputerInput();
        game.isCorrectNum(); 
 }
}
