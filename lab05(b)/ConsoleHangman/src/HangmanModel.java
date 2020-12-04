import cs102.Hangman;
import cs102.IHangmanSetup;
/**
 * 
 * @author Onur Ertunc
 * @version 3.12.2020
 */
public class HangmanModel extends Hangman {
	
	private IHangmanView view;
	
	public HangmanModel( IHangmanSetup setup ) {
		
		super(setup);
	}
	
	
	public void update() {
		
		if ( view != null ) {
			view.updateView(this);
		}
	}
	
	public void addView( IHangmanView view ) {
		
		this.view = view;
		update();
	}
	
	public int tryThis( char letter ) {
		
		int overriden = super.tryThis( letter );
		update();
		return overriden;		
	}
	
	public void initNewGame() {
		
		super.initNewGame();
		update();
	}
}
