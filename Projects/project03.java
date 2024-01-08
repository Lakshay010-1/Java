package Projects;
import java.util.*;
// guess the number game with computer
public class project03{
    public static void main(String[] args) {
        guessTheNum a=new guessTheNum();
        a.ComputerInput();
        a.UserInput();
        a.isCorrectNum();
 }
}
class guessTheNum{ 
    int userInput,computerInput;
    private int noOfGuesses;

    public void setNoOfGuesses(){
        noOfGuesses++;
    }
    public void getNoOfGuesses(){
        System.out.println("You took "+noOfGuesses+" guesses.");
    }
    public void ComputerInput(){
        Random rd=new Random();
        computerInput= rd.nextInt(100);
        System.out.println("computer had chosen its number ");
        //return computerInput;
    }
    public void UserInput(){
        System.out.println("enter your name between 1 to 100");
        Scanner sc=new Scanner(System.in);
        userInput=sc.nextInt(100);
        //return userInput;

    }
    public void isCorrectNum(){
        if(userInput==computerInput){
            setNoOfGuesses();
            System.out.println("you guessed the number right "+userInput);
            getNoOfGuesses();
        }
        else if(userInput>computerInput){
            setNoOfGuesses();
            System.out.println("Choose a smaller number than "+userInput);
            System.out.println();
            UserInput();
            isCorrectNum();
        }
    else{ setNoOfGuesses();
            System.out.println("Choose a larger number  than "+userInput);
            System.out.println();
            UserInput();
            isCorrectNum();
        }}
}



