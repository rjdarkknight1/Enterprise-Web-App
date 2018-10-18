package loanCalculator;

public class LoanTableItem {

    private Integer monthNumber;
    private Double payment;
    private Double principlePaid;
    private Double interestPaid;
    private Double totalInterestPaid;
    private Double remainingValue;


    LoanTableItem(Integer monthNumber, Double payment, Double principlePaid, Double interestPaid, Double totalInterestPaid, 
    		Double remainingValue) {
        this.monthNumber = monthNumber;
        this.payment = payment;
        this.principlePaid = principlePaid;
        this.interestPaid = interestPaid;
        this.totalInterestPaid = totalInterestPaid;
        this.remainingValue = remainingValue;
    }

    public Integer getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(Integer monthNumber) {
        this.monthNumber = monthNumber;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public Double getPrinciplePaid() {
        return principlePaid;
    }

    public void setPrinciplePaid(Double principlePaid) {
        this.principlePaid = principlePaid;
    }

    public Double getInterestPaid() {
        return interestPaid;
    }

    public void setInterestPaid(Double interestPaid) {
        this.interestPaid = interestPaid;
    }

    public Double getTotalInterestPaid() {
        return totalInterestPaid;
    }

    public void setTotalInterestPaid(Double totalInterestPaid) {
        this.totalInterestPaid = totalInterestPaid;
    }

    public Double getRemainingValue() {
        return remainingValue;
    }

    public void setRemainingValue(Double remainingValue) {
        this.remainingValue = remainingValue;
    }

}
