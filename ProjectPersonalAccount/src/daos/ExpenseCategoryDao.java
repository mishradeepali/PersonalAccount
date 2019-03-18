package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import pojos.ExpensesCategoryPojo;
import utilities.ConnectionPool;

public class ExpenseCategoryDao {
	public void create(ExpensesCategoryPojo category) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into expenses_category (exp_catname, exp_catdetails,userid) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, category.getExp_catname());
			ps.setString(2, category.getExp_catdetails());
			ps.setInt(3, category.getUserid());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}
	

	public void edit(ExpensesCategoryPojo category) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update expenses_category set exp_catname = ?, exp_catdetails = ?,userid = ? where exp_catid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, category.getExp_catname());
			ps.setString(2, category.getExp_catdetails());
			ps.setInt(3, category.getUserid());
			ps.setInt(4, category.getExp_catid());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void remove(int exp_catid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from expenses_category where exp_catid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, exp_catid);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}
	
	public ExpensesCategoryPojo find(int exp_catid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ExpensesCategoryPojo category = new ExpensesCategoryPojo();
		try {
			String sql = "select * from expenses_category where exp_catid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, exp_catid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				category.setExp_catid(exp_catid);
				category.setExp_catname(rs.getString("exp_catname"));
				category.setExp_catdetails(rs.getString("exp_catdetails"));
				category.setUserid(rs.getInt("userid"));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return category;
	}

	public ArrayList<ExpensesCategoryPojo> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<ExpensesCategoryPojo> listCategory = new ArrayList<ExpensesCategoryPojo>();
		try {
			String sql = "select * from expenses_category";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ExpensesCategoryPojo category = new ExpensesCategoryPojo();
				category.setExp_catid(rs.getInt("exp_catid"));
				category.setExp_catname(rs.getString("exp_catname"));
				category.setExp_catdetails(rs.getString("exp_catdetails"));
				category.setUserid(rs.getInt("userid"));
				listCategory.add(category);
			}
		} catch (SQLException sq) {
			System.out.println("unable to find the record." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listCategory;
	}

	public ArrayList<ExpensesCategoryPojo> findAll(int userid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<ExpensesCategoryPojo> listCategory = new ArrayList<ExpensesCategoryPojo>();
		try {
			String sql = "select * from expenses_category where userid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ExpensesCategoryPojo category = new ExpensesCategoryPojo();
				category.setExp_catid(rs.getInt("exp_catid"));
				category.setExp_catname(rs.getString("exp_catname"));
				category.setExp_catdetails(rs.getString("exp_catdetails"));
				category.setUserid(rs.getInt("userid"));
				listCategory.add(category);
			}
		} catch (SQLException sq) {
			System.out.println("unable to find the record." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listCategory;
	}
		public static void main(String args[]) {
//			ExpenseCategoryDao d = new ExpenseCategoryDao();
//			ExpensesCategoryPojo p = new ExpensesCategoryPojo("footwear","shoes",16);
//			d.create(p);
			
//			ExpenseCategoryDao d = new ExpenseCategoryDao();
//	ExpensesCategoryPojo p = new ExpensesCategoryPojo(4,"cloth","kurti",58);
//		d.edit(p);
			
//			ExpenseCategoryDao d = new ExpenseCategoryDao();
//			d.remove(5);
//			
//			ExpenseCategoryDao d = new ExpenseCategoryDao();
//			ExpensesCategoryPojo p = new ExpensesCategoryPojo();
//			d.find(2);
//			System.out.println(p);
//			
		ExpenseCategoryDao d = new ExpenseCategoryDao();
		ArrayList<ExpensesCategoryPojo> al = d.findAll();
		for (ExpensesCategoryPojo category : al) {
			System.out.println(category);
		}
			
//			}
			
//			ExpenseCategoryDao d = new ExpenseCategoryDao();
//			ArrayList<ExpensesCategoryPojo> al = d.findAll(58);
//			for (ExpensesCategoryPojo category : al) {
//				System.out.println(category);
//		}
		}
}