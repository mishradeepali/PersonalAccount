package pojos;

public class IncomeCategoryPojo {
	private int inc_catid;
	private String inc_catname;
	private String inc_catdetails;
	private int userid;
	public IncomeCategoryPojo() {
		super();
	}
	public IncomeCategoryPojo(int inc_catid, String inc_catname, String inc_catdetails, int userid) {
		super();
		this.inc_catid = inc_catid;
		this.inc_catname = inc_catname;
		this.inc_catdetails = inc_catdetails;
		this.userid = userid;
	}
	
	public IncomeCategoryPojo(int inc_catid, String inc_catname, String inc_catdetails) {
		super();
		this.inc_catid = inc_catid;
		this.inc_catname = inc_catname;
		this.inc_catdetails = inc_catdetails;
	}
	public IncomeCategoryPojo(String inc_catname, String inc_catdetails, int userid) {
		super();
		this.inc_catname = inc_catname;
		this.inc_catdetails = inc_catdetails;
		this.userid = userid;
	}
	public int getInc_catid() {
		return inc_catid;
	}
	public void setInc_catid(int inc_catid) {
		this.inc_catid = inc_catid;
	}
	public String getInc_catname() {
		return inc_catname;
	}
	public void setInc_catname(String inc_catname) {
		this.inc_catname = inc_catname;
	}
	public String getInc_catdetails() {
		return inc_catdetails;
	}
	public void setInc_catdetails(String inc_catdetails) {
		this.inc_catdetails = inc_catdetails;
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
		result = prime * result + ((inc_catdetails == null) ? 0 : inc_catdetails.hashCode());
		result = prime * result + inc_catid;
		result = prime * result + ((inc_catname == null) ? 0 : inc_catname.hashCode());
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
		IncomeCategoryPojo other = (IncomeCategoryPojo) obj;
		if (inc_catdetails == null) {
			if (other.inc_catdetails != null)
				return false;
		} else if (!inc_catdetails.equals(other.inc_catdetails))
			return false;
		if (inc_catid != other.inc_catid)
			return false;
		if (inc_catname == null) {
			if (other.inc_catname != null)
				return false;
		} else if (!inc_catname.equals(other.inc_catname))
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "IncomeCategoryPojo [inc_catid=" + inc_catid + ", inc_catname=" + inc_catname + ", inc_catdetails="
				+ inc_catdetails + ", userid=" + userid + "]";
	}
	
}
