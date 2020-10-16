import javafx.scene.control.Slider;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Label;



public class MainClicker extends Application {
	public Clicker click;
	@Override
	public void start(Stage primaryStage) throws Exception {

		menuSetup(primaryStage);
	}
	
	private void menuSetup(Stage stage) {
		Clicker click = new Clicker();
		GridPane grid = new GridPane();
		grid.setHgap(4);
		grid.setVgap(4);
		String styleSet = new String("-fx-background-color: #716a69	;" + "-fx-background-radius: 1;" + "-fx-padding: 15;" + "-fx-border-style: solid inside;" + "-fx-border-width: 0.5;" + "-fx-border-radius: 5;" + "-fx-border-color: lightgrey;");
		
		//Menu for time between clicks
		HBox totalClicks = new HBox();
		Label totalClick = new Label("Total Number of Clicks");
		totalClick.setStyle("-fx-text-fill: black;");
		Slider total = new Slider(0, 100, 0);
		total.valueProperty().addListener((observable, oldValue, newValue) -> {
            click.setNumClicks(total.getValue());
        });
		total.setStyle("-fx-control-inner-background: #404040;" + "-fx-control-outer-background: #404040;");
		
		
		Text totallClicks = new Text(Integer.toString((int)total.getValue()));
		totallClicks.setStyle("-fx-text-fill: black;");
		totallClicks.textProperty().bind(total.valueProperty().asString("%.0f"));
		Text clicksText = new Text("Clicks");
		ToggleButton infBtn = new ToggleButton();
		infBtn.setText("Infinite");		
		infBtn.setOnAction((event) -> {
				if (infBtn.isSelected()) {
					click.setInfinite(true);
					total.setDisable(true);
					totallClicks.setVisible(false);
					clicksText.setVisible(false);
				} else {
					click.setInfinite(false);
					total.setDisable(false);
					totallClicks.setVisible(true);
					clicksText.setVisible(true);
				}
			});
		
		totalClicks.getChildren().addAll(totalClick, total,totallClicks, clicksText, infBtn);
		totalClicks.setSpacing(5);
		totalClicks.setStyle(styleSet);
		
		
		//Menu for time between clicks Setup
		HBox timedClicks = new HBox();
		Label delayClick = new Label("Time Between Clicks  ");
		delayClick.setStyle("-fx-text-fill: black;");
		Slider delayTot = new Slider(1, 1000, 0);
		delayTot.valueProperty().addListener((observable, oldValue, newValue) -> {
            click.setTimedClicks(delayTot.getValue());
        });
		delayTot.setStyle("-fx-control-inner-background: #404040;" + "-fx-control-outer-background: #404040;");
		Text totallTime = new Text(Integer.toString((int)total.getValue()));
		
		totallTime.textProperty().bind(delayTot.valueProperty().asString("%.0f"));
		
		timedClicks.getChildren().addAll(delayClick, delayTot, totallTime, new Text("ms"));
		timedClicks.setSpacing(1);
		timedClicks.setStyle(styleSet);
		
		//Menu for Delay Setup
		HBox timedDelay = new HBox();
		Label delayText = new Label("Delay before Clicking  ");
		delayText.setStyle("-fx-text-fill: black;");
		Slider delayCurr = new Slider(0, 15, 0);
		delayCurr.valueProperty().addListener((observable, oldValue, newValue) -> {
            click.setDelay(delayCurr.getValue());
        });
		delayCurr.setStyle("-fx-control-inner-background: #404040;" + "-fx-control-outer-background: #404040;");
		
		Text delayTime = new Text(Integer.toString((int)total.getValue()));
		delayTime.textProperty().bind(delayCurr.valueProperty().asString("%.0f"));
		timedDelay.getChildren().addAll(delayText, delayCurr, delayTime, new Text("Seconds"));
		timedDelay.setSpacing(1);
		timedDelay.setStyle(styleSet);
		
		//Button Hbox Setup
		HBox buttonLayout = new HBox();
		Button startBut, stopBut;
		startBut = new Button("Start");
		startBut.setPrefSize(70, 57);
		stopBut = new Button("Stop");
		stopBut.setPrefSize(70,57);
		buttonLayout.getChildren().addAll(startBut,stopBut);
		
		grid.add(timedClicks, 1, 3);
		grid.add(totalClicks, 1, 2);
		grid.add(timedDelay, 1, 4);
		grid.add(buttonLayout,  1, 5);
		grid.setStyle("-fx-background-color: #404040;");
		

		
		
		StartClickerActionListener startt = new StartClickerActionListener(click);
		StopClickerActionListener stopp = new StopClickerActionListener(click);
		startBut.addEventHandler(ActionEvent.ACTION, startt);
		stopBut.addEventHandler(ActionEvent.ACTION, stopp);
		Scene scene = new Scene(grid, 450, 235);
		stage.setTitle("Aidan's AutoClicker");
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
		stage.setOnCloseRequest(e-> {
			Platform.exit();
			System.exit(0);
		});
		
	}
	public static void main(String[] args) {
		launch(args);
	}

	

}