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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class Controller_main implements Initializable {
	
	ObservableList<String> type;
	public static String mm = "";
	@FXML ListView<String>listView;
	@FXML Label l_company;
	@FXML Label l_address;
	@FXML Label l_number;
	@FXML Label l_web;
	@FXML Label l_rating;
	@FXML Button e;
	

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		

		try {
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/freemove", "user", "user");
			java.sql.Statement table = myCon.createStatement();
			ResultSet res = table.executeQuery("select * FROM clubsbars");
			while (res.next()) {
				listView.getItems().addAll(res.getString("Company"));
			}
		} catch (SQLException e) {
		}
	}
	public void Exit(ActionEvent e) throws IOException {
		System.exit(0);

	}
	public void information() throws SQLException {
		Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/freemove", "user", "user");
		ResultSet myRes = null;
		ObservableList<String>moving;
		moving = listView.getSelectionModel().getSelectedItems();
		for(String m : moving){
			mm = m;
			java.sql.PreparedStatement myStat;
			myStat = myCon.prepareStatement("select * from clubsbars where Company = ?");
			myStat.setString(1, mm);
			myRes = myStat.executeQuery();
			while (myRes.next()){
				l_company.setText(myRes.getString("Company"));
				l_address.setText(myRes.getString("Address"));
				l_number.setText(myRes.getString("Number"));
				l_web.setText(myRes.getString("Web"));
				l_rating.setText(myRes.getString("Rating"));
			}
			
		}
		
	
}}