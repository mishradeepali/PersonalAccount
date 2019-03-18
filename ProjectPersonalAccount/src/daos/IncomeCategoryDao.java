package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojos.IncomeCategoryPojo;
import utilities.ConnectionPool;

public class IncomeCategoryDao {
	public void create(IncomeCategoryPojo category) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into income_category (inc_catname, inc_catdetails,userid) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, category.getInc_catname());
			ps.setString(2, category.getInc_catdetails());
			ps.setInt(3, category.getUserid());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void edit(IncomeCategoryPojo category) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update income_category set inc_catname = ?, inc_catdetails = ?,userid = ? where inc_catid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, category.getInc_catname());
			ps.setString(2, category.getInc_catdetails());
			ps.setInt(3, category.getUserid());
			ps.setInt(4, category.getInc_catid());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void remove(int inc_catid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from income_category where inc_catid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, inc_catid);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}
	
	public IncomeCategoryPojo find(int categoryId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		IncomeCategoryPojo category = new IncomeCategoryPojo();
		try {
			String sql = "select * from income_category where inc_catid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, categoryId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				category.setInc_catid(categoryId);
				category.setInc_catname(rs.getString("inc_catname"));
				category.setInc_catdetails(rs.getString("inc_catdetails"));
				category.setUserid(rs.getInt("userid"));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return category;
	}

	public ArrayList<IncomeCategoryPojo> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<IncomeCategoryPojo> listCategory = new ArrayList<IncomeCategoryPojo>();
		try {
			String sql = "select * from income_category";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				IncomeCategoryPojo category = new IncomeCategoryPojo();
				category.setInc_catid(rs.getInt("inc_catid"));
				category.setInc_catname(rs.getString("inc_catname"));
				category.setInc_catdetails(rs.getString("inc_catdetails"));
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

	public ArrayList<IncomeCategoryPojo> findAll(int userid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<IncomeCategoryPojo> listCategory = new ArrayList<IncomeCategoryPojo>();
		try {
			String sql = "select * from income_category where userid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				IncomeCategoryPojo category = new IncomeCategoryPojo();
				category.setInc_catid(rs.getInt("inc_catid"));
				category.setInc_catname(rs.getString("inc_catname"));
				category.setInc_catdetails(rs.getString("inc_catdetails"));
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
//			IncomeCategoryDao d = new IncomeCategoryDao();
//			IncomeCategoryPojo p = new IncomeCategoryPojo("job","ca",16);
//			d.create(p);
			
//			IncomeCategoryDao d = new IncomeCategoryDao();
//			IncomeCategoryPojo p = new IncomeCategoryPojo(3,"job","ca",18);
//			d.edit(p);
			
			IncomeCategoryDao d = new IncomeCategoryDao();
			d.remove(8);
			
//			IncomeCategoryDao d = new IncomeCategoryDao();
//			IncomeCategoryPojo p = new IncomeCategoryPojo();
//			d.find(2);
//			System.out.println(p);
			
//			IncomeCategoryDao d = new IncomeCategoryDao();
//			ArrayList<IncomeCategoryPojo> p = d.findAll();
//			for (IncomeCategoryPojo category : al) {
//			System.out.println(category);
//		}
			
//			IncomeCategoryDao d = new IncomeCategoryDao();
//			ArrayList<IncomeCategoryPojo> p = d.findAll(18);
//			for (IncomeCategoryPojo category : p) {
//			System.out.println(category);
//		}
		}		
}
