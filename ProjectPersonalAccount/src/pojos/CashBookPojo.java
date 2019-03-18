package pojos;

import java.util.Date;

public class CashBookPojo {
	private int acid;
	private String sdate;
	private String tran_date;
	private double amount;
	private String edate;
	private String operation;
	public CashBookPojo() {
		super();
	}
	public CashBookPojo(String sdate, String edate) {
		super();
		this.sdate = sdate;
		this.edate = edate;
	}
	
	public CashBookPojo(int acid,  String tran_date, double amount, String operation) {
		super();
		this.acid = acid;
		
		this.tran_date = tran_date;
		this.amount = amount;
		
		this.operation = operation;
	}

	public CashBookPojo( String tran_date, double amount,  String operation) {
		super();
		
		this.tran_date = tran_date;
		this.amount = amount;
		
		this.operation = operation;
	}

	public int getAcid() {
		return acid;
	}

	public void setAcid(int acid) {
		this.acid = acid;
	}



	public String getTran_date() {
		return tran_date;
	}

	public void setTran_date(String tran_date) {
		this.tran_date = tran_date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	
	

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + acid;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((operation == null) ? 0 : operation.hashCode());
		result = prime * result + ((tran_date == null) ? 0 : tran_date.hashCode());
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CashBookPojo other = (CashBookPojo) obj;
		
		if (acid != other.acid)
			return false;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (operation == null) {
			if (other.operation != null)
				return false;
		} else if (!operation.equals(other.operation))
			return false;
		if (tran_date == null) {
			if (other.tran_date != null)
				return false;
		} else if (!tran_date.equals(other.tran_date))
			return false;
		
		return true;
	}

	@Override
	public String toString() {
		return "CashBookPojo [acid=" + acid + ",  tran_date=" + tran_date + ", amount=" + amount
				+ ", operation=" + operation + "]";
	}
	
	
	
}
