package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Controller_main implements Initializable {

	ObservableList<String> type;
	@FXML 
	Button add;
	@FXML
	Button e;
	@FXML
	Button search;
	@FXML
	DatePicker date;
	static String s = " ";
	@FXML
	Label l_notevents;
	static ObservableList<String> list_date;
	static ArrayList<Integer> a = new ArrayList<Integer>();
	static String ddate, mdate, ydate;
	boolean admin = true;
    static String date_string;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			if(admin == false){
				add.setVisible(false);
			}
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/freemove", "user", "user");
			java.sql.Statement table = myCon.createStatement();
			ResultSet res = table.executeQuery("select * FROM events");
			while (res.next()) {
			}
		} catch (SQLException e) {
		}
	}

	public void Exit(ActionEvent e) throws IOException {
		System.exit(0);

	}
	public void Add(ActionEvent e) throws IOException{
		Scene add = new Scene(FXMLLoader.load(getClass().getResource("Add_event.fxml")));
		add.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.setScene(add);
		app_stage.show();
	}

	public void search(ActionEvent e) throws SQLException, IOException {
		a.clear();
		s = date.getEditor().getText();
		Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/freemove", "user", "user");
		ResultSet myRes = null;
		if (s != null) {
			ddate = s.substring(0, 2);
			mdate = s.substring(3, 5);
			ydate = s.substring(6);
			date_string = (ydate + "-" + mdate + "-" + ddate);
			java.sql.PreparedStatement mySta = myCon.prepareStatement("select * from events where Date =?");

			mySta.setString(1, ydate + "-" + mdate + "-" + ddate);

			myRes = mySta.executeQuery();

			while (myRes.next()) {
				a.add(Integer.parseInt(myRes.getString("Id")));

			}
			System.out.println(a);
			if (a.size() != 0) {
				if(admin == true){
					Scene descrip = new Scene(FXMLLoader.load(getClass().getResource("Description_admin.fxml")));
					descrip.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
					app_stage.setScene(descrip);
					app_stage.show();
					
				}
if(admin == false){
				Scene descrip = new Scene(FXMLLoader.load(getClass().getResource("Description.fxml")));
				descrip.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
				app_stage.setScene(descrip);
				app_stage.show();
				
}
			} else if (a.size() == 0) {
				l_notevents.setVisible(true);
				
			}
		}

	}
}