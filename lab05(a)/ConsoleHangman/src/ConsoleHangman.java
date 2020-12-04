import java.util.Scanner;
import cs102.*;

/**
 * ConsoleHangman
 *
 * @author Onur Ertunc
 * @version 1.00 2013/4/7 
 * @
 */

public class ConsoleHangman
{
    public static void main( String[] args)
	{
    	Scanner scan = new Scanner( System.in);

    	System.out.println( "Start of ConsoleHangman\n");

		// VARIABLES
		Hangman		hangman;
		char letter;
		char newGame;

		
		// PROGRAM CODE
		hangman = new Hangman( new BasicSetup() );

		System.out.println( hangman.getKnownSoFar() );
		System.out.println( "Letter box: " + hangman.getAllLetters() );
		newGame = 'n';

		
		do {
			System.out.println( "Remaining tries: " + ( hangman.getMaxAllowedIncorrectTries() - hangman.getNumOfIncorrectTries() ) );
			System.out.print( "Try this: " );
			letter = scan.next().charAt(0);
			hangman.tryThis( letter );
			System.out.println( hangman.getKnownSoFar() );
			System.out.println( "Used letters: " + hangman.getUsedLetters() );
			
			if ( hangman.isGameOver() && hangman.hasLost() ) {
				System.out.println( "You lost." );
				System.out.println( "New game? Enter Y. If not, press N" );
				newGame = scan.next().charAt(0);
				if ( ( newGame == 'y' || newGame == 'Y' ) ) {
					hangman.initNewGame();
				}
				
			}
			else if ( hangman.isGameOver() && !hangman.hasLost() ) {
				System.out.println( "You won!!!" );
				System.out.println( "New game? Enter Y. If not, press N" );
				newGame = scan.next().charAt(0);
				if ( ( newGame == 'Y' || newGame == 'y' ) ) {
					hangman.initNewGame();
				}
			}
		} while ( !hangman.isGameOver() && ( newGame != 'n' || newGame != 'N' ) );


		System.out.println( "\nEnd of ConsoleHangman\n" );
		scan.close();
	}

} // end of class ConsoleHangman
