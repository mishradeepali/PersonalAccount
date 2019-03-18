package pojos;

public class ExpensesCategoryPojo {
	private int exp_catid;
	private String exp_catname;
	private String exp_catdetails;
	private int userid;
	public ExpensesCategoryPojo() {
		super();
	}
	public ExpensesCategoryPojo(int exp_catid, String exp_catname, String exp_catdetails, int userid) {
		super();
		this.exp_catid = exp_catid;
		this.exp_catname = exp_catname;
		this.exp_catdetails = exp_catdetails;
		this.userid = userid;
	}
	
	public ExpensesCategoryPojo(int exp_catid, String exp_catname, String exp_catdetails) {
		super();
		this.exp_catid = exp_catid;
		this.exp_catname = exp_catname;
		this.exp_catdetails = exp_catdetails;
	}
	public ExpensesCategoryPojo(String exp_catname, String exp_catdetails, int userid) {
		super();
		this.exp_catname = exp_catname;
		this.exp_catdetails = exp_catdetails;
		this.userid = userid;
	}
	public int getExp_catid() {
		return exp_catid;
	}
	public void setExp_catid(int exp_catid) {
		this.exp_catid = exp_catid;
	}
	public String getExp_catname() {
		return exp_catname;
	}
	public void setExp_catname(String exp_catname) {
		this.exp_catname = exp_catname;
	}
	public String getExp_catdetails() {
		return exp_catdetails;
	}
	public void setExp_catdetails(String exp_catdetails) {
		this.exp_catdetails = exp_catdetails;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exp_catdetails == null) ? 0 : exp_catdetails.hashCode());
		result = prime * result + exp_catid;
		result = prime * result + ((exp_catname == null) ? 0 : exp_catname.hashCode());
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
		ExpensesCategoryPojo other = (ExpensesCategoryPojo) obj;
		if (exp_catdetails == null) {
			if (other.exp_catdetails != null)
				return false;
		} else if (!exp_catdetails.equals(other.exp_catdetails))
			return false;
		if (exp_catid != other.exp_catid)
			return false;
		if (exp_catname == null) {
			if (other.exp_catname != null)
				return false;
		} else if (!exp_catname.equals(other.exp_catname))
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ExpensesCategoryPojo [exp_catid=" + exp_catid + ", exp_catname=" + exp_catname + ", exp_catdetails="
				+ exp_catdetails + ", userid=" + userid + "]";
	}
	
}
