import java.util.Scanner;
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
		HangmanModel hangman;
		char letter;
		
		// PROGRAM CODE
		hangman = new HangmanModel( new BasicSetup() );
		hangman.addView( new ConsoleHangmanView());
		hangman.addView( new ConsoleHangmanView());
		do {
			
			System.out.print( "Try this: " );
			letter = scan.next().charAt(0);
			hangman.tryThis( letter );
			
		} while ( !hangman.isGameOver() );


		System.out.println( "\nEnd of ConsoleHangman\n" );
		scan.close();
	}

} // end of class ConsoleHangman
