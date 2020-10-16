

import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class StopClickerActionListener implements EventHandler<ActionEvent> {

	private Clicker clickers;


	StopClickerActionListener(Clicker clicker) {
		this.clickers = clicker;
		
	}
	@Override
	public void handle(ActionEvent e) {
			clickers.stop();
				}
			
}

