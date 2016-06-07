package application;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller_main  {
	public static String type = "";
	public static String back = "";
	@FXML Button w1;
	@FXML Button w2;
	@FXML Button w3;
	@FXML Button w4;
	@FXML Button w5;
	@FXML Button w6;
	@FXML Button w7;
	@FXML Button w8;

	public void Water(ActionEvent e) throws IOException {
		back = "Water";
		Scene water = new Scene(FXMLLoader.load(getClass().getResource("Water.fxml")));
		water.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.setScene(water);
		app_stage.show();

	}
	
	public void Roller(ActionEvent e) throws IOException {
		back = "Roller";
		Scene roller = new Scene(FXMLLoader.load(getClass().getResource("Roller.fxml")));
		roller.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.setScene(roller);
		app_stage.show();

	}

	public void Gaming(ActionEvent e) throws IOException {
		back = "Gaming";
		Scene gaming = new Scene(FXMLLoader.load(getClass().getResource("Gaming.fxml")));
		gaming.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.setScene(gaming);
		app_stage.show();

	}
	
	public void High(ActionEvent e) throws IOException {
		back = "High";
		Scene high = new Scene(FXMLLoader.load(getClass().getResource("High.fxml")));
		high.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.setScene(high);
		app_stage.show();

	}

	public void Back(ActionEvent e) throws IOException {
	
		Scene back = new Scene(FXMLLoader.load(getClass().getResource("Menu_Actives.fxml")));
		back.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.setScene(back);
		app_stage.show();

	}
	
	public void Exit(ActionEvent e) throws IOException {
		System.exit(0);

	}
	
// Listing//
	//
	///
	///
	///
	///
	///
	///
	///
	
	
	public void Listing(ActionEvent e) throws IOException {
		
		if(w1.isFocused()){type = w1.getText();}
		if(w2.isFocused()){type = w2.getText();}
		if(w3.isFocused()){type = w3.getText();}
		if(w4.isFocused()){type = w4.getText();}
		if(w5.isFocused()){type = w5.getText();}
		try{
			if(w6.isFocused()){type = w6.getText();}}
		catch(Exception ex){}
		try{
			if(w7.isFocused()){type = w7.getText();}}
		catch(Exception ex){}
		try{
			if(w8.isFocused()){type = w8.getText();}}
		catch(Exception ex){}
		System.out.println(type);
		Scene water = new Scene(FXMLLoader.load(getClass().getResource("List.fxml")));
		water.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.setScene(water);
		app_stage.show();
	
	}
	
}


