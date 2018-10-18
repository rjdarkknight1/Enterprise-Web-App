package loanCalculator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.CurrencyStringConverter;

@SuppressWarnings("unchecked")
public class Controller {
	
	@FXML
	private TextField loanamount;
	@FXML
	private ChoiceBox interestrate;
	@FXML
	private ChoiceBox mortgageterm;
	@FXML
	private Button calculatebtn;
	@FXML
	private TextField totalpayment;
	@FXML
	private TableView<LoanTableItem> mortgageV;
	@FXML
	private TableColumn  month;
	@FXML
	private TableColumn payment;
	@FXML
	private TableColumn principlepaid;
	@FXML
	private TableColumn  interestpaid;
	@FXML
	private TableColumn totalinterestpaid;
	@FXML
	private TableColumn  remainingvalue;
	
	
   private final ObservableList<LoanTableItem> list =
            FXCollections.observableArrayList();
	
	ObservableList<Double> interestratelist = FXCollections.observableArrayList(2.75, 3.0, 
			3.25, 3.5, 3.75, 4.0, 4.25, 4.5, 4.75, 5.0);
	ObservableList<? extends Number> mortgagetermlist = FXCollections.observableArrayList(5, 10, 15, 30);
	
	@FXML
	private void initialize() {
		interestrate.setValue(4.0);
		interestrate.setItems(interestratelist);
		mortgageterm.setValue(30);
		mortgageterm.setItems(mortgagetermlist);
	}
	
	@FXML
	private void loanamountipt() {

	}

	@FXML
	private void calculatemtg() {
		
		list.removeAll(list);
		
		double loanamountnumber = Double.parseDouble(loanamount.getText());
		double interestratenumber = Double.parseDouble(interestrate.getValue().toString());
		double year= Double.parseDouble(mortgageterm.getValue().toString());
		double totalMonths = year * 12;
		double monthlyInterest = interestratenumber / 1200;
		double monthlypaymentnumber = loanamountnumber * monthlyInterest/ (1 - 
				1 / Math.pow(1 + monthlyInterest, totalMonths));
		double remaining = loanamountnumber;
		
		double intes = 0;
		double prcpl = 0;
		int mon = 0;
		double totalI = 0;
		double pym = 0;
	    double totalP = 0;	

		for (int i=0; i< totalMonths; i++) {
			mon = i+1;
			pym= monthlypaymentnumber;
			intes = monthlyInterest * remaining;
			totalI += intes;
			prcpl = monthlypaymentnumber - intes;
			remaining = remaining - prcpl;

			LoanTableItem rawdata = new LoanTableItem(mon,pym,prcpl,intes,totalI,remaining);
			list.add(rawdata);
		}
		
		totalP = totalMonths * pym;
		String TotalP2 = String.format("%.2f", totalP);
		
		month.setCellValueFactory(new PropertyValueFactory<LoanTableItem, Integer>("monthNumber"));
		payment.setCellValueFactory(new PropertyValueFactory<LoanTableItem, Double>("payment"));
		principlepaid.setCellValueFactory(new PropertyValueFactory<LoanTableItem, Double>("principlePaid"));
		interestpaid.setCellValueFactory(new PropertyValueFactory<LoanTableItem, Double>("interestPaid"));
		totalinterestpaid.setCellValueFactory(new PropertyValueFactory<LoanTableItem, Double>("totalInterestPaid"));
		remainingvalue.setCellValueFactory(new PropertyValueFactory<LoanTableItem, Double>("remainingValue"));
	
		payment.setCellFactory(TextFieldTableCell.<LoanTableItem, Number>forTableColumn(new CurrencyStringConverter()));
		principlepaid.setCellFactory(TextFieldTableCell.<LoanTableItem, Number>forTableColumn(new CurrencyStringConverter()));
		interestpaid.setCellFactory(TextFieldTableCell.<LoanTableItem, Number>forTableColumn(new CurrencyStringConverter()));
		totalinterestpaid.setCellFactory(TextFieldTableCell.<LoanTableItem, Number>forTableColumn(new CurrencyStringConverter()));
		remainingvalue.setCellFactory(TextFieldTableCell.<LoanTableItem, Number>forTableColumn(new CurrencyStringConverter()));

		mortgageV.setItems(list);
	    totalpayment.setText(TotalP2);
	}

	@FXML
	private void totalpaymentamt() {

	}
	
}