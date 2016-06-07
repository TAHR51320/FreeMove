package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	boolean admin = false;
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root;
			if(admin == true){root=FXMLLoader.load(getClass().getResource("Admin_main.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			System.out.println("fffffffffffffffff");}
			if(admin == false){root=FXMLLoader.load(getClass().getResource("Menu_Actives.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();}
			
		} catch(Exception e) {
			
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
