package retail;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import retail.Main;

public class MerchandiseController {
	private Main mainObject = new Main();
	@FXML
	private TextField merchandiseName;
	@FXML
	private TextField merchandisePrice;
	@FXML
	private TextArea merchandiseDescription;
	@FXML
	private Button merchandiseOKBtn;
	@FXML
	private Button merchadiseCancelBtn;

	@FXML
	void closeWindow(ActionEvent event) {
		System.out.println("close window");
		Stage stage = (Stage) this.merchadiseCancelBtn.getScene().getWindow();
		stage.close();
	}

	@FXML
	void submitMerchandise(ActionEvent event) {
		try {
			Connection con = this.mainObject.openDatabaseConnection();
			String preparedSQL = "INSERT INTO merchandise (name, price, description) VALUES (?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(preparedSQL);
			ps.setString(1, this.merchandiseName.getText());
			ps.setString(2, this.merchandisePrice.getText());
			ps.setString(3, this.merchandiseDescription.getText());
			ps.executeUpdate();
			con.close();
			this.closeWindow(event);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}