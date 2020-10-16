
import java.awt.MouseInfo;
import java.awt.event.InputEvent;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.control.Slider;

public class StartClickerActionListener implements EventHandler<ActionEvent> {

	private Clicker clickers;


	StartClickerActionListener(Clicker clicker) {
		this.clickers = clicker;
		
	}
	@Override
	public void handle(ActionEvent e) {
			try {
				Thread.sleep(1000*clickers.getDelay());
			} catch (Exception f) {
				f.printStackTrace();
			}
			
			if(clickers.getInfinite()) {
				while (true) {
				clickers.mouse(InputEvent.BUTTON1_MASK, MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y);
				}
			} else {
				for (int i = 0; i < clickers.getNumClicks(); i++) {	
					clickers.mouse(InputEvent.BUTTON1_MASK, MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y);
					}
			}
				}
			
}

