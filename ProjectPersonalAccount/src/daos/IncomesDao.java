package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojos.ExpensesPojo;
import pojos.IncomesPojo;
import utilities.*;

public class IncomesDao {
	public void create(IncomesPojo bank) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into incomes (inc_ac,userid,inc_catid,amount,tran_date,receiveby,remark) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bank.getInc_ac());
			ps.setString(5, bank.getTran_date());
			ps.setInt(2, bank.getUserid());
			ps.setInt(3, bank.getInc_catid());
			ps.setDouble(4, bank.getAmount());
			ps.setString(6, bank.getReceiveby());
			ps.setString(7, bank.getRemark());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}
	
	public void edit(IncomesPojo bank) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update incomes set inc_ac = ?,userid = ?,inc_catid = ?, amount = ?, tran_date = ?,receiveby = ?,remark = ? where inc_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bank.getInc_ac());
			ps.setString(5, bank.getTran_date());
			ps.setInt(2, bank.getUserid());
			ps.setInt(3, bank.getInc_catid());
			ps.setDouble(4, bank.getAmount());
			ps.setString(6, bank.getReceiveby());
			ps.setString(7, bank.getRemark());
			ps.setInt(8, bank.getInc_id());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}
	
	public void remove(int bank) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from incomes where inc_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bank);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}
	
	public IncomesPojo find(int acid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		IncomesPojo bank = new IncomesPojo();
		try {
			String sql = "select * from incomes where inc_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, acid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				bank.setInc_id(acid);
				bank.setInc_ac(rs.getString("Inc_ac"));
				bank.setTran_date(rs.getString("Tran_date"));
				bank.setInc_catid((rs.getInt("Inc_catid")));
				bank.setReceiveby(rs.getString("receiveby"));
				bank.setRemark(rs.getString("remark"));
				bank.setAmount((rs.getDouble("amount")));
				bank.setUserid((rs.getInt("userid")));
				}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return bank;
	}
	public ArrayList<IncomesPojo> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<IncomesPojo> listCategory = new ArrayList<IncomesPojo>();
		try {
			String sql = "select * from incomes";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				IncomesPojo bank = new IncomesPojo();
				bank.setInc_id(rs.getInt("Inc_id"));
				bank.setInc_ac(rs.getString("Inc_ac"));
				bank.setTran_date(rs.getString("Tran_date"));
				bank.setInc_catid((rs.getInt("Inc_catid")));
				bank.setReceiveby(rs.getString("receiveby"));
				bank.setRemark(rs.getString("remark"));
				bank.setAmount((rs.getDouble("amount")));
				bank.setUserid((rs.getInt("userid")));
				listCategory.add(bank);
			}
		} catch (SQLException sq) {
			System.out.println("unable to find the record." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listCategory;
	}
	public ArrayList<IncomesPojo> findAll(int userid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<IncomesPojo> listCategory = new ArrayList<IncomesPojo>();
		try {
			String sql = "select * from incomes where userid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,userid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				IncomesPojo bank = new IncomesPojo();
				bank.setInc_id(rs.getInt("inc_id"));
				bank.setInc_ac(rs.getString("Inc_ac"));
				bank.setTran_date(rs.getString("Tran_date"));
				bank.setInc_catid((rs.getInt("Inc_catid")));
				bank.setReceiveby(rs.getString("receiveby"));
				bank.setRemark(rs.getString("remark"));
				bank.setAmount((rs.getDouble("amount")));
				bank.setUserid((rs.getInt("userid")));
				listCategory.add(bank);
			}
		} catch (SQLException sq) {
			System.out.println("unable to find the record." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listCategory;
	}
	
	public ArrayList<IncomesPojo> findAll(String sdate,String edate,int userid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<IncomesPojo> listCategory = new ArrayList<IncomesPojo>();
		try {
			String sql = "select * from incomes where tran_date >= ? and tran_date <= ? and userid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, sdate);
			ps.setString(2, edate);
			ps.setInt(3,userid);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				IncomesPojo bank = new IncomesPojo();
				bank.setInc_id(rs.getInt("inc_id"));
				bank.setInc_ac(rs.getString("inc_ac"));
				bank.setTran_date(rs.getString("Tran_date"));
				bank.setInc_catid((rs.getInt("inc_catid")));
				bank.setReceiveby(rs.getString("receiveby"));
				bank.setRemark(rs.getString("remark"));
				bank.setAmount((rs.getDouble("amount")));
				bank.setUserid((rs.getInt("userid")));
				listCategory.add(bank);
			}
		} catch (SQLException sq) {
			System.out.println("unable to find the record." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listCategory;
	}
	public static void main(String args[]) {
//	IncomesDao d = new IncomesDao();
//	java.util.Date dt =  DateUtils.convertDate("23-10-1998");
//	IncomesPojo p = new IncomesPojo("ttgyewheh",223,637,78239,dt,"gujee","fyedhv");
//	d.create(p);
	
//	IncomesDao d = new IncomesDao();
//	java.util.Date dt =  DateUtils.convertDate("23-10-1998");
//	IncomesPojo p = new IncomesPojo(2,"ttgyewheh",223,637,78239,dt,"gujee","fyedhv");
//	d.edit(p);
	
	//IncomesDao d = new IncomesDao();
//	d.remove(2);
	
//		IncomesDao d = new IncomesDao();
//		IncomesPojo p = new IncomesPojo();
//	d.find(1);
//	System.out.println(p);
	
//	IncomesDao d = new IncomesDao();
//	ArrayList<IncomesPojo> al = d.findAll();
//	for (IncomesPojo category : al) {
//		System.out.println(category);
	
	//}
//	IncomesDao d = new IncomesDao();
//	ArrayList<IncomesPojo> al = d.findAll(223);
//	for (IncomesPojo category : al) {
//		System.out.println(category);
//	
//	}
	
	IncomesDao d = new IncomesDao();
	ArrayList<IncomesPojo> al = d.findAll("1998-01-15","2001-10-19",223);
	for (IncomesPojo category : al) {
		System.out.println(category);
	
	}
}
}
