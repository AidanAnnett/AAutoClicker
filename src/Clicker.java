import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Clicker {
	private Robot Bot;
	private double delayClick;
	private double numClicks;
	private double timedClicks;
	private boolean infinite;
	
		public Clicker() {
			try {
				Bot = new Robot();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public void setDelay(double delay) {
			delayClick = delay;
		}
		public Integer getDelay() {
			return (int)delayClick;
		}
		
		public void setNumClicks(double numClick) {
			numClicks = numClick;
		}
		public Integer getNumClicks() {
			return (int)numClicks;
		}
		
		public void setTimedClicks(double timedClick) {
			timedClicks = timedClick;
		}
		public Integer getTimedClicks() {
			return (int)timedClicks;
		}
		public void setInfinite(boolean inf) {
			infinite = inf;
		}
		
		public Boolean getInfinite() {
			return infinite;
		}
		public void mouse(int button, int x, int y) {
			try {
				Bot.mouseMove(x, y);
				Bot.mousePress(button);
				Bot.mouseRelease(button);
				Bot.delay(getTimedClicks());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public void stop() {
			System.exit(1);
		}
}