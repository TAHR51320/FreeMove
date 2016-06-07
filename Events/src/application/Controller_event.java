package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Controller_event implements Initializable {
	@FXML 
	TextArea dscription;
	@FXML 
	TextArea address;
	@FXML 
	Label name;
	@FXML Button back;
	@FXML Button exit;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	public void Back(ActionEvent e) throws IOException {
		Scene back = new Scene(FXMLLoader.load(getClass().getResource("List_of_events.fxml")));
		back.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.setScene(back);
		app_stage.show();

	}
	
	public void Exit(ActionEvent e) throws IOException {
		System.exit(0);

	}
}
