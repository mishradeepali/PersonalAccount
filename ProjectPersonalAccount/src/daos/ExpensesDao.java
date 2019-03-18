package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojos.ExpensesPojo;
import utilities.*;
import pojos.ExpensesCategoryPojo;

public class ExpensesDao {
	public void create(ExpensesPojo bank) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into expenses (exp_ac,userid,exp_catid,amount,tran_date,payby,remark) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bank.getExp_ac());
			ps.setString(5, bank.getTran_date());
			ps.setInt(2, bank.getUserid());
			ps.setInt(3, bank.getExp_catid());
			ps.setDouble(4, bank.getAmount());
			ps.setString(6, bank.getPayby());
			ps.setString(7, bank.getRemark());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}
	
	public void edit(ExpensesPojo bank) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update expenses set exp_ac = ?,userid = ?,exp_catid = ?, amount = ?, tran_date = ?,payby = ?,remark = ? where exp_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bank.getExp_ac());
			
			ps.setString(5, bank.getTran_date());
			ps.setInt(2, bank.getUserid());
			ps.setInt(3, bank.getExp_catid());
			ps.setDouble(4, bank.getAmount());
			ps.setString(6, bank.getPayby());
			ps.setString(7, bank.getRemark());
			ps.setInt(8, bank.getExp_id());
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
			String sql = "delete from expenses where exp_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bank);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}
	
	public ExpensesPojo find(int acid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ExpensesPojo bank = new ExpensesPojo();
		try {
			String sql = "select * from expenses where exp_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, acid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				bank.setExp_id(acid);
				bank.setExp_ac(rs.getString("exp_ac"));
				
				bank.setTran_date(rs.getString("tran_date"));
				bank.setExp_catid((rs.getInt("exp_catid")));
				bank.setPayby(rs.getString("payby"));
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
	public ArrayList<ExpensesPojo> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<ExpensesPojo> listCategory = new ArrayList<ExpensesPojo>();
		try {
			String sql = "select * from expenses";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ExpensesPojo bank = new ExpensesPojo();
				bank.setExp_id(rs.getInt("exp_id"));
				bank.setExp_ac(rs.getString("exp_ac"));
				bank.setTran_date(rs.getString("tran_date"));
				bank.setExp_catid((rs.getInt("exp_catid")));
				bank.setPayby(rs.getString("payby"));
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
	
	public ArrayList<ExpensesPojo> findAll(int userid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<ExpensesPojo> listCategory = new ArrayList<ExpensesPojo>();
		try {
			String sql = "select * from expenses where userid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,userid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ExpensesPojo bank = new ExpensesPojo();
				bank.setExp_id(rs.getInt("exp_id"));
				bank.setExp_ac(rs.getString("exp_ac"));
				bank.setTran_date(rs.getString("tran_date"));
				bank.setExp_catid((rs.getInt("exp_catid")));
				bank.setPayby(rs.getString("payby"));
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
	
	public ArrayList<ExpensesPojo> findAll(String sdate,String edate,int userid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<ExpensesPojo> listCategory = new ArrayList<ExpensesPojo>();
		try {
			String sql = "select * from expenses where tran_date >= ? and tran_date <= ? and userid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, sdate);
			ps.setString(2, edate);
			ps.setInt(3,userid);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ExpensesPojo bank = new ExpensesPojo();
				bank.setExp_id(rs.getInt("exp_id"));
				bank.setExp_ac(rs.getString("exp_ac"));
				bank.setTran_date(rs.getString("tran_date"));
				bank.setExp_catid((rs.getInt("exp_catid")));
				bank.setPayby(rs.getString("payby"));
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
	ExpensesDao d = new ExpensesDao();
	ExpensesPojo p = new ExpensesPojo("ttgyewheh",648,1,78239,"2000-10-02","gujee","fyedhv");
	d.create(p);
	
//	ExpensesDao d = new ExpensesDao();
//	java.util.Date dt =  DateUtils.convertDate("23-10-1998");
//	ExpensesPojo p = new ExpensesPojo(2,"ttgyewheh",223,637,78239,dt,"gujee","fyedhv");
//	d.edit(p);
	
	//ExpensesDao d = new ExpensesDao();
//	d.remove(2);
	
//	ExpensesDao d = new ExpensesDao();
//	ExpensesPojo p = new ExpensesPojo();
//	d.find(1);
//	System.out.println(p);
	
//	ExpensesDao d = new ExpensesDao();
//	ArrayList<ExpensesPojo> al = d.findAll();
//	for (ExpensesPojo category : al) {
//		System.out.println(category);
	
//	}
//	ExpensesDao d = new ExpensesDao();
//	ArrayList<ExpensesPojo> al = d.findAll(223); 
//	for (ExpensesPojo category : al) {
//		System.out.println(category);
//	}
	
//	ExpensesDao d = new ExpensesDao();
//	ArrayList<ExpensesPojo> al = d.findAll("1998-01-15","2001-10-19",223);
//	for (ExpensesPojo category : al) {
//		System.out.println(category);
//	}
	}
}
