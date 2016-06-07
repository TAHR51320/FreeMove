package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class admin {
	@FXML ImageView imv1;
	@FXML TextField textID;
	static String s1;
	public void select_1(ActionEvent e) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "gif", "png");
		fileChooser.addChoosableFileFilter(filter);
		int result = fileChooser.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			String path = selectedFile.getAbsolutePath();
			System.out.println(path);
			String ss = path.substring(path.indexOf("&"));
			s1 = path;
			imv1.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("image/" + ss)));

		} else if (result == JFileChooser.CANCEL_OPTION) {
			System.out.println("No Data");
		}
		
	}
	public void add(ActionEvent e) throws SQLException, FileNotFoundException {
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/freemove", "user", "user");
		String id = textID.getText();
		
		try{
			InputStream is1 = new FileInputStream(new File(s1));
			java.sql.PreparedStatement myStmt = myConn
					.prepareStatement("update active set Map = ? where Id = ?");
			myStmt.setBlob(1, is1);
			myStmt.setString(2, id);
			myStmt.executeUpdate();
			System.out.println("complite");
		}catch(Exception ex){}

}
	public void Exit(ActionEvent e) throws IOException {
		System.exit(0);

	}
	public void Back(ActionEvent e) throws IOException {
		Scene back = new Scene(FXMLLoader.load(getClass().getResource("Menu_Actives.fxml")));
		back.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		app_stage.setScene(back);
		app_stage.show();

	}
}
