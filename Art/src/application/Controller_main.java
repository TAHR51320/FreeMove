package application;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;

public class Controller_main {
	public static String type;
	
	
	
	public void Galleries(ActionEvent e) throws IOException {
		type = "Galleries";
		Scene g = new Scene(FXMLLoader.load(getClass().getResource("List.fxml")));
		g.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.setScene(g);
		app_stage.show();

	}
	
	public void Theater(ActionEvent e) throws IOException {
		type = "Theaters";
		Scene t = new Scene(FXMLLoader.load(getClass().getResource("List.fxml")));
		t.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.setScene(t);
		app_stage.show();

	}

	public void Cinema(ActionEvent e) throws IOException {
		type = "Cinema";
		Scene c = new Scene(FXMLLoader.load(getClass().getResource("List.fxml")));
		c.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.setScene(c);
		app_stage.show();

	}

	public void Back(ActionEvent e) throws IOException {
	
		Scene back = new Scene(FXMLLoader.load(getClass().getResource("Menu_Art.fxml")));
		back.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.setScene(back);
		app_stage.show();

	}
	
	public void Exit(ActionEvent e) throws IOException {
		System.exit(0);

	}
	
	
	}
	

	

