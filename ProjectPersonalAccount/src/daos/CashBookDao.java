package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojos.BankBookPojo;
import pojos.CashBookPojo;
import utilities.*;

public class CashBookDao {
	
		public void create(CashBookPojo cash) {
			ConnectionPool pool = ConnectionPool.getInstance();
			pool.initialize();
			Connection conn = pool.getConnection();
			try {
				String sql = "insert into cash_book (tran_date,amount,operation) values(?,?,?)";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, cash.getTran_date());
				
				ps.setDouble(2, cash.getAmount());
				
				ps.setString(3, cash.getOperation());
				ps.executeUpdate();
			} catch (SQLException sq) {
				System.out.println("Unable to create a new row." + sq);
			} finally {
				pool.putConnection(conn);
			}
		}
		
		public void edit(CashBookPojo bank) {
			ConnectionPool pool = ConnectionPool.getInstance();
			pool.initialize();
			Connection conn = pool.getConnection();
			try {
				String sql = "update cash_book set  tran_date = ?, amount = ?, operation = ? where acid = ?";
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
				String sql = "delete from cash_book where acid = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, bank);
				ps.executeUpdate();
			} catch (SQLException sq) {
				System.out.println("Unable to create a new row." + sq);
			} finally {
				pool.putConnection(conn);
			}
		}
		public ArrayList<CashBookPojo> findAllDateWise(String sdate,String edate) {
			ConnectionPool pool = ConnectionPool.getInstance();
			pool.initialize();
			Connection conn = pool.getConnection();
			ArrayList<CashBookPojo> listCategory = new ArrayList<CashBookPojo>();
			try {
				String sql = "select * from cash_book where tran_date>= ? and tran_date<= ? ";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, sdate);
				ps.setString(2, edate);
				
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					CashBookPojo bank = new CashBookPojo();
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
		
		public static void main(String args[]) {
					
			//CashBookDao d = new CashBookDao();
			//java.util.Date dt =  DateUtils.convertDate("23-10-1999");
			//CashBookPojo p = new CashBookPojo("0157cs1616343",dt,200000.0,29,"save");
			//d.create(p);
			
			
//			CashBookPojo p = new CashBookPojo (2,"6273hred5","",268383, 24,"current");
//			CashBookDao  cd = new CashBookDao(); 
//			cd.edit(p);
			
			//BankBookDao  cd = new BankBookDao();
			//cd.remove(2);
			
			//BankBookDao  cd = new BankBookDao();  
			//BankBookPojo p = new BankBookPojo ();
			//cd.find(1);
			//System.out.println(p);
			
			
			//BankBookDao  cd = new BankBookDao();
			//ArrayList<BankBookPojo> al = cd.findAll();
			//for (BankBookPojo category : al) {
				//System.out.println(category);
			//}
			
					
		}
}
