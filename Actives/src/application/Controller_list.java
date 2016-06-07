package application;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Controller_list implements Initializable {
	static String mm = "";
	@FXML ListView<String>listView;
	@FXML Label l_company;
	@FXML Label l_address;
	@FXML Label l_number;
	@FXML Label l_web;
	@FXML Label l_rating;
	Scene s;
	@FXML ImageView imv_map;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/freemove", "user", "user");
			ResultSet myRes = null;
			java.sql.PreparedStatement myStat;
			myStat = myCon.prepareStatement("select * from active where Type = ?");
			myStat.setString(1, Controller_main.type);
			myRes = myStat.executeQuery();
			listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
			while (myRes.next()) {
				listView.getItems().addAll(myRes.getString("Company"));
			}
		} catch (SQLException e) {
		}
		
	}
	
	public void information() throws SQLException, IOException {
		Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/freemove", "user", "user");
		ResultSet myRes = null;
		ObservableList<String>moving;
		moving = listView.getSelectionModel().getSelectedItems();
		for(String m : moving){
			mm = m;
			java.sql.PreparedStatement myStat;
			myStat = myCon.prepareStatement("select * from active where Company = ?");
			myStat.setString(1, m);
			myRes = myStat.executeQuery();
			Blob img_map;
			byte[] imgData_map = null;
			while (myRes.next()){
				l_company.setText(myRes.getString("Company"));
				l_address.setText(myRes.getString("Address"));
				l_number.setText(myRes.getString("Number"));
				l_web.setText(myRes.getString("Web"));
				l_rating.setText(myRes.getString("Rating"));
				
				img_map = myRes.getBlob("map");
				imgData_map = img_map.getBytes(1, (int) img_map.length());
				BufferedImage imag_map =ImageIO.read(new ByteArrayInputStream(imgData_map));
				imv_map.setImage(SwingFXUtils.toFXImage(imag_map, null));
			}
			
		}
	}


	public void back(ActionEvent e) throws IOException {
		
		if(Controller_main.back.equals("Roller")){
			s = new Scene(FXMLLoader.load(getClass().getResource("Roller.fxml")));
		}
		if(Controller_main.back.equals("Water")){
			s = new Scene(FXMLLoader.load(getClass().getResource("Water.fxml")));
		}
		if(Controller_main.back.equals("High")){
			s = new Scene(FXMLLoader.load(getClass().getResource("High.fxml")));
		}
		if(Controller_main.back.equals("Gaming")){
			s = new Scene(FXMLLoader.load(getClass().getResource("Gaming.fxml")));
		}
		s.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.setScene(s);
		app_stage.show();

	}
	public void Exit(ActionEvent e) throws IOException {
		System.exit(0);

	}
	
}
