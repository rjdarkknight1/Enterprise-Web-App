package retail;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.stage.Window;
import retail.Main;

public class EmployeeController {
	private Main mainObject = new Main();
	ObservableList<String> states = FXCollections.observableArrayList("Alabama", "Alaska",
			"Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware",
			"District Of Columbia", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana",
			"Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts",
			"Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada",
			"New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina",
			"North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island",
			"South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia",
			"Washington", "West Virginia", "Wisconsin", "Wyoming");
	@FXML
	private TextField employeeFirstNameEnter;
	@FXML
	private TextField employeeLastNameEnter;
	@FXML
	private TextField employeeStreetEnter;
	@FXML
	private TextField employeeCityEnter;
	@FXML
	private TextField employeeZipcodeEnter;
	@FXML
	private ComboBox<String> employeeStateCombo;
	@FXML
	private RadioButton employeeGenderMaleRadio;
	@FXML
	private ToggleGroup genderToggle;
	@FXML
	private RadioButton employeeGenderFemaleRadio;
	@FXML
	private Button employeeOKBtn;
	@FXML
	private Button employeeCancelbtn;

	@FXML
	private void initialize() {
		System.out.println("initialize employee controller");
		this.employeeStateCombo.setValue((String) "State");
		this.employeeStateCombo.setItems(this.states);
	}

	@FXML
	void closeWindow(ActionEvent event) {
		System.out.println("close window");
		Stage stage = (Stage) this.employeeCancelbtn.getScene().getWindow();
		stage.close();
	}

	@FXML
	void submitemployee(ActionEvent event) {
		try {
			Connection con = this.mainObject.openDatabaseConnection();
			String preparedSQL = "INSERT INTO employee (firstName, lastName, streetAddress, city, state, zipcode, gender) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(preparedSQL);
			ps.setString(1, this.employeeFirstNameEnter.getText());
			ps.setString(2, this.employeeLastNameEnter.getText());
			ps.setString(3, this.employeeStreetEnter.getText());
			ps.setString(4, this.employeeCityEnter.getText());
			ps.setString(5, (String) this.employeeStateCombo.getValue());
			ps.setString(6, this.employeeZipcodeEnter.getText());
			ps.setString(7, ((RadioButton) this.genderToggle.getSelectedToggle()).getText());
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