package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertBoxes {
	public void ErrorAlert() {
		Alert errorAlert = new Alert(AlertType.ERROR);
		errorAlert.setTitle("An Error Occured!");
    	errorAlert.setHeaderText(null);
    	errorAlert.setContentText("Oops! An error occured. Sorry for your inconvinence.");
    	errorAlert.showAndWait();
	}
	
	public void EmptyIDPassAlert() {
		Alert emptyIDPassAlert = new Alert(AlertType.ERROR);
    	emptyIDPassAlert.setTitle("Login Error!");
    	emptyIDPassAlert.setHeaderText(null);
    	emptyIDPassAlert.setContentText("Empty Text Fields! Kindly fill them.");
    	emptyIDPassAlert.showAndWait();
	}
	
	public void EmptyFieldsAlert() {
		Alert emptyIDPassAlert = new Alert(AlertType.ERROR);
    	emptyIDPassAlert.setTitle("Empty Fields Error!");
    	emptyIDPassAlert.setHeaderText(null);
    	emptyIDPassAlert.setContentText("Empty Text Fields! Kindly fill them.");
    	emptyIDPassAlert.showAndWait();
	}
	
	public void WrongIDPassAlert() {
		Alert wrongIDPassAlert = new Alert(AlertType.ERROR);
    	wrongIDPassAlert.setTitle("Login Error!");
    	wrongIDPassAlert.setHeaderText(null);
    	wrongIDPassAlert.setContentText("You have entered wrong ID or Password");
    	wrongIDPassAlert.showAndWait();
	}
	
	public void DataEdittedAlert() {
		Alert dataEdittedAlert = new Alert(AlertType.CONFIRMATION);
		dataEdittedAlert.setTitle("Data Editted");
		dataEdittedAlert.setHeaderText(null);
		dataEdittedAlert.setContentText("Data has been successfully editted!");
		dataEdittedAlert.showAndWait();
	}
}
