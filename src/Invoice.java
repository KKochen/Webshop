import java.util.ArrayList;

public class Invoice {
	private boolean paid;
	private int invoiceId;
	private ArrayList<Article> orderList = new ArrayList<>();
	private double totalPayment;
	
	
	public boolean isPaid() {
		return paid;
	}
	
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	
	public int getInvoiceId() {
		return invoiceId;
	}
	
	public void setInvoiceId(int id) {
		this.invoiceId = id;
	}
	
	public ArrayList<Article> getOrderList() {
		return orderList;
	}
	
	public void setOrderList(ArrayList<Article> list) {
		this.orderList = list;
	}
	
	public double getTotalPayment() {
		return totalPayment;
	}
	
	public void setTotalPayment(double payment) {
		this.totalPayment = payment;
	}
}
