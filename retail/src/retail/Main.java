package retail;

import java.io.PrintStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] args) {
		Main.launch((String[]) args);
	}

	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("retailMain.fxml"));
		primaryStage.setTitle("Retail System");
		primaryStage.setScene(new Scene(root, 850.0, 600.0));
		primaryStage.show();
	}

	public Connection openDatabaseConnection() throws ClassNotFoundException, SQLException {

		// Connection connection =
		// DriverManager.getConnection("jdbc:mysql://localhost/retailsystem",
		// "root", "root");
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://35.188.116.177/retailsystem", "root", "root");

		/*
		 * String jdbcUrl = String.format(
		 * "jdbc:mysql://google/%s?cloudSqlInstance=%s&" +
		 * "socketFactory=com.google.cloud.sql.mysql.SocketFactory",
		 * "retailsystem", "igneous-mason-201920:us-central1:retail605481");
		 * 
		 * Connection connection = DriverManager.getConnection(jdbcUrl, "root",
		 * "root");
		 */

		System.out.println("Database connected");
		return connection;
	}

	public void closeDatabaseConnection(Connection connection) throws SQLException {
		connection.close();
	}
}