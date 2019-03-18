package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojos.BankBookPojo;
import utilities.*;

public class BankBookDao {
	public void create(BankBookPojo bank) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into bank_book (tran_date,amount,operation) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, bank.getTran_date());
			ps.setDouble(2, bank.getAmount());
			
			ps.setString(3, bank.getOperation());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}
	
	public void edit(BankBookPojo bank) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update bank_book set  tran_date = ?, amount = ?, operation = ? where acid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1,bank.getTran_date());
			ps.setDouble(2, bank.getAmount());
			
			ps.setString(3, bank.getOperation());
			ps.setInt(4, bank.getAcid());
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
			String sql = "delete from bank_book where acid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bank);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}
	
	public BankBookPojo find(int acid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		BankBookPojo bank = new BankBookPojo();
		try {
			String sql = "select * from bank_book where acid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, acid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				bank.setAcid(acid);
				
				bank.setTran_date(rs.getString("tran_date"));
				bank.setAmount((rs.getDouble("amount")));
				
				bank.setOperation(rs.getString("operation"));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return bank;
	}
	public ArrayList<BankBookPojo> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<BankBookPojo> listCategory = new ArrayList<BankBookPojo>();
		try {
			String sql = "select * from bank_book";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BankBookPojo bank = new BankBookPojo();
				bank.setAcid(rs.getInt("acid"));
				bank.setTran_date(rs.getString("tran_date"));
				bank.setAmount((rs.getDouble("amount")));
				bank.setOperation(rs.getString("operation"));
				listCategory.add(bank);
			}
		} catch (SQLException sq) {
			System.out.println("unable to find the record." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listCategory;
	}
	
	public ArrayList<BankBookPojo> findAllDateWise(String sdate,String edate) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<BankBookPojo> listCategory = new ArrayList<BankBookPojo>();
		try {
			String sql = "select * from bank_book where tran_date>= ? and tran_date<= ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, sdate);
			ps.setString(2, edate);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BankBookPojo bank = new BankBookPojo();
				bank.setAcid(rs.getInt("acid"));
				bank.setTran_date(rs.getString("tran_date"));
				bank.setAmount((rs.getDouble("amount")));
				bank.setOperation(rs.getString("operation"));
				listCategory.add(bank);
			}
		} catch (SQLException sq) {
			System.out.println("unable to find the record." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listCategory;
	}
	
	public double closingBalance (int userid) {
		double closingBalance = 0;
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		if(conn != null) {
			try {
				String sql = "Select sum(amount) as totalpayment From bank_book where userid = ? and operation = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, userid);
				ps.setString(2, "receive");
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					closingBalance = rs.getDouble("totalpayment");
					}
				 sql = "Select sum(amount) as totalreceive From bank_book where userid = ? and operation = ?";
				 ps = conn.prepareStatement(sql);
				ps.setInt(1, userid);
				ps.setString(2, "pay");
				 rs = ps.executeQuery();
				if (rs.next()) {
					closingBalance = rs.getDouble("totalreceived");
					}
				}
			catch (SQLException sq) {
				System.out.println("unable to find the record." + sq);
			} finally {
				pool.putConnection(conn);
			}
		}
		return closingBalance;
		
	}
	
//	public double closingBalance(int userid) {
//		ConnectionPool pool = ConnectionPool.getInstance();
//		pool.initialize();
//		Connection conn = pool.getConnection();
//		try {
//			String sql = "select (select sum(amount) as total_payment "FROM" bank_book "b" where userid = 1 and operation
//					= "receive") - (select sum(amount) as total_received "FROM" bank_book "b" where userid = 1 and
//					operation='pay') as 'Closing Balance' from dual";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ResultSet rs = ps.executeQuery();
		
		
//	}

	public static void main(String args[]) {
		//BankBookDao d = new BankBookDao();
		//java.util.Date dt =  DateUtils.convertDate("23-10-1998");
		//BankBookPojo p = new BankBookPojo("0157cs161603",dt,200000.0,24,"save");
		//d.create(p);
		
		//java.util.Date dt =  DateUtils.convertDate("23-10-1997");
		//BankBookPojo p = new BankBookPojo (2,"6273hred5",dt,268383, 24,"current");
		//BankBookDao  cd = new BankBookDao(); 
		//cd.edit(p);
		
		//BankBookDao  cd = new BankBookDao();
		//cd.remove(2);
		
		//BankBookDao  cd = new BankBookDao();  
		//BankBookPojo p = new BankBookPojo ();
		//cd.find(1);
		//System.out.println(p);
		
		
//		BankBookDao  cd = new BankBookDao();
//		ArrayList<BankBookPojo> al = cd.findAll();
//		for (BankBookPojo category : al) {
//			System.out.println(category);
//		}
		
		
		BankBookDao  cd = new BankBookDao();
		ArrayList<BankBookPojo> al = cd.findAllDateWise("1998-01-15","2002-05-10");
		for (BankBookPojo category : al) {
			System.out.println(category);
		}
		
		
				
	}
}