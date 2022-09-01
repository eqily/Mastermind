public class Mastermind {
  private int guessesTaken;
  private String code;
  private boolean gameOver;

  public Mastermind(String code){
    this.guessesTaken = 0;
    this.code = code; 
    this.gameOver = false; 
  }

  public static String getDirections() {
    return "Welcome to Mastermind. You are the codebreaker. Your job is to guess the patterm in both letter and order. There are 6 available ltters (A-F) and they will not repeat. You will have 8 guesses. After each guess you will learn the number of letters that are correct and in the right spot as well as the number of letters that are correct but in the wrong spot. Guess by entering 4 letters between A and F with no spaces. May the force be ever in your favor.";
  }// end of getDirections

  public String getTurnDirections() {
    guessesTaken++;
    return "Please make guess number " + guessesTaken + ":  ";
  }// end of getTurnDirections

  public static boolean checkCode(String code) {
    if (code.length() == 4) {
      for (int i = 0; i < code.length(); i++) {
        String letter = code.substring(i, i + 1);
        letter = letter.toLowerCase();
        if (!"abcdef".contains(letter)) {
          return false;//contains a number
        } // end of if
        for (int j = i + 1; j < code.length(); j++) {
          String letter2 = code.substring(j, j + 1);
          letter2 = letter2.toLowerCase();
          if (letter.equals(letter2)){
            return false;//contains repeated letters
          }
        } // end of innter for loop
      } // end of outer for loop
      return true;
    } else {
      return false;//not 4 characters
    }
  }// end of checkCode

  public String check(String code){
    if (code.length() == 4) {
      for (int i = 0; i < code.length(); i++) {
        String letter = code.substring(i, i + 1);
        letter = letter.toLowerCase();
        if (!"abcdef".contains(letter)) {
          return "You must enter letters either a, b, c, d, e, or f. You have wasted a guess.";
        } // end of if
        for (int j = i + 1; j < code.length(); j++) {
          String letter2 = code.substring(j, j + 1);
          letter2 = letter2.toLowerCase();
          if (letter.equals(letter2)){
            return "You cannot repeat letters. You have wasted a guess.";
          }
        } // end of innter for loop
      } // end of outer for loop
    } else {
      return "Nice guess. Try four characters next time.";
    }return results(code);
  }//end of check

  public String results(String guessCode){
    int num1 = 0;
    for(int i = 0; i<code.length(); i++){
      String letter = code.substring(i, i+1);
      letter = letter.toLowerCase();
      if(letter.equals(guessCode.substring(i, i+1))){
        num1++;//correct letter and placement
      }
    }
    int num2 = 0;
    for(int i = 0; i<code.length(); i++){
      String letter = code.substring(i, i+1);
      letter = letter.toLowerCase();
      if(guessCode.contains(letter)){
        num2++;//correct letter
      }
    } //end of for loop   
    num2 = num2 - num1;
    //subtract correct letter and placement from correct letter to avoid overlap
    if(num1 == 4){
      gameOver=true;//the code was guessed
    }
    return "You had " + num1 + " letter(s) in the correct spot and " + num2 + " correct letter(s) in the wrong spot.";  
  }//end of results method

  public String getClosingMessage(){  
    if (guessesTaken <= 7 && gameOver){
      return "Congratulations, you have guessed the correct code in " + guessesTaken + " guesses! You have saved Repl from the Russian hackers!";
      //for the challenge, or to increase guesses just change the inequality to be greater than (# of guessed wanted - 1)
    }else{
      return "Sorry, you are out of attempts. The Russians have taken over in this lifetime. Better luck next time.";
    }
      
  }// end of getClosingMessage

  public boolean getGameOver() {
    if(guessesTaken>7 || gameOver){
      return true;
      //for the challenge, or to increase guesses just change the inequality to be greater than (# of guessed wanted - 1)
    }else{
      return false;
    }
  }// end of getGameOver

}// end of Mastermind class