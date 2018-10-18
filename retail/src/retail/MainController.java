package retail;

import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import retail.Main;
import retail.Merchandise;
import retail.Person;

public class MainController {
	private Main mainObject = new Main();
	@FXML
	private MenuItem exitApplication;
	@FXML
	private MenuItem newCustomerMenuItem;
	@FXML
	private MenuItem listCustomers;
	@FXML
	private MenuItem newEmployeeMenuItem;
	@FXML
	private MenuItem listEmployees;
	@FXML
	private MenuItem newMerchandiseMenuItem;
	@FXML
	private MenuItem listMerchadise;
	@FXML
	private AnchorPane anchorPaneCustomer;
	@FXML
	private Button newCustomerBtn;
	@FXML
	private TableView<Person> customerTableView;
	@FXML
	private TableColumn<Person, String> customerFirstName;
	@FXML
	private TableColumn<Person, String> customerLastName;
	@FXML
	private TableColumn<Person, String> customerAddress;
	@FXML
	private TableColumn<Person, String> customerCity;
	@FXML
	private TableColumn<Person, String> customerState;
	@FXML
	private TableColumn<Person, String> customerZipcode;
	@FXML
	private TableColumn<Person, String> customerGender;
	@FXML
	private TableView<Person> employeeTableView;
	@FXML
	private TableColumn<Person, String> employeeFirstName;
	@FXML
	private TableColumn<Person, String> employeeLastName;
	@FXML
	private TableColumn<Person, String> employeeAddress;
	@FXML
	private TableColumn<Person, String> employeeCity;
	@FXML
	private TableColumn<Person, String> employeeState;
	@FXML
	private TableColumn<Person, String> employeeZipcode;
	@FXML
	private TableColumn<Person, String> employeeGender;
	@FXML
	private AnchorPane anchorPaneEmployee;
	@FXML
	private Button newEmployeeBtn;
	@FXML
	private AnchorPane anchorPaneMerchandise;
	@FXML
	private Button newMerchadiseBtn;
	@FXML
	private TableView<Merchandise> merchandiseTableView;
	@FXML
	private TableColumn<Merchandise, String> merchandiseName;
	@FXML
	private TableColumn<Merchandise, Float> merchandisePrice;
	@FXML
	private TableColumn<Merchandise, String> merchandiseDescription;

	@FXML
	private void initialize() {
		System.out.println("Initialize main controller");
		this.showCustomer(null);
	}

	@FXML
	void displayCustomerDialog(ActionEvent event) throws IOException {
		System.out.println("Add customer");
		FXMLLoader addCustomerLoader = new FXMLLoader(this.getClass().getResource("customer.fxml"));
		Parent root = (Parent) addCustomerLoader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage.show();
	}

	@FXML
	void displayEmployeeDialog(ActionEvent event) throws IOException {
		System.out.println("Add employee");
		FXMLLoader addEmployeeLoader = new FXMLLoader(this.getClass().getResource("employee.fxml"));
		Parent root2 = (Parent) addEmployeeLoader.load();
		Stage stage2 = new Stage();
		stage2.setScene(new Scene(root2));
		stage2.show();
	}

	@FXML
	void displayMerchandiseDialog(ActionEvent event) throws IOException {
		System.out.println("Add merchandise");
		FXMLLoader addMerchandiseLoader = new FXMLLoader(this.getClass().getResource(
				"merchandise.fxml"));
		Parent root = (Parent) addMerchandiseLoader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage.show();
	}

	@FXML
	void exitApplication(ActionEvent event) {
		System.out.println("Exit");
		Platform.exit();
	}

	@FXML
	void showCustomer(ActionEvent event) {
		System.out.println("Show Customer");
		try {
			Connection dbConnection = this.mainObject.openDatabaseConnection();
			String preparedSQL = "SELECT * FROM customer";
			PreparedStatement ps = dbConnection.prepareStatement(preparedSQL);
			ResultSet customers = ps.executeQuery();
			ObservableList customerData = FXCollections.observableArrayList();
			while (customers.next()) {
				Person person = new Person();
				person.setFirstName(customers.getString("firstName"));
				person.setLastName(customers.getString("lastName"));
				person.setStreetAddress(customers.getString("streetAddress"));
				person.setCity(customers.getString("city"));
				person.setState(customers.getString("state"));
				person.setZipcode(customers.getString("zipcode"));
				person.setGender(customers.getString("gender"));
				customerData.add((Object) person);
			}
			this.customerFirstName.setCellValueFactory((Callback) new PropertyValueFactory(
					"firstName"));
			this.customerLastName.setCellValueFactory((Callback) new PropertyValueFactory(
					"lastName"));
			this.customerAddress.setCellValueFactory((Callback) new PropertyValueFactory(
					"streetAddress"));
			this.customerCity.setCellValueFactory((Callback) new PropertyValueFactory("city"));
			this.customerState.setCellValueFactory((Callback) new PropertyValueFactory("state"));
			this.customerZipcode.setCellValueFactory((Callback) new PropertyValueFactory(
					"zipcode"));
			this.customerGender.setCellValueFactory((Callback) new PropertyValueFactory("gender"));
			this.customerTableView.setItems(customerData);
			dbConnection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.anchorPaneMerchandise.setVisible(false);
		this.anchorPaneEmployee.setVisible(false);
		this.anchorPaneCustomer.setVisible(true);
	}

	@FXML
	void showEmployee(ActionEvent event) {
		System.out.println("Show Employee");
		try {
			Connection dbConnection = this.mainObject.openDatabaseConnection();
			String preparedSQL = "SELECT * FROM employee";
			PreparedStatement ps = dbConnection.prepareStatement(preparedSQL);
			ResultSet employees = ps.executeQuery();
			ObservableList employeeData = FXCollections.observableArrayList();
			while (employees.next()) {
				Person person = new Person();
				person.setFirstName(employees.getString("firstName"));
				person.setLastName(employees.getString("lastName"));
				person.setStreetAddress(employees.getString("streetAddress"));
				person.setCity(employees.getString("city"));
				person.setState(employees.getString("state"));
				person.setZipcode(employees.getString("zipcode"));
				person.setGender(employees.getString("gender"));
				employeeData.add((Object) person);
			}
			this.employeeFirstName.setCellValueFactory((Callback) new PropertyValueFactory(
					"firstName"));
			this.employeeLastName.setCellValueFactory((Callback) new PropertyValueFactory(
					"lastName"));
			this.employeeAddress.setCellValueFactory((Callback) new PropertyValueFactory(
					"streetAddress"));
			this.employeeCity.setCellValueFactory((Callback) new PropertyValueFactory("city"));
			this.employeeState.setCellValueFactory((Callback) new PropertyValueFactory("state"));
			this.employeeZipcode.setCellValueFactory((Callback) new PropertyValueFactory(
					"zipcode"));
			this.employeeGender.setCellValueFactory((Callback) new PropertyValueFactory("gender"));
			this.employeeTableView.setItems(employeeData);
			dbConnection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.anchorPaneMerchandise.setVisible(false);
		this.anchorPaneEmployee.setVisible(true);
		this.anchorPaneCustomer.setVisible(false);
	}

	@FXML
	void showMerchadise(ActionEvent event) {
		System.out.println("Show Merchadise");
		try {
			Connection dbConnection = this.mainObject.openDatabaseConnection();
			String preparedSQL = "SELECT * FROM merchandise";
			PreparedStatement ps = dbConnection.prepareStatement(preparedSQL);
			ResultSet merchandiseList = ps.executeQuery();
			ObservableList merchandiseData = FXCollections.observableArrayList();
			while (merchandiseList.next()) {
				Merchandise merchandise = new Merchandise();
				merchandise.setName(merchandiseList.getString("name"));
				merchandise.setPrice(merchandiseList.getFloat("price"));
				merchandise.setDescription(merchandiseList.getString("description"));
				merchandiseData.add((Object) merchandise);
			}
			this.merchandiseName.setCellValueFactory((Callback) new PropertyValueFactory("name"));
			this.merchandisePrice.setCellValueFactory((Callback) new PropertyValueFactory("price"));
			this.merchandiseDescription.setCellValueFactory((Callback) new PropertyValueFactory(
					"description"));
			this.merchandiseTableView.setItems(merchandiseData);
			dbConnection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.anchorPaneMerchandise.setVisible(true);
		this.anchorPaneEmployee.setVisible(false);
		this.anchorPaneCustomer.setVisible(false);
	}
}