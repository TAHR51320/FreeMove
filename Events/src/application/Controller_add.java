package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller_add implements Initializable{
	@FXML Button back;
	@FXML Button exit;
	@FXML Button add;
	@FXML TextField namel;
	@FXML TextField timel;
	@FXML TextArea descriptionl;
	@FXML TextField datel;
	@FXML TextField addressl;
	static String name;
	static String time;
	static String description;
	static String date;
	static String address;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		//date = Controller_main.date_string;
		//datel.setText(date);
		
	}
	public void Add(ActionEvent e) throws IOException {
		name = namel.getText();
		time = timel.getText();
		date = datel.getText();
		address = addressl.getText();
				
		description = descriptionl.getText();
		System.out.println(Controller_main.date_string);
		
		try {
			
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/freemove", "user", "user");
		java.sql.PreparedStatement mySta = myCon.prepareStatement("insert into events (Name, Time, Description, Date, Address) values (?, ?, ?, ?, ?)");
		mySta.setString(1, name);
		mySta.setString(2, time);
		mySta.setString(3, description);
		mySta.setString(4, date);
		mySta.setString(5, address);
		mySta.executeUpdate();
		} catch (SQLException ev) {
			// TODO Auto-generated catch block
			ev.printStackTrace();
		}
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


