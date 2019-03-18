package pojos;

import java.util.Date;

public class IncomesPojo {
	private int inc_id;
	private String inc_ac;
	private int userid;
	private int inc_catid;
	private double amount;
	private String tran_date;
	private String receiveby;
	private String remark;
	public IncomesPojo() {
		super();
	}
	public IncomesPojo(int inc_id, String inc_ac, int userid, int inc_catid, double amount, String tran_date,
			String receiveby, String remark) {
		super();
		this.inc_id = inc_id;
		this.inc_ac = inc_ac;
		this.userid = userid;
		this.inc_catid = inc_catid;
		this.amount = amount;
		this.tran_date = tran_date;
		this.receiveby = receiveby;
		this.remark = remark;
	}
	
	public IncomesPojo(int inc_id, String inc_ac, int inc_catid, double amount, String tran_date, String receiveby,
			String remark) {
		super();
		this.inc_id = inc_id;
		this.inc_ac = inc_ac;
		this.inc_catid = inc_catid;
		this.amount = amount;
		this.tran_date = tran_date;
		this.receiveby = receiveby;
		this.remark = remark;
	}
	public IncomesPojo(String inc_ac, int userid, int inc_catid, double amount, String tran_date, String receiveby,
			String remark) {
		super();
		this.inc_ac = inc_ac;
		this.userid = userid;
		this.inc_catid = inc_catid;
		this.amount = amount;
		this.tran_date = tran_date;
		this.receiveby = receiveby;
		this.remark = remark;
	}
	public int getInc_id() {
		return inc_id;
	}
	public void setInc_id(int inc_id) {
		this.inc_id = inc_id;
	}
	public String getInc_ac() {
		return inc_ac;
	}
	public void setInc_ac(String inc_ac) {
		this.inc_ac = inc_ac;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getInc_catid() {
		return inc_catid;
	}
	public void setInc_catid(int inc_catid) {
		this.inc_catid = inc_catid;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTran_date() {
		return tran_date;
	}
	public void setTran_date(String tran_date) {
		this.tran_date = tran_date;
	}
	public String getReceiveby() {
		return receiveby;
	}
	public void setReceiveby(String receiveby) {
		this.receiveby = receiveby;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((inc_ac == null) ? 0 : inc_ac.hashCode());
		result = prime * result + inc_catid;
		result = prime * result + inc_id;
		result = prime * result + ((receiveby == null) ? 0 : receiveby.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((tran_date == null) ? 0 : tran_date.hashCode());
		result = prime * result + userid;
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
		IncomesPojo other = (IncomesPojo) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (inc_ac == null) {
			if (other.inc_ac != null)
				return false;
		} else if (!inc_ac.equals(other.inc_ac))
			return false;
		if (inc_catid != other.inc_catid)
			return false;
		if (inc_id != other.inc_id)
			return false;
		if (receiveby == null) {
			if (other.receiveby != null)
				return false;
		} else if (!receiveby.equals(other.receiveby))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (tran_date == null) {
			if (other.tran_date != null)
				return false;
		} else if (!tran_date.equals(other.tran_date))
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "IncomesPojo [inc_id=" + inc_id + ", inc_ac=" + inc_ac + ", userid=" + userid + ", inc_catid="
				+ inc_catid + ", amount=" + amount + ", tran_date=" + tran_date + ", receiveby=" + receiveby
				+ ", remark=" + remark + "]";
	}
	
//	
}
