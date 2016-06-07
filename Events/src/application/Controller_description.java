package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.ResourceBundle;

import com.mysql.jdbc.UpdatableResultSet;

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
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controller_description implements Initializable {

	@FXML
	Label date;
	@FXML
	Button back;
	@FXML
	Button exit;
	@FXML
	Button add;
	@FXML
	ListView<String> list = new ListView<String>();
	static ArrayList<String> time = new ArrayList<String>();
	ObservableList<String> select;
	static String check_time;
	static String check_name;
	static ArrayList<Integer> a = Controller_main.a;
	static String b;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println(Controller_main.s);

		list.getItems().clear();
		refresh();
	}

	public void Add(ActionEvent e) throws IOException {
		Scene add = new Scene(FXMLLoader.load(getClass().getResource("Add_event.fxml")));
		add.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.setScene(add);
		app_stage.show();
	}

	public void delete(ActionEvent e) throws SQLException {
		Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/freemove", "user", "user");
	  	  java.sql.PreparedStatement mySta = myCon.prepareStatement("select * from events where Time =? and Date=? and Name=?");
		

			ResultSet myRes = null;
			mySta.setString(1, check_time);
			mySta.setString(3, check_name);

			mySta.setString(2, Controller_main.ydate + "-" + Controller_main.mdate + "-" + Controller_main.ddate);

			myRes = mySta.executeQuery();
			while (myRes.next()) {
				b = myRes.getString("Id");
System.out.println(b);
			}
		
		String del = "delete from events where Time =? and Name =? and Date =?";
		PreparedStatement delete = myCon.prepareStatement(del);
		delete.setString(1, check_time);
		delete.setString(2, check_name);
		delete.setString(3, Controller_main.ydate + "-" + Controller_main.mdate + "-" + Controller_main.ddate);
		delete.executeUpdate();
		
		a.remove(a.indexOf(Integer.parseInt(b)));

		list.getItems().clear();
		refresh();

	}

	public void select() {
		select = list.getSelectionModel().getSelectedItems();
		for (String m : select) {
			check_time = m.substring(0, 8);
			check_name = m.substring(13);
			System.out.println(check_name);

		}

	}
	// public void Show(MouseEvent e) throws IOException {
	// Scene show = new
	// Scene(FXMLLoader.load(getClass().getResource("Event.fxml")));
	// show.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	// Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
	// app_stage.setScene(show);
	// app_stage.show();

	// }
	public void Back(ActionEvent e) throws IOException {
		Scene back = new Scene(FXMLLoader.load(getClass().getResource("Description.fxml")));
		back.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.setScene(back);
		app_stage.show();

	}

	public void Exit(ActionEvent e) throws IOException {
		System.exit(0);

	}

	public void refresh() {
		date.setText(Controller_main.s);
		list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		try {
			
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/freemove", "user", "user");
			java.sql.PreparedStatement mySta = myCon.prepareStatement("select * from events where Id =?");
			ResultSet myRes = null;
			for (int i = 0; i < a.size(); i++) {

				mySta.setInt(1, a.get(i));
				
				myRes = mySta.executeQuery();
				
				while (myRes.next()) {
					time.add(myRes.getString("Time"));
				}

			}
			;
			time.sort(null);

		}

		catch (Exception e) {
		}

		try {

			for (int i = 0; i < time.size(); i++) {
				Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/freemove", "user", "user");
				java.sql.PreparedStatement mySta = myCon
						.prepareStatement("select * from events where Time =? and Date=?");
				ResultSet myRes = null;
				mySta.setString(1, time.get(i));

				mySta.setString(2, Controller_main.ydate + "-" + Controller_main.mdate + "-" + Controller_main.ddate);

				myRes = mySta.executeQuery();
				while (myRes.next()) {
					list.getItems().addAll(myRes.getString("Time") + "     " + myRes.getString("Name"));

				}
			}
		} catch (Exception e) {
		}
	}
}
