package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import java.awt.Button;

public class Controllers  {
	ObservableList<String> printerqualitylist = FXCollections.observableArrayList("High", "Medium", "Low");
	
	@FXML
	private ChoiceBox printerquality;
	@FXML
	private Button OKbtn;
	@FXML
	private Button Setupbtn;
	@FXML
	private Button Cancelbtn;
	@FXML
	private Button Helpbtn;
	@FXML
	private CheckBox imagebtn;
	@FXML
	private CheckBox textbtn;
	@FXML
	private CheckBox codebtn;
	@FXML
	private RadioButton selectionbtn;
	@FXML 
	private RadioButton allbtn;
	@FXML
	private RadioButton appletbtn;
    @FXML
    private ToggleGroup print_area;
	@FXML
	private CheckBox printtofilebtn;
	
	
	@FXML
	private void initialize() {
		printerquality.setValue("High");
		printerquality.setItems(printerqualitylist);
		System.out.println("Print Quality Set");
	}
	@FXML
	private void okayselected(){
		System.out.println("ok selected");
	}
	@FXML
	private void setupselected(){
		System.out.println("set up selected");
	}
	@FXML
	private void cancelselected() {
		System.out.println("cancel selected");
	}
	@FXML
	private void helpselected(){
		System.out.println("help selected");
	}
	@FXML
	private void imageselected(){
		System.out.println("image selected");
	}
	@FXML
	private void textselected(){
		System.out.println("text selected");
	}
	@FXML
	private void codeselected(){
		System.out.println("code selected");
	}
	@FXML
	private void selectionselected(){
		System.out.println("selection selected");
	}
	@FXML
	private void allselected(){
		System.out.println("all selected");
	}
	@FXML
	private void appletselected(){
		System.out.println("applet selected");
	}
	@FXML
	private void printtofileselected(){
		System.out.println("print to file selected");
	}
}